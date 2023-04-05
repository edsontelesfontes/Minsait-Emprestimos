package com.minsait.emprestimos.service;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.exception.ClientNotFoundException;
import com.minsait.emprestimos.exception.ClientWithoutLimit;
import com.minsait.emprestimos.exception.LoanCantBeEqualsZeroExeception;
import com.minsait.emprestimos.exception.LoanNotFoundException;
import com.minsait.emprestimos.mapper.LoanMapper;
import com.minsait.emprestimos.model.Costumer;
import com.minsait.emprestimos.model.Loan;
import com.minsait.emprestimos.repository.CostumerRepository;
import com.minsait.emprestimos.repository.LoanRepository;
import com.minsait.emprestimos.resources.LoanPostRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final CostumerRepository costumerRepository;

    public List<Loan> findAllLoanByCpf(String cpf) {
        List<Loan> loans = loanRepository.findByCpf(cpf);
        if (loans != null) {
            return loans;
        } else {
            throw new LoanNotFoundException("Loan(s) not found in CPF: ", cpf);
        }
    }

    public Loan findLoanById(String cpf, Long id) {
        Loan loan = loanRepository.findByIdAndCpf(id, cpf);
        if(loan != null){
            return loanRepository.findByIdAndCpf(id, cpf);
        }else{
            throw new LoanNotFoundException("Loan not found by id ");
        }

    }

    @Transactional
    public Loan saveLoan(String cpf, LoanPostRequestBody loanPostRequestBody) {
        Costumer costumer = costumerRepository.findByCpf(cpf);
        List<Loan> loans = loanRepository.findByCpf(cpf);
        loanPostRequestBody.setEnumClientType(costumer.getClientType());

        if (costumer != null && getLimit(cpf, loanPostRequestBody.getLoanAmount())) {
            Loan loanToSave = loanWithTax(LoanMapper.INSTANCE.toLoan(loanPostRequestBody), loans.size());
            loanToSave.setCpf(cpf);
            loanToSave.setEnumClientType(costumer.getClientType());
            System.out.println(loanToSave.toString());
            return loanRepository.save(loanToSave);
        } else {
            throw new ClientNotFoundException("Client with CPF %s not found, unavailable to create a loan.: ", cpf);
        }

    }

    @Transactional
    public void deleteLoan(String cpf, Long id) {
        loanRepository.delete(loanRepository.findByIdAndCpf(id, cpf));
    }


    public Loan loanWithTax(Loan loan, Integer totalLoans) {
        if (loan.getLoanAmount() != null || loan.getLoanAmount().equals(BigDecimal.ZERO)) {
            loan.setTotalAmount(loan.getEnumClientType().totalLoan(loan.getLoanAmount(), totalLoans));
        } else {
            throw new LoanCantBeEqualsZeroExeception("Amount can't be 0");
        }
        return loan;
    }

    public BigDecimal getTotalLoan(String cpf) {
        List<Loan> allLoans = loanRepository.findByCpf(cpf);
        Costumer costumer = costumerRepository.findByCpf(cpf);
        BigDecimal sum = new BigDecimal(0);

        for (Loan loans : allLoans) {
            if (loans.getLoanAmount().compareTo(loans.getLoanAmount()) >= 0) {
                System.out.println(loans.getLoanAmount());
                System.out.println("Caiu aqui no for each");
                sum = sum.add(loans.getLoanAmount());
            }

        }
        System.out.println("esse é o soma " + sum);
        return sum;
    }

    public Boolean getLimit(String cpf, BigDecimal loanAmout) {
        Costumer costumer = costumerRepository.findByCpf(cpf);

        BigDecimal totalInLoan = getTotalLoan(cpf);
        BigDecimal salary = costumer.getSalary().multiply(new BigDecimal(10));

        if (salary.compareTo(loanAmout) <= 0 && loanAmout.compareTo(totalInLoan) <= 0) {
            return true;
        } else
            throw new ClientWithoutLimit("No limit for a new loan !");

    }


}
