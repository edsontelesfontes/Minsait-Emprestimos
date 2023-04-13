package com.minsait.emprestimos.service;

import com.minsait.emprestimos.exception.ClientAlreadyExitsException;
import com.minsait.emprestimos.exception.ClientCantBeNullException;
import com.minsait.emprestimos.exception.ClientNotFoundException;
import com.minsait.emprestimos.mapper.ClientMapper;
import com.minsait.emprestimos.model.Cliente;
import com.minsait.emprestimos.repository.ClientRepository;
import com.minsait.emprestimos.resources.ClientGetRequestBody;
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

    public List<ClientGetRequestBody> findAll() {
        return ClientMapper.INSTANCE.toClientGetResposneList(clientReposity.findAll());
    }

    public ClientGetRequestBody findByCpf(String cpf) {
        Cliente cliente = clientReposity.findByCpf(cpf);
        if (cliente != null) {
            return ClientMapper.INSTANCE.toClientGetResposne(cliente);
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Transactional
    public Cliente save(ClientPostRequestBody clientPostRequestBody) {
        Cliente cliente = clientReposity.findByCpf(clientPostRequestBody.getCpf());
        if (cliente != null) {
            throw new ClientAlreadyExitsException("Unavailable to save, client already exists ", cliente.getCpf());
        }

        if (clientPostRequestBody != null) {
            return clientReposity.save(ClientMapper.INSTANCE.toClient(clientPostRequestBody));
        } else {
            throw new ClientCantBeNullException("Client can't be null");
        }

    }

    public void delete(String cpf) {
        clientReposity.delete(ClientMapper.INSTANCE.toClient(findByCpf(cpf)));
    }

    @Transactional
    public Cliente replace(String cpf, ClientPutRequestBody clientPutRequestBody) {
        Cliente clienteSaved = ClientMapper.INSTANCE.toClient(findByCpf(cpf));
        Cliente cliente = ClientMapper.INSTANCE.updateClient(clientPutRequestBody, clienteSaved);
        return clientReposity.save(cliente);
    }
}
