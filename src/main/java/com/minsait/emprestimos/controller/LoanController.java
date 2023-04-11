package com.minsait.emprestimos.controller;

import com.minsait.emprestimos.model.Loan;
import com.minsait.emprestimos.resources.LoanGetRequestBody;
import com.minsait.emprestimos.resources.LoanPostRequestBody;
import com.minsait.emprestimos.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    @GetMapping(path = "/{cpf}/emprestimos")
    public ResponseEntity<List<LoanGetRequestBody>> findAllContractsByClient(@PathVariable String cpf){
        return ResponseEntity.ok(loanService.findAllLoanByCpf(cpf));
    }

    @GetMapping(path = "/{cpf}/emprestimos/{id}")
    public ResponseEntity<LoanGetRequestBody> findAllContractsByClient(@PathVariable String cpf, @PathVariable Long id){
        return ResponseEntity.ok(loanService.findLoanById(cpf, id));
    }
    @PostMapping(path = "/{cpf}/emprestimos")
    public ResponseEntity<Loan> saveLoan(@PathVariable String cpf, @RequestBody @Valid LoanPostRequestBody loanPostRequestBody){
        return ResponseEntity.ok(loanService.saveLoan(cpf, loanPostRequestBody));
    }

    @DeleteMapping(path = "/{cpf}/emprestimos/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable String cpf, @PathVariable Long id){
        loanService.deleteLoan(cpf,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
