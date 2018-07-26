package peak.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.Friend;
import peak.app.model.User;

public interface FriendRepository extends CrudRepository<Friend, Long> {
    List<Friend> findByUser(User user);

}
