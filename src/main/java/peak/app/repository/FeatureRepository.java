package peak.app.repository;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.Feature;

public interface FeatureRepository extends CrudRepository<Feature, Long> {

}
