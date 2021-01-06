package informationhub.repository;

import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import informationhub.entity.Forum;

@Repository
public interface InformationHubRepo extends CassandraRepository<Forum, String>{
    Optional<Forum> findByName(String name);
    Optional<Forum> findById(int id);
    Optional<Forum> findByIdAndName(int id, String name);
    Optional<Forum> findByMessage(String message);
}
