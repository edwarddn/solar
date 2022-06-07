package br.com.triersistemas.solar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.triersistemas.solar.model.ContatoModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final static List<ContatoModel> CONTATOS = new ArrayList<>();

    @GetMapping("/consultar")
    public List<ContatoModel> consultar() {
        return CONTATOS;
    }

    @PostMapping("/cadastrar")
    public List<ContatoModel> cadastrar(@RequestBody ContatoModel contato) {
        CONTATOS.add(contato);
        return CONTATOS;
    }

    @DeleteMapping("/alterar/{index}")
    public List<ContatoModel> remover(@PathVariable Integer index, @RequestBody ContatoModel model) {
        var contato = CONTATOS.get(index);
        CONTATOS.remove(contato);
        CONTATOS.add(model);
        return CONTATOS;
    }

    @DeleteMapping("/remover/{index}")
    public List<ContatoModel> remover(@PathVariable int index) {
        CONTATOS.remove(index);
        return CONTATOS;
    }
}