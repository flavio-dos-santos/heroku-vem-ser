package br.com.dbc.vemser.pessoaapi.repository;


import br.com.dbc.vemser.pessoaapi.entidades.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static final List<Pessoa> listaPessoa = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


    public PessoaRepository(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //dia/mes/ano
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910","flavio.sobrinho@dbccompany.com.br"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911","flavio.sobrinho@dbccompany.com.br"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912","flavio.sobrinho@dbccompany.com.br"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916","flavio.sobrinho@dbccompany.com.br"));
        listaPessoa.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917","flavio.sobrinho@dbccompany.com.br"));
    }

    public Pessoa create(Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoa.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list(){
        return listaPessoa;
    }

    public Pessoa update(Integer id,Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = listaPessoa.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada! "));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoa.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada "));
        listaPessoa.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public List<Pessoa> listByName(String nome){
        return listaPessoa.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }


    public Pessoa getById(Integer id) throws Exception{
        return  listaPessoa.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("id da pessoa não encontrado"));
    }

}
