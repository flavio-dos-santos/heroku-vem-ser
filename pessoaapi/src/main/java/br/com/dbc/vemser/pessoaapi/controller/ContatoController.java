package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
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

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws Exception{
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoAtualizado) throws Exception{
        return contatoService.update(id, contatoAtualizado);
    }

    @DeleteMapping("/{idContato}")
    public ContatoDTO delete(@PathVariable("idContato") Integer id) throws Exception{
        return contatoService.delete(id);
    }

    @GetMapping("/{byIdPessoa}")
    public Optional<ContatoDTO> listByIdPessoa(@Valid @RequestParam("idPessoa") Integer id) throws Exception {
        return contatoService.listByIdPessoa(id);
    }
}
