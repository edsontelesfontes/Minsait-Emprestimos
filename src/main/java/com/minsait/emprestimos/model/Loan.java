package com.minsait.emprestimos.model;

import com.minsait.emprestimos.enumeration.EnumClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tb_loans")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    @OneToMany(mappedBy = "id_contract")
//    private Set<LoanContract> loanContracts;

    @JoinColumn(name = "cpf_client")
    private String cpf;
    private BigDecimal totalAmount;
    private BigDecimal loanAmount;
    //
    private EnumClientType enumClientType;
//
//    public void loanWithTax(){
//        if(this.loanAmount != null){
//            this.totalAmount = this.enumClientType.totalLoan(loanAmount);
//        }
//    }
//
//    @Enumerated(EnumType.ORDINAL)
//    private EnumClientType clientType;

    //private BigDecimal valorFinal;

//    public BigDecimal getTotalLoan() {
//        BigDecimal sum = BigDecimal.ZERO;
//        for(LoanContract contract: loanContracts){
//            sum.add(contract.getTotalAmount());
//    }
//        return sum;
//    }
//
//    public BigDecimal getLimit(){
//        BigDecimal totalInLoan = getTotalLoan();
//        BigDecimal salary = client.getSalary().multiply(new BigDecimal(10));
//
//        BigDecimal sum = totalInLoan.add(salary);
//
//        if(totalInLoan.compareTo(salary) >= -1){
//            return sum;
//        }else
//        // total emprestado é < salario, se for eu posso emprestar a diferença que é salario - total
//        //se não for eu jogo um erro que o emprestimo não pode ser maior
//        return sum;
//    }

}
