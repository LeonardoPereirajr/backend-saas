package com.gh.backend.gh.controller;
import com.gh.backend.gh.dto.ServicoDTO;
import com.gh.backend.gh.repository.ServicoRepository;
import com.gh.backend.gh.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.gh.backend.gh.model.Servico;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ServicoDTO>> listarTodos() {
        List<ServicoDTO> servicos = servicoService.listarTodos();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public Servico buscarPorId(@PathVariable String id) {
        return servicoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Servico> salvar(@RequestBody Servico servico) {
        if (servico.getClienteId() == null || servico.getClienteId().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Servico novoServico = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }


    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable String id, @RequestBody Servico servico) {
        return servicoService.atualizar(id, servico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        servicoService.deletar(id);
    }
}
