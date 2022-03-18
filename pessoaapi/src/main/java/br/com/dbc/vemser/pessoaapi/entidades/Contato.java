package br.com.dbc.vemser.pessoaapi.controller.Entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    private String tipoContato;
    @NotEmpty
    @Size(min=9, max=13)
    private String numero;
    @NotEmpty
    private String descricao;




//    public Contato(Integer idContato, Integer idPessoa,String tipoContato, String numero, String descricao){
//        this.idContato = idContato;
//        this.idPessoa = idPessoa;
//        this.tipoContato = tipoContato;
//
//        this.numero = numero;
//        this.descricao = descricao;
//    }
//
//    public String getTipoContato() {
//        return tipoContato;
//    }
//
//    public void setTipoContato(String tipoContato) {
//        this.tipoContato = tipoContato;
//    }
//
//    public String getNumero() {
//        return numero;
//    }
//
//    public void setNumero(String numero) {
//        this.numero = numero;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public Integer getIdContato() {
//        return idContato;
//    }
//
//    public void setIdContato(Integer idContato) {
//        this.idContato = idContato;
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
//    @Override
//    public String toString() {
//        return "Contato{" +
//                "tipoContato='" + tipoContato + '\'' +
//                ", numero='" + numero + '\'' +
//                ", descricao='" + descricao + '\'' +
//                '}';
//    }
}
