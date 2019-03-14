package edu.hrbust.mapquery.service.impl;

import edu.hrbust.mapquery.service.HealthCheckService;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @Override
    public String CheckHealth() {
        return "OK";
    }

    @Override
    public Long getCurrentPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        return Long.parseLong(pid);
    }
}
