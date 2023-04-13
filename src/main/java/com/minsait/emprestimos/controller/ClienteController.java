package com.minsait.emprestimos.controller;

import com.minsait.emprestimos.model.Cliente;
import com.minsait.emprestimos.resources.ClientGetRequestBody;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import com.minsait.emprestimos.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientGetRequestBody>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<ClientGetRequestBody> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clientService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClientPostRequestBody clientPostRequestBody){
        return ResponseEntity.ok(clientService.save(clientPostRequestBody));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
       clientService.delete(cpf);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> replace(@PathVariable String cpf, @RequestBody ClientPutRequestBody clientPutRequestBody){
        return ResponseEntity.ok(clientService.replace(cpf, clientPutRequestBody));
    }
}
