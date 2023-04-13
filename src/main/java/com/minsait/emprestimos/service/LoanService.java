package com.minsait.emprestimos.service;

import com.minsait.emprestimos.exception.ClientNotFoundException;
import com.minsait.emprestimos.exception.ClientWithoutLimit;
import com.minsait.emprestimos.exception.LoanCantBeEqualsZeroExeception;
import com.minsait.emprestimos.exception.LoanNotFoundException;
import com.minsait.emprestimos.mapper.LoanMapper;
import com.minsait.emprestimos.model.Cliente;
import com.minsait.emprestimos.model.Emprestimo;
import com.minsait.emprestimos.repository.ClientRepository;
import com.minsait.emprestimos.repository.LoanRepository;
import com.minsait.emprestimos.resources.LoanGetRequestBody;
import com.minsait.emprestimos.resources.LoanPostRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final ClientRepository clientRepository;

    public List<LoanGetRequestBody> findAllLoanByCpf(String cpf) {
        List<Emprestimo> emprestimos = loanRepository.findByCpfCliente(cpf);
        if (emprestimos != null) {
            return LoanMapper.INSTANCE.toLoanGetRequestBody(emprestimos);
        } else {
            throw new LoanNotFoundException("Loan(s) not found in CPF: ", cpf);
        }
    }

    public LoanGetRequestBody findLoanById(String cpf, Long id) {
        Emprestimo emprestimo = loanRepository.findByIdAndCpfCliente(id, cpf);
        if (emprestimo != null) {
            return LoanMapper.INSTANCE.toLoanGetRequestBody(loanRepository.findByIdAndCpfCliente(id, cpf));
        } else {
            throw new LoanNotFoundException("Loan not found by id ");
        }

    }

    @Transactional
    public Emprestimo saveLoan(String cpf, LoanPostRequestBody loanPostRequestBody) {
        Cliente cliente = clientRepository.findByCpf(cpf);
        List<Emprestimo> emprestimos = loanRepository.findByCpfCliente(cpf);
        loanPostRequestBody.setRelacionamento(cliente.getRelacionamento());

        if (cliente != null && getLimit(cpf, loanPostRequestBody.getValorInicial())) {
            Emprestimo emprestimoToSave = loanWithTax(LoanMapper.INSTANCE.toLoan(loanPostRequestBody), emprestimos.size());
            emprestimoToSave.setCpfCliente(cpf);
            emprestimoToSave.setRelacionamento(cliente.getRelacionamento());
            return loanRepository.save(emprestimoToSave);
        } else {
            throw new ClientNotFoundException("Client with CPF %s not found, unavailable to create a loan.: ", cpf);
        }

    }

    @Transactional
    public void deleteLoan(String cpf, Long id) {
        loanRepository.delete(loanRepository.findByIdAndCpfCliente(id, cpf));
    }


    public Emprestimo loanWithTax(Emprestimo emprestimo, Integer totalLoans) {
        if (emprestimo.getValorInicial() != null || emprestimo.getValorInicial().equals(BigDecimal.ZERO)) {
            emprestimo.setValorFinal(emprestimo.getRelacionamento().totalLoan(emprestimo.getValorInicial(), totalLoans));
        } else {
            throw new LoanCantBeEqualsZeroExeception("Amount can't be 0");
        }
        return emprestimo;
    }

    public BigDecimal getTotalLoan(String cpf) {
        List<Emprestimo> allEmprestimos = loanRepository.findByCpfCliente(cpf);

        BigDecimal sum = new BigDecimal(0, MathContext.DECIMAL32);

        for (Emprestimo loans : allEmprestimos) {
            sum = sum.add(loans.getValorInicial());
        }
        return sum;
    }

    public Boolean getLimit(String cpf, BigDecimal loanAmount) {
        Cliente cliente = clientRepository.findByCpf(cpf);

        BigDecimal totalLoans = getTotalLoan(cpf);
        BigDecimal salary = cliente.getRendimentoMensal().multiply(new BigDecimal(10), MathContext.DECIMAL32);
        //if (loanAmout.compareTo(salary) < 0 && totalInLoan.compareTo(loanAmout) < 0) {
        if (loanAmount.compareTo(salary) <= 0 && totalLoans.add(loanAmount).compareTo(salary) <= 0) {
            return true;
        } else {
            throw new ClientWithoutLimit("No limit for a new loan !");
        }
    }
}

