/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marceli Lausch
 */
public class PessoaDto {

    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
    private Date dataNascimento;
    private List<EnderecoDto> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
        this.enderecos = enderecos;
    }
    
    

}
