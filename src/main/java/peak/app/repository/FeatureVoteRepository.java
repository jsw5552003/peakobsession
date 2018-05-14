package peak.app.repository;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.FeatureVote;

public interface FeatureVoteRepository extends CrudRepository<FeatureVote, Long> {

    long countByFeatureId(long feature_id);

}
