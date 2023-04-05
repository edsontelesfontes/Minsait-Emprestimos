package com.minsait.emprestimos.repository;

import com.minsait.emprestimos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
   Client findByCpf(String Cpf);
}
