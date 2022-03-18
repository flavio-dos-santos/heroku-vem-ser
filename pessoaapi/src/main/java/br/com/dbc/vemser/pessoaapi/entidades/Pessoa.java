package br.com.dbc.vemser.pessoaapi.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pessoa {
    private Integer idPessoa;
    @NotEmpty
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @CPF
    String cpf;
    @Email
    private String email;

//    public Pessoa(){
//    }
//
//    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf){
//        this.idPessoa = idPessoa;
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//        this.cpf = cpf;
//    }
//
//    public Integer getIdPessoa() {
//        return idPessoa;
//    }
//
//    public void setIdPessoa(Integer idPessoa) {
//        this.idPessoa = idPessoa;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public LocalDate getDataNascimento() {
//        return dataNascimento;
//    }
//
//    public void setDataNascimento(LocalDate dataNascimento) {
//        this.dataNascimento = dataNascimento;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    @Override
//    public String toString() {
//        return "Pessoa{" +
//                "idPessoa=" + idPessoa +
//                ", nome='" + nome + '\'' +
//                ", dataNascimento=" + dataNascimento +
//                ", cpf='" + cpf + '\'' +
//                '}';
//    }
}
