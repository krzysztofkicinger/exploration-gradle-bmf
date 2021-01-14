package com.kicinger.exploration.gradle.documentation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "bmf.documentation")
public class SwaggerConfiguration {

    @JsonIgnore
    public static final String SWAGGER_INDEX_URL = "swagger/index.html?configUrl=";

    @JsonIgnore
    private Paths paths;
    @JsonIgnore
    private List<Version> versions;

    @JsonIgnore
    public SwaggerResponse toContract() {
        return new SwaggerResponse(paths.ui, paths.specification, versions);
    }

    public String getSwaggerIndexPath() {
        return SWAGGER_INDEX_URL + configUrlFromCurrentRequest();
    }

    private String configUrlFromCurrentRequest() {
        return fromCurrentRequest().cloneBuilder()
                .replacePath(paths.config)
                .build()
                .toString();
    }

    @Data
    public static class Paths {
        private boolean indexRedirection;
        private String ui;
        private String config;
        private String specification;
    }

    @Data
    public static class Version {
        private String name;
        private String url;
    }

    @Value
    public static class SwaggerResponse {
        String path;
        String url;
        List<Version> urls;
    }

}
