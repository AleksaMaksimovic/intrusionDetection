package rs.gov.mup.intrusiondetection.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.gov.mup.intrusiondetection.model.Module;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Long> {
}
