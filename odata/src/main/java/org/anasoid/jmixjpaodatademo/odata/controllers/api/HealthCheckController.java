package org.anasoid.jmixjpaodatademo.odata.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthCheckController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    public String healthCheck() {
        logger.info("Health check called");
        return "Health check";
    }

}