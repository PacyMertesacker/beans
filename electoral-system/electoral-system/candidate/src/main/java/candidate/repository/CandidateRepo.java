package candidate.repository;

import candidate.entity.Candidate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepo extends CassandraRepository<Candidate, String> {
    Optional<Candidate> findByName(String name);

    boolean existsByName(String Name);

    void deleteByName(String name);
}