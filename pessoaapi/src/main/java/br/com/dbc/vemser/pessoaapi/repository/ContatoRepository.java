package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.controller.Entidades.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public ContatoRepository(){
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1,"residencial","998745612", "whats"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),1,"comercial","998741452", "skipe"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),2,"residencial","998555612", "whats"));
    }

    public Contato create(Integer id, Contato contato){
        contato.setIdPessoa(id);
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list(){
        return listaContatos;
    }

    public Contato update(Integer id,Contato contatoAtualizar) throws Exception{
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        return contatoRecuperado;
    }

    public Contato delete(Integer id) throws Exception{
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        listaContatos.remove(contatoRecuperado);
        return contatoRecuperado;
    }

    public List<Contato> listByIdPessoa(Integer id){
        return  listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

}
