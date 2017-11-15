package pl.akademiakodu.database.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.database.model.manytomany.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
