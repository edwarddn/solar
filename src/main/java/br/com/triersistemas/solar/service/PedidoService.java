package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    List<PedidoModel> consultar();

    PedidoModel consultar(UUID id);

    PedidoModel cadastrar(PedidoModel model);

    PedidoModel adicionarProdutos(UUID id, AdicionarPedidoModel model);

    PedidoModel pagar(UUID id, PagarPedidoModel model);
}
