package com.example.atv10_04.Controller;

import com.example.atv10_04.DTO.ClienteDTO;
import com.example.atv10_04.Entity.Cliente;
import com.example.atv10_04.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id){
        Optional<ClienteDTO> clienteDTO = clienteService.getById(id);
        if(clienteDTO.isPresent()){
            return ResponseEntity.ok(clienteDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

//        return clienteDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> created(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO cliente = clienteService.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        Optional<ClienteDTO> clienteDTOOptional = clienteService.updateCliente(id, clienteDTO);
        if (clienteDTOOptional.isPresent()){
            return ResponseEntity.ok(clienteDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(clienteService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

