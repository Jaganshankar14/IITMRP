package com.demofeign.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demofeign.Controller.*;
import com.demofeign.feignclient.ApiClient;
 

@RestController
@RequestMapping(value = "/airlines")
public class AirlineController {
    private final ApiClient apiClient;
    
    public AirlineController (ApiClient apiClient) {
    	this.apiClient = apiClient;
    }
    @GetMapping
    public ResponseEntity readAirlineData (@RequestParam(required = false) String airlineId) {
        if (airlineId == null) {
            return ResponseEntity.ok(apiClient.readAirLines());
        }
        return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
    }
}