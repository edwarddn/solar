package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.model.ProdutoModel;
import br.com.triersistemas.solar.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return produtoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Produto alterar(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        return produtoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Produto remover(@PathVariable UUID id) {
        return produtoService.remover(id);
    }
}