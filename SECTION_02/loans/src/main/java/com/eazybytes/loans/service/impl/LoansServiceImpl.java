package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.LoansApplication;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.exceptions.LoanAlreadyExistsException;
import com.eazybytes.loans.exceptions.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoansMapper;
import com.eazybytes.loans.repository.LoansRepository;
import com.eazybytes.loans.service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import com.eazybytes.loans.constants.LoansConstants;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoansServiceImpl implements ILoansService {

    @Autowired
    LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> loan = loansRepository.findByMobileNumber(mobileNumber);
        if (loan.isPresent()) {
            throw new LoanAlreadyExistsException("Loan is already taken for this mobile number.");
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }


    public Loans createNewLoan(String MobileNumber) {
        Loans loan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);

        loan.setLoanNumber(Long.toString(randomLoanNumber));
        loan.setMobileNumber(MobileNumber);
        loan.setLoanType(LoansConstants.HOME_LOAN);
        loan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return loan;
    }


    @Override
    public boolean updateLoan(LoansDto loansDto) {
//       loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(()->new ResourceNotFoundException("loan","loanNumber",loansDto.getLoanNumber()));
        Optional<Loans> loan = loansRepository.findByLoanNumber(loansDto.getLoanNumber());
        if (loan.isEmpty()) {
            throw new ResourceNotFoundException("loan", "loanNumber", loansDto.getLoanNumber());
        }
        loansRepository.save(LoansMapper.mapToLoans(loansDto, new Loans()));
        return true;
    }


}
