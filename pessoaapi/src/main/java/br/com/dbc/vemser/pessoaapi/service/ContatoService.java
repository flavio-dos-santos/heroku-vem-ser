package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.controller.Entidades.Contato;
import br.com.dbc.vemser.pessoaapi.dtos.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dtos.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

//    public ContatoService(){
//        contatoRepository = new ContatoRepository();
//    }


public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreate) throws Exception {
    log.info("chamou o método create Contato!");

    Contato contato = objectMapper.convertValue(contatoCreate, Contato.class);

    Contato contatoCriado = contatoRepository.create(id,contato);

    ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

    return contatoDTO;
}


    public List<ContatoDTO> list(){
        log.info("chamou o método list Contato!");
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizado) throws Exception{
        log.info("chamou o método update Contato!");

        Contato contato = objectMapper.convertValue(contatoAtualizado, Contato.class);

        Contato contatoAtt = contatoRepository.update(id,contato);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoAtt, ContatoDTO.class);

        return contatoDTO;
    }

    public ContatoDTO delete(Integer id) throws Exception{
        log.info("chamou o método delete Contato!");
        Contato contatoDeletado = contatoRepository.delete(id);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoDeletado, ContatoDTO.class);

        return contatoDTO;
    }



        public Optional<ContatoDTO> listByIdPessoa(Integer id) throws Exception {
            log.info("chamou o método listByIdPessoa Contato!");
            return pessoaRepository.listByName(String.valueOf(id))
                    .stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, ContatoDTO.class))
                    .findFirst();
      }
}

