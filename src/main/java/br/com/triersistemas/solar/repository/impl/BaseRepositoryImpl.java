package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.repository.BaseRepository;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class BaseRepositoryImpl<ID, DOMAIN> implements BaseRepository<ID, DOMAIN> {

    private static final Map<String, List> MAP = new HashMap();

    private final Class<ID> typeId;
    private final Class<DOMAIN> typeDomain;

    private final List<DOMAIN> list;

    private List<DOMAIN> getList(final String key) {
        var list = MAP.get(key);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
            MAP.put(key, list);
        }
        return list;
    }

    public BaseRepositoryImpl() {
        this.typeId = (Class<ID>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.typeDomain = (Class<DOMAIN>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[1];
        this.list = getList(this.typeDomain.getName());
    }

    @Override
    public List<DOMAIN> consultar() {
        return list;
    }

    @Override
    public Optional<DOMAIN> consultar(ID id) {
        final var type = ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        return list.stream().filter(x -> {
            return id.equals(this.getId(x));
        }).findFirst();
    }

    private ID getId(DOMAIN x) {
        try {
            var localId = x.getClass().getMethod("getId");
            return (ID) localId.invoke(x);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<DOMAIN> consultar(List<ID> ids) {
        return ids.stream().map(id -> consultar(id).orElseThrow(NaoExisteException::new)).toList();
    }

    @Override
    public void cadastrar(DOMAIN domain) {
        list.add(domain);
    }

    @Override
    public void remover(DOMAIN domain) {
        list.remove(domain);
    }
}
