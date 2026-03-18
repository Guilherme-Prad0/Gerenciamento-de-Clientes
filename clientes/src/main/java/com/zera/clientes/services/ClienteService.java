package com.zera.clientes.services;

import com.zera.clientes.models.ClienteModel;
import com.zera.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel criarCliente(ClienteModel clienteModel ){
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel buscarPorId(Long id){
        return clienteRepository.findById(id).get();
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel clienteModel){
        ClienteModel newCliente = clienteRepository.findById(id).get();
        newCliente.setNome(clienteModel.getNome());
        newCliente.setEmail(clienteModel.getEmail());
        newCliente.setTelefone(clienteModel.getTelefone());
        return clienteRepository.save(newCliente);
    }

}
