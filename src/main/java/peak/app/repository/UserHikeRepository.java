package peak.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.User;
import peak.app.model.UserHike;


public interface UserHikeRepository extends CrudRepository<UserHike, String> {

    List<UserHike> findByUser(User user);
}
