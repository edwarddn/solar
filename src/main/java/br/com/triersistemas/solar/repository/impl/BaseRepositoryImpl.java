package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.exceptions.NotImplementedException;
import br.com.triersistemas.solar.repository.BaseRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class BaseRepositoryImpl<ID, T> implements BaseRepository<ID, T> {

    private static final Map<String, List<?>> MAP_DB = new HashMap<>();

    private final List<T> list;

    public BaseRepositoryImpl() {
        this.list = this.getMyList();
    }

    @Override
    public List<T> consultar() {
        return list;
    }

    @Override
    public Optional<T> consultar(ID id) {
        return list.stream().filter(x -> id.equals(this.getId(x))).findFirst();
    }

    @Override
    public List<T> consultar(List<ID> ids) {
        return ids.stream().map(id -> consultar(id).orElseThrow(NaoExisteException::new)).toList();
    }

    @Override
    public void cadastrar(T domain) {
        list.add(domain);
    }

    @Override
    public void remover(T domain) {
        list.remove(domain);
    }

    private ID getId(T x) {
        try {
            return (ID) x.getClass().getMethod("getId").invoke(x);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new NotImplementedException("Método: getId() não implementado", ex);
        }
    }

    private Class<T> getTypeDomain() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    private List<T> getMyList() {
        final String key = this.getTypeDomain().getName();
        List<T> myList = (List<T>) MAP_DB.get(key);
        if (Objects.isNull(myList)) {
            myList = new ArrayList<>();
            MAP_DB.put(key, myList);
        }
        return myList;
    }
}
