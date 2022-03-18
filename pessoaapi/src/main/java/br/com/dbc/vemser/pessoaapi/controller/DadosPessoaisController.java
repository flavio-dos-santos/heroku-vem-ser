package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;


    @ApiOperation(value = "Retornar uma lista de dados pessoais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "lista de dados pessoais"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return dadosPessoaisService.listDadosPessoais();
    }

    @ApiOperation(value = "Retornar um dados pessoas criados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "dados pessoas criados"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisService.create(dadosPessoaisDTO);
    }

    @ApiOperation(value = "Retornar um dado pessoal atualizado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "dados pessoais atualizados"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                          @RequestBody DadosPessoaisDTO dto) throws Exception {
        return dadosPessoaisService.update(cpf, dto);
    }

    @ApiOperation(value = "Retornar um dado pessoal por cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "dado pessoal por cpf"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return dadosPessoaisService.getByCpf(cpf);
    }


    @ApiOperation(value = "Retornar um dado pessoal deletado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "dado pessoal deletado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        dadosPessoaisService.delete(cpf);
    }
}
