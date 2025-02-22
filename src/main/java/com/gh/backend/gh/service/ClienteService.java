package com.gh.backend.gh.service;

import com.gh.backend.gh.model.Cliente;
import com.gh.backend.gh.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // ✅ Agora recebe um `String id`, não `Long id`
    public Cliente atualizar(String id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    cliente.setCidade(clienteAtualizado.getCidade());
                    cliente.setTipoServico(clienteAtualizado.getTipoServico());
                    return clienteRepository.save(cliente);
                }).orElse(null);
    }
}
