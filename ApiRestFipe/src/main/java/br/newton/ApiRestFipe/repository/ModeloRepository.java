package br.newton.ApiRestFipe.repository;

import br.newton.ApiRestFipe.model.ModeloEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends MongoRepository<ModeloEntity, String> {
}
