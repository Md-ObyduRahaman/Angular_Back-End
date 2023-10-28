package com.coderdot.controllers;

import com.coderdot.dto.BaseResponse;
import com.coderdot.dto.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> hello() throws JsonProcessingException {

        BaseResponse baseResponse = new BaseResponse();

        boolean flag=false;

        if (flag) {
            baseResponse.status = false;
            baseResponse.errorMsg = "Data  not found";
            baseResponse.errorCode = 4041;
            baseResponse.version="V.0.0.1";
            baseResponse.apiName="getVehicleSetting";
        } else {
            baseResponse.status = true;
            baseResponse.data = new HelloResponse("Hello from API");
            baseResponse.version="V.0.0.1";
            baseResponse.apiName="getVehicleSetting";
        }
        return ResponseEntity.ok().body(objectMapper.writeValueAsString(baseResponse));

    }

}
