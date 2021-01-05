package systemregistrationmanager.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.stereotype.Repository;

import core.entity.Votes;

@Repository
public interface SystemRegistrationManagerRepo extends CassandraRepository<Votes, String>{
    @AllowFiltering
    Optional<List<Votes>> findByCandidate(String candidate);
}   