package ballotCollector.repository;

import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import ballotCollector.entity.BallotCollector;

@Repository
public interface BallotCollectorRepo extends CassandraRepository<BallotCollector, String>{
    Optional<BallotCollector> findByRegion(String region);
    Optional<BallotCollector> findById(String UUID);
    boolean existsByRegion(String region);
    void deleteByRegion(String region);
}
