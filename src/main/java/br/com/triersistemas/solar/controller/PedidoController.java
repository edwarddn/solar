package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    public static final List<Pedido> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {

        var farmaceutico = FarmaceuticoController.LIST.stream()
                .filter(f -> f.getId().equals(model.getIdFarmaceutico()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var cliente = ClienteController.LIST.stream()
                .filter(f -> f.getId().equals(model.getIdCliente()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var domain = new Pedido(farmaceutico, cliente);
        LIST.add(domain);
        return domain;
    }

    @PutMapping("/adicionar-produtos/{id}")
    public Pedido adicionarProdutos(@PathVariable UUID id, @RequestBody AdicionarPedidoModel model) {
        var pedido = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var produtos = model.getIdProdutos()
                .stream()
                .map(idProduto -> {
                    return ProdutoController.LIST.stream()
                            .filter(x -> x.getId().equals(idProduto))
                            .findFirst()
                            .orElseThrow(NaoExisteException::new);
                }).collect(Collectors.toList());

        return pedido.adicionarProdutos(produtos);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        var pedido = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        return pedido.pagar(model.getValor());
    }
}