package com.example.controller;

import com.example.dto.ServiceTransDTO;
import com.example.service.ServiceTransService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    private final ServiceTransService serviceTransService;

    public ServiceController(ServiceTransService serviceTransService) {
        this.serviceTransService = serviceTransService;
    }


    @PostMapping()
    public void createService(@RequestBody @Valid ServiceTransDTO serviceTransDTO){
        serviceTransService.createService(serviceTransDTO);

    }
}
