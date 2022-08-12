package rs.gov.mup.intrusiondetection.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rs.gov.mup.intrusiondetection.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
