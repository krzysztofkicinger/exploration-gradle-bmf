package com.kicinger.exploration.gradle.documentation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@ConditionalOnProperty("${bmf.documentation.paths.index-redirection}")
@RequiredArgsConstructor
public class SwaggerIndexRedirectionController {

    private final SwaggerConfiguration configuration;

    @GetMapping("/")
    public RedirectView redirectIndexToSwaggerDocumentation() {
        return new RedirectView(configuration.getSwaggerIndexPath());
    }

}
