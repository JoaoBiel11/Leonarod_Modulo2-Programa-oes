package com.example.atv10_04.DTO;


import com.example.atv10_04.Entity.Cliente;
import com.example.atv10_04.Entity.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente toCliente(){
        return new Cliente(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf
        );
    }

    public ClienteDTO fromCliente(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getCpf()
        );
    }
}
