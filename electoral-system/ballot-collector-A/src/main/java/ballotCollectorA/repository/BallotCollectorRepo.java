package ballotCollectorA.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.stereotype.Repository;

import core.entity.Votes;

@Repository
public interface BallotCollectorRepo extends CassandraRepository<Votes, String>{
    @AllowFiltering
    Optional<Votes> findByCandidateAndRegion(String candidate, String region);
}
