package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.ClienteModel;
import br.com.triersistemas.solar.repository.ClienteRepository;
import br.com.triersistemas.solar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultar() {
        return clienteRepository.consultar();
    }

    @Override
    public Cliente consultar(UUID id) {
        return clienteRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cliente cadastrar(ClienteModel model) {
        var cliente = new Cliente(model.getNome(), model.getAniver(), model.getCpf(), model.getEmail());
        clienteRepository.cadastrar(cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(UUID id, ClienteModel model) {
        Cliente cliente = this.consultar(id);
        cliente.editar(model.getNome(), model.getAniver(), model.getCpf(), model.getEmail());
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultar(id);
        clienteRepository.remover(cliente);
        return cliente;
    }
}
