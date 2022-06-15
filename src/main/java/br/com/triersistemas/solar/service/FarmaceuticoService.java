package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.model.FarmaceuticoModel;

import java.util.List;
import java.util.UUID;

public interface FarmaceuticoService {

    List<Farmaceutico> consultar();

    Farmaceutico consultar(UUID id);

    Farmaceutico cadastrar(FarmaceuticoModel model);

    Farmaceutico cadastrarRandom();

    Farmaceutico alterar(UUID id, FarmaceuticoModel model);

    Farmaceutico remover(UUID id);
}
