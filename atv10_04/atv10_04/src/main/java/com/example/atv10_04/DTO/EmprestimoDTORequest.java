package com.example.atv10_04.DTO;

import com.example.atv10_04.Entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTORequest {

    private LocalDate data_inicial;
    private LocalDate data_final;
    private Cliente cliente;
}


