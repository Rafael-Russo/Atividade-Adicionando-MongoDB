package br.newton.ApiRestFipe.repository;

import br.newton.ApiRestFipe.model.AnosEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnosRepository extends MongoRepository<AnosEntity, String> {
}
