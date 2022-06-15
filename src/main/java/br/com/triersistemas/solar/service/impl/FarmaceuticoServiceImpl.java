package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.FarmaceuticoModel;
import br.com.triersistemas.solar.repository.FarmaceuticoRepository;
import br.com.triersistemas.solar.service.FarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FarmaceuticoServiceImpl implements FarmaceuticoService {

    @Autowired
    private FarmaceuticoRepository farmaceuticoRepository;

    @Override
    public List<Farmaceutico> consultar() {
        return farmaceuticoRepository.consultar();
    }

    @Override
    public Farmaceutico consultar(UUID id) {
        return farmaceuticoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Farmaceutico cadastrar(FarmaceuticoModel model) {
        Farmaceutico farmaceutico = new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf());
        farmaceuticoRepository.cadastrar(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Farmaceutico cadastrarRandom() {
        Farmaceutico farmaceutico = new Farmaceutico();
        farmaceuticoRepository.cadastrar(farmaceutico);
        return farmaceutico;
    }

    @Override
    public Farmaceutico alterar(UUID id, FarmaceuticoModel model) {
        var farmaceutico = this.consultar(id);
        return (Farmaceutico) farmaceutico.editar(model.getNome(), model.getAniver(), model.getCpf());
    }

    @Override
    public Farmaceutico remover(UUID id) {
        Farmaceutico farmaceutico = this.consultar(id);
        farmaceuticoRepository.remover(farmaceutico);
        return farmaceutico;
    }
}
