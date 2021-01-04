package informationhub.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Query;

import informationhub.entity.CandidateRegistration;

@Repository
public interface CandidateRegistrationRepo extends CassandraRepository<CandidateRegistration, String>{
    Optional<CandidateRegistration> findByName(String name);
    Optional<CandidateRegistration> findById(int id);
    @Query("UPDATE kelly.candidateregistration SET bio = ?1 WHERE id = ?0 IF EXISTS;")
    Optional<CandidateRegistration> updateBio(int id, String bio);
}
