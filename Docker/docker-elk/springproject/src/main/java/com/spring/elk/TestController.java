package com.spring.elk;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/")
public class TestController {

    @GetMapping
    public ResponseEntity test() {
        log.trace("Logging at TRACE level 6456trytr");
        log.debug("Logging at DEBUG level tbertyen");
        log.info("Logging at INFO level rgynj5674");
        log.warn("Logging at WARN level ynert87.0");
        log.error("Logging at ERROR level tnyr7567m");

        return ResponseEntity.ok("Test: ok!");
    }
}
