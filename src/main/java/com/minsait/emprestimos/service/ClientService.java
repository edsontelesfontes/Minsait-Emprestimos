package com.minsait.emprestimos.service;

import com.minsait.emprestimos.exception.ClientCantBeNullException;
import com.minsait.emprestimos.exception.ClientNotFoundException;
import com.minsait.emprestimos.mapper.CostumerMapper;
import com.minsait.emprestimos.model.Client;
import com.minsait.emprestimos.repository.ClientRepository;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientReposity;

    public List<Client> findAll() {
        return clientReposity.findAll();
    }

    public Client findByCpf(String cpf) {
        Client client = clientReposity.findByCpf(cpf);

        if(client != null){
            return client;
        }else {
            throw new ClientNotFoundException("Client not fount");
        }
        // return clientReposity.findByCpf(cpf);
    }

    @Transactional
    public Client save(ClientPostRequestBody clientPostRequestBody) {
        System.out.println(clientPostRequestBody.toString());
        Client client = CostumerMapper.INSTANCE.toClient(clientPostRequestBody);
        if(client != null){
            return clientReposity.save(client);
        }else {
            throw new ClientCantBeNullException("Client can't be null");
        }
    //   return clientReposity.save(CostumerMapper.INSTANCE.toClient(clientPostRequestBody));
    }

    public void delete(String cpf) {
        clientReposity.delete(findByCpf(cpf));
    }

    @Transactional
    public Client replace(String cpf, ClientPutRequestBody clientPutRequestBody) {
        Client clientSaved = findByCpf(cpf);
        System.out.println(clientPutRequestBody.toString());
        Client client = CostumerMapper.INSTANCE.toClient(clientPutRequestBody);
        return clientReposity.save(client);
    }
}
