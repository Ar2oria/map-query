package edu.hrbust.mapquery.controller;

import edu.hrbust.mapquery.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe:
 * @package: edu.hrbust.mapquery.controller
 * @dateTime: 2019/3/12 0:56
 * @author: ar2oria
 */
@RestController
public class HealthCheckController {
    @Autowired
    private HealthCheckService healthCheckService;

    @RequestMapping("/healthCheck")
    public String healthCheck() {
        return healthCheckService.CheckHealth();
    }
}
