package ballotCollector.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import ballotCollector.entity.BallotCollector;
import core.entity.Candidate;

@Repository
public interface BallotCollectorRepo extends CassandraRepository<BallotCollector, String>{
    Optional<BallotCollector> findByRegion(String region);
    Optional<BallotCollector> findById(String UUID);
    boolean existsByRegion(String region);
    void deleteByRegion(String region);
	void countAll(HashMap<Candidate, String> votesMap);
}
