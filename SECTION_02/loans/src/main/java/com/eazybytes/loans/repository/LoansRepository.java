package com.eazybytes.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eazybytes.loans.entity.Loans;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long> {
    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);
}
