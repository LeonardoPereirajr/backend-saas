package com.gh.backend.gh.controller;
import com.gh.backend.gh.dto.ServicoDTO;
import com.gh.backend.gh.repository.ServicoRepository;
import com.gh.backend.gh.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gh.backend.gh.model.Servico;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicoController {

    ServicoRepository servicoRepository;

    @Autowired
    private ServicoService servicoService;

    // GET /servicos
    @GetMapping
    public ResponseEntity<List<ServicoDTO>> listarTodos() {
        List<ServicoDTO> servicos = servicoService.listarTodos();
        return ResponseEntity.ok(servicos);
    }

    // GET /servicos/{id}
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


    // PUT /servicos/{id}
    @PutMapping("/{id}")
    public Servico atualizar(@PathVariable String id, @RequestBody Servico servico) {
        return servicoService.atualizar(id, servico);
    }

    // DELETE /servicos/{id}
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        servicoService.deletar(id);
    }
}
