package com.minsait.emprestimos.controller;

import com.minsait.emprestimos.model.Costumer;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import com.minsait.emprestimos.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @GetMapping
    public ResponseEntity<List<Costumer>> findAll() {
        return ResponseEntity.ok(costumerService.findAll());
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<Costumer> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(costumerService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Costumer> save(@RequestBody ClientPostRequestBody clientPostRequestBody){
        return ResponseEntity.ok(costumerService.save(clientPostRequestBody));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
       costumerService.delete(cpf);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{cpf}")
    public ResponseEntity<Costumer> replace(@PathVariable String cpf, @RequestBody ClientPutRequestBody clientPutRequestBody){
        return ResponseEntity.ok(costumerService.replace(cpf, clientPutRequestBody));
    }
}
