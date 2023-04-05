package com.minsait.emprestimos.mapper;

import com.minsait.emprestimos.model.Costumer;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CostumerMapper {
    public static final CostumerMapper INSTANCE = Mappers.getMapper(CostumerMapper.class);
    public abstract Costumer toClient(ClientPostRequestBody clientPostRequestBody);
    public abstract Costumer toClient(ClientPutRequestBody ClientPutRequestBody);
    public abstract Costumer toClient(ClientPutRequestBody ClientPutRequestBody, @MappingTarget Costumer costumer);



}
