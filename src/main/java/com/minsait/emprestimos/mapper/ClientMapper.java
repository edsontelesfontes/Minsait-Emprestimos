package com.minsait.emprestimos.mapper;

import com.minsait.emprestimos.model.Client;
import com.minsait.emprestimos.resources.ClientGetRequestBody;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    public abstract Client toClient(ClientPostRequestBody clientPostRequestBody);
    public abstract Client toClient(ClientGetRequestBody clientGetRequestBody);

    public abstract ClientGetRequestBody toClientGetResposne(Client client);
    public abstract List<ClientGetRequestBody> toClientGetResposneList(List<Client> client);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract Client updateClient(ClientPutRequestBody ClientPutRequestBody, @MappingTarget Client client);



}
