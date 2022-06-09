package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.ProdutoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    public static final List<Produto> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody ProdutoModel model) {
        var domain = new Produto(model.getNome(), model.getValor());
        LIST.add(domain);
        return domain;
    }

    @PutMapping("/alterar/{id}")
    public Produto remover(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        return domain.editar(model.getNome(), model.getValor());
    }

    @DeleteMapping("/remover/{id}")
    public Produto remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}