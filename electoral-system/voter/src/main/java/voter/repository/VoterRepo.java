package voter.repository;

import core.entity.Voter;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepo extends CassandraRepository<Voter, String> {
    Optional<Voter> findByName(String name);

    boolean existsByName(String name);

    Optional<Voter> findByVotedFor(String votedFor);

    boolean existsByAddress(String address);

    void deleteByName(String name);
}