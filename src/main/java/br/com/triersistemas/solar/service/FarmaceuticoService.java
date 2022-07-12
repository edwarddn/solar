package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.model.FarmaceuticoModel;

import java.util.List;
import java.util.UUID;

public interface FarmaceuticoService {

    List<FarmaceuticoModel> consultar();

    FarmaceuticoModel consultar(UUID id);

    FarmaceuticoModel cadastrar(FarmaceuticoModel model);

    FarmaceuticoModel cadastrarRandom();

    FarmaceuticoModel alterar(FarmaceuticoModel model);

    FarmaceuticoModel remover(UUID id);
}
