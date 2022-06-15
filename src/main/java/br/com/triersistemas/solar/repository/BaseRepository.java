package br.com.triersistemas.solar.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID, T> {
    List<T> consultar();
    Optional<T> consultar(ID id);
    List<T> consultar(List<ID> ids);
    void cadastrar(T domain);
    void remover(T domain);
}
