package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProdutoRepositoryImpl extends BaseRepositoryImpl<UUID, Produto> implements ProdutoRepository {

}
