package com.minsait.emprestimos.repository;

import com.minsait.emprestimos.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByCpf(String cpf);

    Loan findByIdAndCpf(Long id, String cpf);
}
