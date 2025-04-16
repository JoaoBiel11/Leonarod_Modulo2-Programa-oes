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

public List<Cliente> getAll(){
    return clienteRepository.findAll();
}

public Optional<ClienteDTO> getById(Long id){
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    if(optionalCliente.isPresent()){
        ClienteDTO produtoDTO = new ClienteDTO();
        return Optional.of(produtoDTO.fromCliente(optionalCliente.get()));
    }else {
        return Optional.empty();
    }
}

public ClienteDTO create (ClienteDTO clienteDTO){
    Cliente cliente = clienteDTO.toCliente();
    cliente = clienteRepository.save(cliente);
    return clienteDTO.fromCliente(cliente);
}

public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO clienteDTO){
    Optional<Cliente> optionalCliente = clienteRepository.findById(id);
    if(optionalCliente.isPresent()){
        Cliente cliente = optionalCliente.get();
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente = clienteRepository.save(cliente);
        return Optional.of(clienteDTO.fromCliente(cliente));
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

