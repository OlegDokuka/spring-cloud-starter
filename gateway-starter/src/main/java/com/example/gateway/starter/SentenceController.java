package com.example.gateway.starter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SentenceController {

    @RequestMapping("/sentence")
    public String sentence() {
        // Return some cliched textual content
        return "sentence";
    }
}
