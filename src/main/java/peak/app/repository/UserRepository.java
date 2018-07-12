package peak.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import peak.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    
    User findByUserName(String userName);

    List<User> findByUserNameNot(String userName);

    List<User> findByUserNameNotIn(List<String> userNames);
}
