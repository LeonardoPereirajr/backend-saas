package com.gh.backend.gh.service;

import com.gh.backend.gh.dto.ServicoDTO;
import com.gh.backend.gh.model.Cliente;
import com.gh.backend.gh.model.Servico;
import com.gh.backend.gh.repository.ClienteRepository;
import com.gh.backend.gh.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ServicoDTO> listarTodos() {
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoDTO> dtos = servicos.stream().map(this::mapearParaDTO).collect(Collectors.toList());
        return dtos;
    }


    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }


    public Servico buscarPorId(String id) {
        return servicoRepository.findById(id).orElse(null);
    }

    public void deletar(String id) {
        servicoRepository.deleteById(id);
    }

    public Servico atualizar(String id, Servico servicoAtualizado) {
        Servico servicoEncontrado = buscarPorId(id);
        if (servicoEncontrado == null) {
            return null;
        }
        servicoEncontrado.setClienteId(servicoAtualizado.getClienteId());
        servicoEncontrado.setTipoServico(servicoAtualizado.getTipoServico());
        servicoEncontrado.setValorHora(servicoAtualizado.getValorHora());
        servicoEncontrado.setHorasMensais(servicoAtualizado.getHorasMensais());
        servicoEncontrado.setValorMensal(servicoAtualizado.getValorMensal());
        servicoEncontrado.setDeslocamentoKm(servicoAtualizado.getDeslocamentoKm());
        servicoEncontrado.setCustoPorKm(servicoAtualizado.getCustoPorKm());
        servicoEncontrado.setTotalCustoDeslocamento(servicoAtualizado.getTotalCustoDeslocamento());
        servicoEncontrado.setHorasServico(servicoAtualizado.getHorasServico());
        servicoEncontrado.setValorTotal(servicoAtualizado.getValorTotal());

        return servicoRepository.save(servicoEncontrado);
    }


    private ServicoDTO mapearParaDTO(Servico servico) {
        String nomeCliente = "Desconhecido";
        String clienteId = servico.getClienteId();
        if (clienteId != null && !clienteId.isEmpty()) {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            assert cliente != null;
            clienteId = cliente.getId();
            nomeCliente = cliente.getNome();
        }

        return new ServicoDTO(
                servico.getId(),
                nomeCliente,
                clienteId,
                servico.getTipoServico(),
                (servico.getDescricao() != null) ? servico.getDescricao() : "",
                (servico.getValorHora() != null) ? servico.getValorHora() : 0.0,
                (servico.getHorasMensais() != null) ? servico.getHorasMensais() : 0,
                (servico.getValorMensal() != null) ? servico.getValorMensal() : 0.0,
                (servico.getDeslocamentoKm() != null) ? servico.getDeslocamentoKm() : 0.0,
                (servico.getCustoPorKm() != null) ? servico.getCustoPorKm() : 0.0,
                (servico.getTotalCustoDeslocamento() != null) ? servico.getTotalCustoDeslocamento() : 0.0,
                (servico.getHorasServico() != null) ? servico.getHorasServico() : 0.0,
                (servico.getValorTotal() != null) ? servico.getValorTotal() : 0.0
        );
    }
}
