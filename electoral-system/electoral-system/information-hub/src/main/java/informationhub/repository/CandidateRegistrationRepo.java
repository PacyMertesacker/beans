package informationhub.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import informationhub.entity.CandidateRegistration;

@Repository
public interface CandidateRegistrationRepo extends CassandraRepository<CandidateRegistration, String>{
    Optional<CandidateRegistration> findByName(String name);
    Optional<CandidateRegistration> findById(int id);
}
