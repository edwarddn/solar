package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return pedidoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {
        return pedidoService.cadastrar(model);
    }

    @PutMapping("/adicionar-produtos/{id}")
    public Pedido adicionarProdutos(@PathVariable UUID id, @RequestBody AdicionarPedidoModel model) {
        return pedidoService.adicionarProdutos(id, model);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        return pedidoService.pagar(id, model);
    }
}