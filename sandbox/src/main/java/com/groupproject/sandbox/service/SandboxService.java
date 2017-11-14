package com.groupproject.sandbox.service;

import com.groupproject.sandbox.domain.SandboxObject;
import org.springframework.stereotype.Service;

@Service
public class SandboxService {

    public SandboxObject getSandboxObject() {
        SandboxObject result = new SandboxObject();
        result.setContent("Hello world");
        return result;
    }
}
