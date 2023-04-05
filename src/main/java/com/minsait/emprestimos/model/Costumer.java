package com.minsait.emprestimos.model;

import com.minsait.emprestimos.enumeration.EnumClientType;
import com.minsait.emprestimos.exception.ClientWithoutLimit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Costumer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Column(nullable = false)

    private String name;
    @Id
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    private BigDecimal salary;

   // @Enumerated(value = EnumType.ORDINAL)
    private EnumClientType clientType;

    @OneToMany(mappedBy = "cpf")
    private List<Loan> loan;

//    public BigDecimal getTotalLoan() {
//        BigDecimal sum = BigDecimal.ZERO;
//        for(Loan contract: loan){
//            sum.add(contract.getTotalAmount());
//        }
//        return sum;
//    }
//
//    public BigDecimal getLimit(){
//        BigDecimal totalInLoan = getTotalLoan();
//        BigDecimal salary = getSalary().multiply(new BigDecimal(10));
//
//        BigDecimal sum = totalInLoan.add(salary);
//
//        if(totalInLoan.compareTo(salary) >= -1){
//            return sum;
//        }else
//                // total emprestado é < salario, se for eu posso emprestar a diferença que é salario - total
//                //se não for eu jogo um erro que o emprestimo não pode ser maior
//            throw  new ClientWithoutLimit("No limit for loans is available !");
//    }
}
