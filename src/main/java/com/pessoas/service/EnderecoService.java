/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.service;

import com.pessoas.models.EnderecoModel;
import com.pessoas.repositories.EnderecoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marceli Lausch
 */
@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    
    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public EnderecoModel save(EnderecoModel bean) {
        return enderecoRepository.save(bean);
    }

    public void delete(EnderecoModel bean) {
        enderecoRepository.delete(bean);
    }

}
