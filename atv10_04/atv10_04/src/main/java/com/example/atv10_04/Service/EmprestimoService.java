package com.example.atv10_04.Service;

import com.example.atv10_04.DTO.EmprestimoDTO;
import com.example.atv10_04.Entity.Emprestimo;
import com.example.atv10_04.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;


    public List<Emprestimo> getAll(){
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoDTO> getById(Long id){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){
            EmprestimoDTO produtoDTO = new EmprestimoDTO();
            return Optional.of(produtoDTO.fromEmprestimo(optionalEmprestimo.get()));
        }else {
            return Optional.empty();
        }
    }

    public EmprestimoDTO create (EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = emprestimoDTO.toEmprestimo();
        emprestimo = emprestimoRepository.save(emprestimo);
        return emprestimoDTO.fromEmprestimo(emprestimo);
    }

    public Optional<EmprestimoDTO> updateEmprestimo(Long id, EmprestimoDTO emprestimoDTO){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){
            Emprestimo emprestimo = optionalEmprestimo.get();
            emprestimo.setDataInicial(emprestimoDTO.getDataInicial());
            emprestimo.setDataFinal(emprestimoDTO.getDataFinal());
            emprestimo.setLivros(emprestimoDTO.getLivros());
            emprestimo.setCliente(emprestimoDTO.getCliente());
            emprestimo = emprestimoRepository.save(emprestimo);
            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimo));
        }else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(emprestimoRepository.existsById(id)){
            emprestimoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}

