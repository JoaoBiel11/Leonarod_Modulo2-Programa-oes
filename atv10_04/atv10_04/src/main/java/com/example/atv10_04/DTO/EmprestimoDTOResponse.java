package com.example.atv10_04.DTO;

import com.example.atv10_04.Entity.Livro;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTOResponse {

    private Long idEmprestimo;
    private LocalDate data_inicial;
    private LocalDate data_final;
    private List<Livro> livros;
}
