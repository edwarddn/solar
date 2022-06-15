package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.repository.FornecedorRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class FornecedorRepositoryImpl extends BaseRepositoryImpl<UUID, Fornecedor> implements FornecedorRepository {

}
