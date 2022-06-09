package br.com.triersistemas.solar.model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class AdicionarPedidoModel {
    private List<UUID> idProdutos;
}
