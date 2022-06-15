package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.model.FornecedorModel;
import br.com.triersistemas.solar.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/consultar")
    public List<Fornecedor> consultar() {
        return fornecedorService.consultar();
    }

    @PostMapping("/cadastrar-randon")
    public Fornecedor cadastrarRandon() {
        return fornecedorService.cadastrarRandom();
    }

    @PostMapping("/cadastrar")
    public Fornecedor cadastrar(@RequestBody FornecedorModel model) {
        return fornecedorService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Fornecedor alterar(@PathVariable UUID id, @RequestBody FornecedorModel model) {
        return fornecedorService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Fornecedor remover(@PathVariable UUID id) {
        return fornecedorService.remover(id);
    }
}