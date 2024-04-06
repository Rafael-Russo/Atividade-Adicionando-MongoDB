package br.newton.ApiRestFipe.repository;

import br.newton.ApiRestFipe.model.MarcaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends MongoRepository<MarcaEntity, String> {
}
