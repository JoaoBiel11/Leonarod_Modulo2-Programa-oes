package com.example.atv10_04.DTO;

import com.example.atv10_04.Entity.Cliente;
import com.example.atv10_04.Entity.Emprestimo;
import com.example.atv10_04.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO implements Serializable {
    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Cliente cliente;
    private Set<Livro> livros;

    public Emprestimo toEmprestimo(){
        return new Emprestimo(
                this.id,
                this.dataInicial,
                this.dataFinal,
                this.getCliente(),
                this.livros
        );
    }

    public EmprestimoDTO fromEmprestimo(Emprestimo emprestimo){
        return new EmprestimoDTO(
                emprestimo.getId(),
                emprestimo.getDataInicial(),
                emprestimo.getDataFinal(),
                emprestimo.getCliente(),
                emprestimo.getLivros()
        );
    }
}

