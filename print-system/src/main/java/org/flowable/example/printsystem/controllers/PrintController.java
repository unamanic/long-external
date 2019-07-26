package org.flowable.example.printsystem.controllers;

import lombok.extern.log4j.Log4j2;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.repository.Deployment;
import org.flowable.example.printsystem.domain.PrintRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Log4j2
public class PrintController {
    private final RuntimeService runtimeService;

    public PrintController(RepositoryService repositoryService, RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/print")
    String postPrintJob(@RequestBody PrintRequest printRequest) {
        log.error("Hello from the other side");

        Map<String, Object> variables = new HashMap<>();

        variables.put("callbackUrl", printRequest.getCallbackUrl());

        runtimeService.startProcessInstanceByKey("printServiceProcess", variables);
        return UUID.randomUUID().toString();
    }
}
