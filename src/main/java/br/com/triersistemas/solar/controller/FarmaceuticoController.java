package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import br.com.triersistemas.solar.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return farmaceuticoService.consultar();
    }

    @PostMapping("/cadastrar-random")
    public Farmaceutico cadastrarRandom() {
        return farmaceuticoService.cadastrarRandom();
    }

    @PostMapping("/cadastrar")
    public Farmaceutico cadastrar(@Valid @RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Farmaceutico alterar(@PathVariable UUID id, @Valid @RequestBody FarmaceuticoModel model) {
        return farmaceuticoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Farmaceutico remover(@PathVariable UUID id) {
        return farmaceuticoService.remover(id);
    }
}