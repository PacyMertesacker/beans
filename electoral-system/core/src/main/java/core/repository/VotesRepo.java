package core.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import core.entity.Votes;

@Repository
public interface VotesRepo extends CassandraRepository<Votes, String>{
    Optional<Votes> findByCandidateAndRegion(String candidate, String region);
}
