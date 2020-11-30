package voter.repository;

import voter.entity.Voter;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepo extends CassandraRepository<Voter, String> {
    Optional<Voter> findByName(String name);

    boolean existsByName(String name);


    boolean existsByAddress(String address);

    void deleteByName(String name);
}
