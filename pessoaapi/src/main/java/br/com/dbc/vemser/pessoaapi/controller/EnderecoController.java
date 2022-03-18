package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> listarTodos(){
        return enderecoService.listarTodos();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO getByIdEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.getByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<EnderecoDTO> create (@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
                return ResponseEntity.ok(enderecoService.create(id,endereco));
    }

    @PutMapping("/{idEndereco}")
    @Validated
    public EnderecoDTO update(@PathVariable("idEndereco")Integer id,@Valid @RequestBody EnderecoCreateDTO enderecoAtualizado) throws Exception{
        return enderecoService.update(id,enderecoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public EnderecoDTO delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.delete(id);
    }


}
