/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.controllers;

import com.pessoas.dtos.EnderecoDto;
import com.pessoas.dtos.PessoaDto;
import com.pessoas.models.EnderecoModel;
import com.pessoas.models.PessoaModel;
import com.pessoas.service.EnderecoService;
import com.pessoas.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.http.MediaType;

/**
 *
 * @author Marceli Lausch
 */
@RestController
@RequestMapping("/pessoa")
@Api(value = "PessoaController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    @ApiOperation(value = "Criar uma pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid PessoaDto pessoaDto) {
        PessoaModel pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setEnderecos(new ArrayList<>());
        for (EnderecoDto enderecoDto : pessoaDto.getEnderecos()) {
            EnderecoModel enderecoModel = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDto, enderecoModel);
            pessoaModel.addEnderecos(enderecoModel);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Editar uma pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, @RequestBody @Valid PessoaDto pessoaDto) {
        Optional<PessoaModel> pessoaExiste = pessoaService.findById(id);
        if (!pessoaExiste.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");
        }
        PessoaModel pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setId_pessoa(pessoaExiste.get().getId_pessoa());
        pessoaModel.setEnderecos(new ArrayList<>());
        for (EnderecoDto enderecoDto : pessoaDto.getEnderecos()) {
            EnderecoModel enderecoModel = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDto, enderecoModel);
            pessoaModel.addEnderecos(enderecoModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar uma pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Long id) {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if (!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa " + id + " não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());
    }

    @GetMapping
    @ApiOperation(value = "Listar pessoas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PessoaModel>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Excluir uma pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> excluir(@PathVariable(value = "id") Long id) {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);
        if (!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa " + id + " não encontrada.");
        }
        pessoaService.delete(pessoaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa " + id + " deletada com sucesso.");
    }

}
