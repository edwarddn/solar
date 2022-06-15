package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.repository.PedidoRepository;
import br.com.triersistemas.solar.service.ClienteService;
import br.com.triersistemas.solar.service.FarmaceuticoService;
import br.com.triersistemas.solar.service.PedidoService;
import br.com.triersistemas.solar.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FarmaceuticoService farmaceuticoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.consultar();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {
        Farmaceutico farmaceutico = farmaceuticoService.consultar(model.getIdFarmaceutico());
        Cliente cliente = clienteService.consultar(model.getIdCliente());
        Pedido pedido = new Pedido(farmaceutico, cliente);
        pedidoRepository.cadastrar(pedido);
        return pedido;
    }

    @Override
    public Pedido adicionarProdutos(UUID id, AdicionarPedidoModel model) {
        Pedido pedido = this.consultar(id);
        List<Produto> produtos = produtoService.consultar(model.getIdProdutos());
        return pedido.adicionarProdutos(produtos);
    }

    @Override
    public Pedido pagar(UUID id, PagarPedidoModel model) {
        Pedido pedido = this.consultar(id);
        pedido.pagar(model.getValor());
        return pedido;
    }
}
