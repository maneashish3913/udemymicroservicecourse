package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;

public interface ILoansService {
    public void createLoan(String mobileNumber);
    public boolean updateLoan(LoansDto loansDto);
}
