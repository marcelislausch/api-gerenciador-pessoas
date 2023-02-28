/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.service;

import com.pessoas.models.PessoaModel;
import com.pessoas.repositories.PessoaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marceli Lausch
 */
@Service
@Transactional
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<PessoaModel> findByNome(String nome) {
        return pessoaRepository.findByNomeIgnoreCaseContaining(nome);
    }

//    @Transactional
    public PessoaModel save(PessoaModel bean) {
        return pessoaRepository.save(bean);
    }

//    @Transactional
    public void delete(PessoaModel bean) {
        pessoaRepository.delete(bean);
    }

}
