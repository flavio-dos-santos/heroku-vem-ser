package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
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
@RequestMapping("/contato") //localhost:8080/contato
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

//    public ContatoController(){
//        contatoService = new ContatoService();
//    }

    @ApiOperation(value = "Retornar um contato criado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "criou um contato"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws Exception{
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @ApiOperation(value = "Retornar uma lista de contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @ApiOperation(value = "Retornar um contato atualizado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "atualizar um contato"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoAtualizado) throws Exception{
        return contatoService.update(id, contatoAtualizado);
    }


    @ApiOperation(value = "Retornar um contato deletado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "deletou um contato"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idContato}")
    public ContatoDTO delete(@PathVariable("idContato") Integer id) throws Exception{
        return contatoService.delete(id);
    }


    @ApiOperation(value = "Retornar um contato por id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "listar contato com id da pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{byIdPessoa}")
    public Optional<ContatoDTO> listByIdPessoa(@Valid @RequestParam("idPessoa") Integer id) throws Exception {
        return contatoService.listByIdPessoa(id);
    }
}
