package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.repository.FarmaceuticoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class FarmaceuticoRepositoryImpl extends BaseRepositoryImpl<UUID, Farmaceutico> implements FarmaceuticoRepository {

}
