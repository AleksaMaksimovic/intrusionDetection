package rs.gov.mup.intrusiondetection.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.gov.mup.intrusiondetection.model.Process;

@Repository
public interface ProcessRepository extends CrudRepository<Process, Long> {
}
