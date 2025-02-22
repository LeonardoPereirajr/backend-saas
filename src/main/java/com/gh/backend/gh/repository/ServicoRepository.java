package com.gh.backend.gh.repository;

import com.gh.backend.gh.model.Servico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends MongoRepository<Servico, String> {
}