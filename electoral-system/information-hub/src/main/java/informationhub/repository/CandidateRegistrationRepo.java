package informationhub.repository;

import java.util.Optional;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import informationhub.entity.CandidateRegistration;

@Repository
public interface CandidateRegistrationRepo extends CassandraRepository<CandidateRegistration, String>{
    Optional<CandidateRegistration> findByName(String name);
    Optional<CandidateRegistration> findById(int id);
    @AllowFiltering
    Optional<CandidateRegistration> findByNameAndParty(String name, Object object);
    @Query("UPDATE election.candidateregistration SET bio = ?1 WHERE id = ?0 IF EXISTS;")
    Optional<CandidateRegistration> updateBio(int id, String bio);
}
