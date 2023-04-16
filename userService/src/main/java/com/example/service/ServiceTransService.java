package com.example.service;

import com.example.dto.ServiceTransDTO;
import com.example.entity.ServiceTrans;
import com.example.repo.ServiceTransRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransService {
    @Autowired
    private  ServiceTransRepo serviceRepo;




    public ServiceTrans createService (ServiceTransDTO sDto){
        ServiceTrans service = new ServiceTrans();
        BeanUtils.copyProperties(sDto, service);
        serviceRepo.save(service);
        return  service;
    }
}
