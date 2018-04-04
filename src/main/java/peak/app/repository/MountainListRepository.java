package peak.app.repository;

import org.springframework.data.repository.CrudRepository;

import peak.app.model.MountainList;

public interface MountainListRepository extends CrudRepository<MountainList, Long> { 

    MountainList findByName(String name);
}
