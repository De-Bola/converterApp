package org.converter.controller;

import org.converter.model.UserData;
import org.converter.service.ConverterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = {"http://localhost:3001", "http://localhost:3000"})
@RestController
@RequestMapping(path = "/api/v1/converter", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConverterController {

    private ConverterService converterService;

    public ConverterController(ConverterService service) {
        this.converterService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getOutput(@RequestBody UserData userData) {
        UserData data = converterService.setUserData(userData);
        BigDecimal result = converterService.calculateFinalAmount(data);
        return String.valueOf(result);
    }
}
