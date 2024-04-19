package br.newton.ApiClima.repository;

import br.newton.ApiClima.model.ClimaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository  extends MongoRepository<ClimaEntity, String>{

}