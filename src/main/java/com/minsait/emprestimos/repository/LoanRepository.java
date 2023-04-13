package com.minsait.emprestimos.repository;

import com.minsait.emprestimos.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByCpfCliente(String cpf);

    Emprestimo findByIdAndCpfCliente(Long id, String cpf);
}
