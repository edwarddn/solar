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
    public List<ProdutoModel> consultar() {
        return produtoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public ProdutoModel consultar(@PathVariable UUID id) {
        return produtoService.consultar(id);
    }

    @PostMapping("/consultar")
    public List<ProdutoModel> consultar(@RequestBody List<UUID> ids) {
        return produtoService.consultar(ids);
    }

    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@RequestBody ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public ProdutoModel alterar(@RequestBody ProdutoModel model) {
        return produtoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ProdutoModel remover(@PathVariable UUID id) {
        return produtoService.remover(id);
    }
}
