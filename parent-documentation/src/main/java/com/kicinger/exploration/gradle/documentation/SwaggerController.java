package com.kicinger.exploration.gradle.documentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class SwaggerController {

    private final SwaggerConfiguration configuration;

    @GetMapping("${bmf.documentation.paths.ui}")
    public RedirectView swaggerUi() {
        return new RedirectView(configuration.getSwaggerIndexPath());
    }

    @GetMapping("${bmf.documentation.paths.config}")
    public SwaggerConfiguration.SwaggerResponse swaggerUiConfig() {
        return configuration.toContract();
    }


}
