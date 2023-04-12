package com.minsait.emprestimos.controller;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.service.EnumClientTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/clientes/enum")
@RequiredArgsConstructor
public class EnumClientTypeController {
    private final EnumClientTypeService enumClientTypeService;

    @GetMapping
    public ResponseEntity<List<String>> findAll(){
        return ResponseEntity.ok(Arrays.stream(EnumClientType.values())
                .map(EnumClientType::name)
                .collect(Collectors.toList()));
    }
}
