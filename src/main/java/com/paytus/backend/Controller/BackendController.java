package com.paytus.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    @GetMapping("/api/main")
    public String main() {
        return "From Backend-main";
    } // Main은 OK

    @GetMapping("/api/payments")
    public String payments() {
        return "From Backend-payments";
    } // payments는 안됨
}
