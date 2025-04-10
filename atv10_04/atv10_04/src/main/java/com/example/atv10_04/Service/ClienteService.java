package com.example.atv10_04.Service;

import com.example.atv10_04.DTO.ClienteDTO;
import com.example.atv10_04.Entity.Cliente;
import com.example.atv10_04.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{

@Autowired
private ClienteRepository clienteRepository;


//converte clienteDTO em cliente
public Cliente fromDTO(ClienteDTO clienteDTO){
    Cliente cliente = new Cliente();
    cliente.setNome(clienteDTO.getNome());
    cliente.setSobrenome(clienteDTO.getSobrenome());
    cliente.setCpf(cliente.getCpf());

    return cliente;
}

public ClienteDTO toDTO(Cliente cliente){
    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setId(cliente.getIdCliente());
    clienteDTO.setNome(cliente.getNome());
    clienteDTO.setSobrenome(cliente.getSobrenome());
    clienteDTO.setCpf(cliente.getCpf());

    return clienteDTO;
}

public List<Cliente> getAll(){
    return clienteRepository.findAll();
}

public Optional<ClienteDTO> getById(Long id){
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    if(optionalCliente.isPresent()){
        return Optional.of(this.toDTO(optionalCliente.get()));
    }else {
        return Optional.empty();
    }
}

public ClienteDTO save(ClienteDTO clienteDTO){
    Cliente cliente = this.fromDTO(clienteDTO);
    Cliente clienteBd = clienteRepository.save(cliente);
    return this.toDTO(clienteBd);
}

public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO clienteDTO){
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    if(optionalCliente.isPresent()){
        Cliente cliente = optionalCliente.get();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());

        Cliente professorUpdate = clienteRepository.save(cliente);

        return Optional.of(this.toDTO(professorUpdate));
    }else {
        return Optional.empty();
    }
}

public boolean delete(Long id){
    if(clienteRepository.existsById(id)){
        clienteRepository.deleteById(id);
        return true;
    }else {
        return false;
    }
    }
}

