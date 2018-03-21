package peak.app.repository;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.UserHike;


public interface UserHikeRepository extends CrudRepository<UserHike, String> {

}
