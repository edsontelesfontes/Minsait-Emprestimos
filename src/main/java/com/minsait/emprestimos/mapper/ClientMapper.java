package com.minsait.emprestimos.mapper;

import com.minsait.emprestimos.model.Cliente;
import com.minsait.emprestimos.resources.ClientGetRequestBody;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    public abstract Cliente toClient(ClientPostRequestBody clientPostRequestBody);
    public abstract Cliente toClient(ClientGetRequestBody clientGetRequestBody);

    public abstract ClientGetRequestBody toClientGetResposne(Cliente cliente);
    public abstract List<ClientGetRequestBody> toClientGetResposneList(List<Cliente> cliente);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Cliente updateClient(ClientPutRequestBody ClientPutRequestBody, @MappingTarget Cliente cliente);



}
