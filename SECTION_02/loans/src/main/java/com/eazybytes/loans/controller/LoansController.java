package com.eazybytes.loans.controller;


import com.eazybytes.loans.constants.LoansConstants;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.dto.ResponseDto;
import com.eazybytes.loans.service.ILoansService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.net.http.HttpRequest;

@RestController
//@RequestMapping(path = "/loans",produces = "application/json")
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})

public class LoansController {
    @Autowired
    ILoansService iLoansService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> getloandetails(@RequestParam String mobileNumber) {
        iLoansService.createLoan(mobileNumber);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(LoansConstants.STATUS_201);
        responseDto.setStatusMessage("Loan created successfully.");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@RequestBody LoansDto loansDto) {
        boolean isUpdated = iLoansService.updateLoan(loansDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(LoansConstants.STATUS_201);
        responseDto.setStatusMessage("Loan updated successfully.");

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("fetch")
    public ResponseEntity<ResponseDto>fetchLoanDetails(String mobileNumber  ){

    }
}
