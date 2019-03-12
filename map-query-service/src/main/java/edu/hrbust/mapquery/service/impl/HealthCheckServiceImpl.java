package edu.hrbust.mapquery.service.impl;

import edu.hrbust.mapquery.service.HealthCheckService;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @Override
    public String CheckHealth() {
        return "OK";
    }
}
