package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.repository.PedidoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PedidoRepositoryImpl extends BaseRepositoryImpl<UUID, Pedido> implements PedidoRepository {

}
