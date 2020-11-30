package Repository;

import Entity.Candidate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidateRepo extends CassandraRepository<Candidate, String> {
    Optional<Candidate> findByNameAndParty(String name, String party);
}