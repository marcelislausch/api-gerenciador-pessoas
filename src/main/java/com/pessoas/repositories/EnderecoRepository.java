/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.repositories;

import com.pessoas.models.EnderecoModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marceli Lausch
 */
@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {//JpaRepository já possui save, update, delete, select pronto
       
    List<EnderecoModel> findByPessoa(Long pessoa_id);
    
}
