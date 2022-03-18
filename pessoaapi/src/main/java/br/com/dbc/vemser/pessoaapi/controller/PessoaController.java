package br.com.dbc.vemser.pessoaapi.controller;




import br.com.dbc.vemser.pessoaapi.dtos.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")// localhost:8080/pessoa
@Validated
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

//    public PessoaController(){
//        pessoaService = new PessoaService();
//    }

    @GetMapping("/Hello")// localhost:8080/pessoa/hello
    public String hello(){
        return "hello World!";
    }

    @ApiOperation(value = "Retorna uma pessoa criada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping// localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @ApiOperation(value = "Retornar uma pessoa por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas por nome"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/listByName") // localhost:8080/pessoa/byname?nome=Rafa
    public Optional<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @ApiOperation(value = "Retornar uma pessoa Atualizada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                 @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @ApiOperation(value = "Retornar uma pessoa deletada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public PessoaDTO delete(@PathVariable("idPessoa") Integer id) throws Exception {
      return  pessoaService.delete(id);
    }



}
