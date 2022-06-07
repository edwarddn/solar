package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.model.ContatoModel;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    private final static List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar-randon")
    public List<Farmaceutico> cadastrarRandon() {
        LIST.add(new Farmaceutico());
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Farmaceutico> cadastrar(@RequestBody FarmaceuticoModel model) {
        LIST.add(new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf()));
        return LIST;
    }

    @DeleteMapping("/alterar/{index}")
    public List<Farmaceutico> remover(@PathVariable Integer index, @RequestBody FarmaceuticoModel model) {
        var contato = LIST.get(index);
        LIST.remove(contato);
        LIST.add(new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf()));
        return LIST;
    }

    @DeleteMapping("/remover/{index}")
    public List<Farmaceutico> remover(@PathVariable int index) {
        LIST.remove(index);
        return LIST;
    }
}