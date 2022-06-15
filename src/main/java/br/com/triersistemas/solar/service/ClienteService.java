package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<Cliente> consultar();
    Cliente consultar(UUID id);
    Cliente cadastrar(ClienteModel model);
    Cliente alterar(UUID id, ClienteModel model);
    Cliente remover(UUID id);
}
