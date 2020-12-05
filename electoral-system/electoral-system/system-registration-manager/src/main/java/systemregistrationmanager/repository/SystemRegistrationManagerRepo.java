package systemregistrationmanager.repository;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import systemregistrationmanager.entity.Manager;

@Repository
public interface SystemRegistrationManagerRepo extends CassandraRepository<Manager, String>{
    Optional<Manager> findByName(String region);
    Optional<Manager> findById(String id);
    Optional<Manager> findByIdAndName(String id, String name);
}
