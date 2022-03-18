package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dtos.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> listarTodos(){
        log.info("chamou o método listarTodos Endereco!");
        return enderecoRepository.listarTodos()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws Exception{
        log.info("chamou o método getByIdEndereco Endereco!");
        Endereco enderecoById = enderecoRepository.delete(id);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoById, EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> listByIdPessoa(Integer id){
        log.info("chamou o método listByIdPessoa Endereco!");
        return enderecoRepository.listByIdPessoa(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer id , @Valid EnderecoCreateDTO enderecoCreate)throws Exception{
        log.info("chamou o método create Endereco!");

        Endereco endereco = objectMapper.convertValue(enderecoCreate, Endereco.class);

        Endereco enderecoCriado = enderecoRepository.create(id,endereco);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizado)throws Exception{
        log.info("chamou o método update Endereco!");

        Endereco endereco = objectMapper.convertValue(enderecoAtualizado, Endereco.class);

        Endereco enderecoAtt = enderecoRepository.update(id,endereco);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtt, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO delete(Integer id) throws Exception{
        log.info("chamou o método delete Endereco!");

        Endereco enderecoDeletado = enderecoRepository.delete(id);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoDeletado, EnderecoDTO.class);

        return enderecoDTO;
    }
}
