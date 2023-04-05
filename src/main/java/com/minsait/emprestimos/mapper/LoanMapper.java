package com.minsait.emprestimos.mapper;

import com.minsait.emprestimos.model.Costumer;
import com.minsait.emprestimos.model.Loan;
import com.minsait.emprestimos.resources.ClientPostRequestBody;
import com.minsait.emprestimos.resources.ClientPutRequestBody;
import com.minsait.emprestimos.resources.LoanPostRequestBody;
import com.minsait.emprestimos.resources.LoanPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    public static final LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);
    public abstract Loan toLoan(LoanPostRequestBody loanPostRequestBody);
    public abstract Loan toLoan(LoanPutRequestBody loanPutRequestBody);
    public abstract Loan toLoan(LoanPutRequestBody loanPutRequestBody, @MappingTarget Loan loan);



}
