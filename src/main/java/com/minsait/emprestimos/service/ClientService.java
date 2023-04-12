package com.minsait.emprestimos.service;

import com.minsait.emprestimos.exception.ClientAlreadyExitsException;
import com.minsait.emprestimos.exception.ClientCantBeNullException;
import com.minsait.emprestimos.exception.ClientNotFoundException;
import com.minsait.emprestimos.mapper.ClientMapper;
import com.minsait.emprestimos.model.Client;
import com.minsait.emprestimos.repository.ClientRepository;
import com.minsait.emprestimos.resources.ClientGetRequestBody;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
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
        Client client = clientReposity.findByCpf(cpf);
        if (client != null) {
            return ClientMapper.INSTANCE.toClientGetResposne(client);
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Transactional
    public Client save(ClientPostRequestBody clientPostRequestBody) {
        Client client = clientReposity.findByCpf(clientPostRequestBody.getCpf());
        if (client != null) {
            throw new ClientAlreadyExitsException("Unavailable to save, client already exists ", client.getCpf());
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
    public Client replace(String cpf, ClientPutRequestBody clientPutRequestBody) {
        Client clientSaved = ClientMapper.INSTANCE.toClient(findByCpf(cpf));
        Client client = ClientMapper.INSTANCE.updateClient(clientPutRequestBody, clientSaved);
        return clientReposity.save(client);
    }
}
