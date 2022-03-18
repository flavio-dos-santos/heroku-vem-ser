package br.com.dbc.vemser.pessoaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private String tipoContato;
    @NotEmpty
    @Size(min=9, max=13)
    private String numero;
    @NotEmpty
    private String descricao;
}
