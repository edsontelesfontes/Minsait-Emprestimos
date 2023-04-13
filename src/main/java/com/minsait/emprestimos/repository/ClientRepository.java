package com.minsait.emprestimos.repository;

import com.minsait.emprestimos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
   Cliente findByCpf(String Cpf);
}
