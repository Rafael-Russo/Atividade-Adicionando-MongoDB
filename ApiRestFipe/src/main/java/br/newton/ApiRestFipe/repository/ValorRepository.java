package br.newton.ApiRestFipe.repository;

import br.newton.ApiRestFipe.model.ValorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository extends MongoRepository<ValorEntity, String> {
}
