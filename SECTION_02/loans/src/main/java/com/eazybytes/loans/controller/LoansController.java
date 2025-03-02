package com.eazybytes.loans.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.AbstractDocument;
import java.net.http.HttpRequest;

@RestController
//@RequestMapping(path = "/loans",produces = "application/json")
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})

public class LoansController {

    @GetMapping("/getloandetails")
    public String getloandetails(HttpRequest httpRequest){
        return "ashish is coding to became most successful human being in the generation";
    }
}
