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
        return servicos.stream().map(this::mapearParaDTO).collect(Collectors.toList());
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

    // Se quiser atualizar um serviço existente:
    public Servico atualizar(String id, Servico servicoAtualizado) {
        Servico servicoEncontrado = buscarPorId(id);
        if (servicoEncontrado == null) {
            return null; // ou lançar exception
        }
        // Ajuste campos (exemplo):
        servicoEncontrado.setClienteId(servicoAtualizado.getClienteId());
        servicoEncontrado.setTipoServico(servicoAtualizado.getTipoServico());
        servicoEncontrado.setValorHora(servicoAtualizado.getValorHora());
        servicoEncontrado.setHorasMensais(servicoAtualizado.getHorasMensais());
        servicoEncontrado.setValorMensal(servicoAtualizado.getValorMensal());
        servicoEncontrado.setDeslocamentoKm(servicoAtualizado.getDeslocamentoKm());
        servicoEncontrado.setCustoPorKm(servicoAtualizado.getCustoPorKm());
        servicoEncontrado.setTotalCustoDeslocamento(servicoAtualizado.getTotalCustoDeslocamento());

        return servicoRepository.save(servicoEncontrado);
    }
    private ServicoDTO mapearParaDTO(Servico servico) {

        String nomeCliente = "Desconhecido"; // Valor padrão caso o cliente não seja encontrado

        if (servico.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(servico.getClienteId()).orElse(null);
            if (cliente != null) {
                nomeCliente = cliente.getNome(); // Agora garantimos que pegamos o nome corretamente
            }
        }
        double deslocamentoKm = (servico.getDeslocamentoKm() != null) ? servico.getDeslocamentoKm() : 0.0;
        double custoPorKm = (servico.getCustoPorKm() != null) ? servico.getCustoPorKm() : 0.0;
        double totalCustoDeslocamento = (servico.getTotalCustoDeslocamento() != null) ? servico.getTotalCustoDeslocamento() : 0.0;
        double valorHora = (servico.getValorHora() != 0.0) ? servico.getValorHora() : 0.0;
        int horasMensais = (servico.getHorasMensais() != null) ? servico.getHorasMensais() : 0;
        double valorMensal = (servico.getValorMensal() != null) ? servico.getValorMensal() : 0.0;

        System.out.println("ID Serviço: " + servico.getId() + " | Cliente: " + nomeCliente + " | Deslocamento KM: " + deslocamentoKm);

        return new ServicoDTO(
                servico.getId(), nomeCliente, servico.getTipoServico(),
                (servico.getDescricao() != null) ? servico.getDescricao() : "",
                (servico.getValorHora() != null) ? servico.getValorHora() : 0.0,
                (servico.getHorasMensais() != null) ? servico.getHorasMensais() : 0,
                (servico.getValorMensal() != null) ? servico.getValorMensal() : 0.0,
                (servico.getDeslocamentoKm() != null) ? servico.getDeslocamentoKm() : 0.0,
                (servico.getCustoPorKm() != null) ? servico.getCustoPorKm() : 0.0,
                (servico.getTotalCustoDeslocamento() != null) ? servico.getTotalCustoDeslocamento() : 0.0
        );
    }

}
