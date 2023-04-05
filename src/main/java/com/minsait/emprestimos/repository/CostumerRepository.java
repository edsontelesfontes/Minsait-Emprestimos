package com.minsait.emprestimos.repository;

import com.minsait.emprestimos.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
   Costumer findByCpf(String Cpf);
}
