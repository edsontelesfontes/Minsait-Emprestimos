package com.minsait.emprestimos.service;

import com.minsait.emprestimos.enumeration.EnumClientType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnumClientTypeService {

    public List<String> findAll() {
        return Arrays.asList(EnumClientType.values().toString().toString());
    }
}
