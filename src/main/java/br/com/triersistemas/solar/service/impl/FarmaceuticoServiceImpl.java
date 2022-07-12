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
    public List<FarmaceuticoModel> consultar() {
        return farmaceuticoRepository.findAll().stream().map(FarmaceuticoModel::new).toList();
    }

    @Override
    public FarmaceuticoModel consultar(UUID id) {
        return new FarmaceuticoModel(this.buscarFarmaceuticoPorId(id));
    }

    @Override
    public FarmaceuticoModel cadastrar(FarmaceuticoModel model) {
        Farmaceutico farmaceutico = new Farmaceutico(model);
        return new FarmaceuticoModel(farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel cadastrarRandom() {
        Farmaceutico farmaceutico = new Farmaceutico();
        return new FarmaceuticoModel(farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel alterar(FarmaceuticoModel model) {
        var farmaceutico = this.buscarFarmaceuticoPorId(model.getId());
        farmaceutico.editar(model.getNome(), model.getAniver(), model.getCpf());
        return new FarmaceuticoModel(this.farmaceuticoRepository.save(farmaceutico));
    }

    @Override
    public FarmaceuticoModel remover(UUID id) {
        Farmaceutico farmaceutico = this.buscarFarmaceuticoPorId(id);
        farmaceuticoRepository.delete(farmaceutico);
        return new FarmaceuticoModel(farmaceutico);
    }

    private Farmaceutico buscarFarmaceuticoPorId(UUID id) {
        return farmaceuticoRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
