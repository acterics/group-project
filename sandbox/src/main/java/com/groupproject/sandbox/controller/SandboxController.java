package com.groupproject.sandbox.controller;

import com.groupproject.sandbox.domain.SandboxObject;
import com.groupproject.sandbox.service.SandboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SandboxController {

    private final SandboxService sandboxService;

    @Autowired
    public SandboxController(SandboxService sandboxService) {
        this.sandboxService = sandboxService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public SandboxObject getSandboxObject() {
        return sandboxService.getSandboxObject();
    }

}
