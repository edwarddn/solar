package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.model.FornecedorModel;

import java.util.List;
import java.util.UUID;

public interface FornecedorService {

    List<Fornecedor> consultar();

    Fornecedor consultar(UUID id);

    Fornecedor cadastrar(FornecedorModel model);

    Fornecedor cadastrarRandom();

    Fornecedor alterar(UUID id, FornecedorModel model);

    Fornecedor remover(UUID id);
}
