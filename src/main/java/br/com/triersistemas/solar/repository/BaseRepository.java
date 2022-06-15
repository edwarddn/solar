package br.com.triersistemas.solar.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID, DOMAIN> {
    List<DOMAIN> consultar();
    Optional<DOMAIN> consultar(ID id);
    List<DOMAIN> consultar(List<ID> ids);
    void cadastrar(DOMAIN domain);
    void remover(DOMAIN domain);
}
