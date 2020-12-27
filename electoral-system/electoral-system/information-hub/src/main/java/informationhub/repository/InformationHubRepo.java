package informationhub.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import informationhub.entity.Forum;

@Repository
public interface InformationHubRepo extends CassandraRepository<Forum, String>{
    Optional<Forum> findByName(String name);
    Optional<Forum> findById(String id);
    Optional<Forum> findByIdAndName(String id, String name);
}
