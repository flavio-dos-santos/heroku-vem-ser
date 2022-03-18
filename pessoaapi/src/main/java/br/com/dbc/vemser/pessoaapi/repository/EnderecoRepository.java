package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entidades.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository(){
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1,"residencial","qno 30 conjunto k",456,"72210215","taguatinga","DF", "Brasil"));
    }

    public List<Endereco> listarTodos(){
        return listaEnderecos;
    }

    public Endereco getByIdEndereco(Integer id) throws Exception{
        return listaEnderecos.stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("ID inválido!"));
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return listaEnderecos.stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }

    public Endereco create(Integer id, Endereco endereco){
        endereco.setIdPessoa(id);
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer id, Endereco enderecoAtualizado) throws Exception{
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Endereço inválido!"));
        enderecoRecuperado.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizado.getNumero());
        enderecoRecuperado.setCidade(enderecoAtualizado.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizado.getEstado());
        enderecoRecuperado.setCep(enderecoAtualizado.getCep());
        enderecoRecuperado.setPais(enderecoAtualizado.getPais());
        enderecoRecuperado.setTipo(enderecoAtualizado.getTipo());

        return enderecoRecuperado;
    }

    public Endereco delete(Integer id) throws Exception{
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Endereço Inválido!"));

        return enderecoRecuperado;
    }
}
