package rs.gov.mup.intrusiondetection.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.gov.mup.intrusiondetection.model.Frame;

@Repository
public interface FrameRepository extends CrudRepository<Frame, Long> {
}
