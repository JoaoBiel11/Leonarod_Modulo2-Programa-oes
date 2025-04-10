package com.example.atv10_04.Service;

import com.example.atv10_04.DTO.EmprestimoDTORequest;
import com.example.atv10_04.DTO.EmprestimoDTOResponse;
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

    public Emprestimo fromDTO(EmprestimoDTORequest emprestimoDTORequest){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData_inicial(emprestimoDTORequest.getData_inicial());
        emprestimo.setData_final(emprestimoDTORequest.getData_final());

        return emprestimo;
    }


    public EmprestimoDTOResponse toDTO(Emprestimo emprestimo) {
        EmprestimoDTOResponse emprestimoDTOResponse = new EmprestimoDTOResponse();
        emprestimoDTOResponse.setData_inicial(emprestimo.getData_inicial());
        emprestimoDTOResponse.setIdEmprestimo(emprestimo.getIdEmprestimo());
        emprestimoDTOResponse.setData_final(emprestimo.getData_final());

        return emprestimoDTOResponse;
    }

    public List<Emprestimo> getAll(){
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoDTOResponse> getById(Long id){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){
            return Optional.of(this.toDTO(optionalEmprestimo.get()));
        }else {
            return Optional.empty(); //
        }
    }

    public EmprestimoDTOResponse saveDto(EmprestimoDTORequest emprestimoDTORequest){
        Emprestimo emprestimo = this.fromDTO(emprestimoDTORequest);
        Emprestimo emprestimoBd = emprestimoRepository.save(emprestimo);
        return this.toDTO(emprestimoBd);
    }

    public Optional<EmprestimoDTOResponse> updateEmprestimo(Long id, EmprestimoDTORequest emprestimoDTORequest){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){
            Emprestimo emprestimo = optionalEmprestimo.get();
            emprestimo.setData_inicial(emprestimoDTORequest.getData_inicial());
            emprestimo.setData_final(emprestimoDTORequest.getData_final());
            emprestimo.setCliente(emprestimoDTORequest.getCliente());

            Emprestimo emprestimoUpdate = emprestimoRepository.save(emprestimo);

            return Optional.of(this.toDTO(emprestimoUpdate));
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
