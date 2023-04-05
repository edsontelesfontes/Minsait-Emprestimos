package com.minsait.emprestimos.service;

import com.minsait.emprestimos.mapper.CostumerMapper;
import com.minsait.emprestimos.model.Costumer;
import com.minsait.emprestimos.repository.CostumerRepository;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CostumerService {
    private final CostumerRepository clientReposity;

    public List<Costumer> findAll() {
        return clientReposity.findAll();
    }

    public Costumer findByCpf(String cpf) {
        return clientReposity.findByCpf(cpf);
    }

    @Transactional
    public Costumer save(ClientPostRequestBody clientPostRequestBody) {
        System.out.println(clientPostRequestBody.toString());
        Costumer costumer = CostumerMapper.INSTANCE.toClient(clientPostRequestBody);
    //   return clientReposity.save(CostumerMapper.INSTANCE.toClient(clientPostRequestBody));
        return clientReposity.save(costumer);
    }

    public void delete(String cpf) {
        clientReposity.delete(findByCpf(cpf));
    }

    @Transactional
    public Costumer replace(String cpf, ClientPutRequestBody clientPutRequestBody) {
        Costumer costumerSaved = findByCpf(cpf);
        System.out.println(clientPutRequestBody.toString());
        Costumer costumer = CostumerMapper.INSTANCE.toClient(clientPutRequestBody);
        return clientReposity.save(costumer);
    }
}
