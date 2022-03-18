package br.com.dbc.vemser.pessoaapi.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;
    @NotNull
    @Min(1)
    private int numero;
    @NotEmpty
    @Size(min=1,max=8)
    private String cep;
    @NotEmpty
    @Size(min = 1,max=250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;

//    public Endereco(Integer idEndereco, Integer idPessoa , String tipo, String logradouro, int numero,String cep, String cidade, String estado, String pais){
//        this.idEndereco = idEndereco;
//        this.idPessoa = idPessoa;
//        this.tipo = tipo;
//        this.logradouro =  logradouro;
//        this.numero = numero;
//        this.cep = cep;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
//    }
//
//    public Integer getIdEndereco() {
//        return idEndereco;
//    }
//
//    public void setIdEndereco(Integer idEndereco) {
//        this.idEndereco = idEndereco;
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
//    public String getLogradouro() {
//        return logradouro;
//    }
//
//    public void setLogradouro(String logradouro) {
//        this.logradouro = logradouro;
//    }
//
//    public int getNumero() {
//        return numero;
//    }
//
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getCep() {
//        return cep;
//    }
//
//    public void setCep(String cep) {
//        this.cep = cep;
//    }
//
//    public String getPais() {
//        return pais;
//    }
//
//    public void setPais(String pais) {
//        this.pais = pais;
//    }
//
//    @Override
//    public String toString() {
//        return "Endereco{" +
//                "idEndereco=" + idEndereco +
//                ", idPessoa=" + idPessoa +
//                ", tipo='" + tipo + '\'' +
//                ", logradouro='" + logradouro + '\'' +
//                ", numero=" + numero +
//                ", cep='" + cep + '\'' +
//                ", cidade='" + cidade + '\'' +
//                ", estado='" + estado + '\'' +
//                ", pais='" + pais + '\'' +
//                '}';
//    }
}
