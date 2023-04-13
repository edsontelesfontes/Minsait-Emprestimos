package com.minsait.emprestimos.mapper;

import com.minsait.emprestimos.model.Emprestimo;
import com.minsait.emprestimos.resources.LoanGetRequestBody;
import com.minsait.emprestimos.resources.LoanPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    public static final LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);
    public abstract Emprestimo toLoan(LoanPostRequestBody loanPostRequestBody);

    public abstract LoanGetRequestBody toLoanGetRequestBody(Emprestimo emprestimo);
    public abstract List<LoanGetRequestBody> toLoanGetRequestBody(List<Emprestimo> emprestimo);

}
