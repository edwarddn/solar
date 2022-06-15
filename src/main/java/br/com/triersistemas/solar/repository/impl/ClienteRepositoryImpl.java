package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClienteRepositoryImpl extends BaseRepositoryImpl<UUID, Cliente> implements ClienteRepository {

}
