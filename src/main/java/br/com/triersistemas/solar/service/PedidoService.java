package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    List<Pedido> consultar();
    Pedido consultar(UUID id);
    Pedido cadastrar(PedidoModel model);
    Pedido adicionarProdutos(UUID id, AdicionarPedidoModel model);
    Pedido pagar(UUID id, PagarPedidoModel model);
}
