package peak.app.repository;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.Mountain;

public interface MountainRepository extends CrudRepository<Mountain, String> { 

}
