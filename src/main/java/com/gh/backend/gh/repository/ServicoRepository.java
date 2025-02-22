package com.gh.backend.gh.repository;

import com.gh.backend.gh.model.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicoRepository extends MongoRepository<Servico, String> {
}