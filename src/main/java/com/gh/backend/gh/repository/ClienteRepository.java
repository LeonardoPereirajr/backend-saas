package com.gh.backend.gh.repository;

import com.gh.backend.gh.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
