package project.SpendSafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.SpendSafe.model.CurrentUserSession;


@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {


    public Optional<CurrentUserSession> findByUuid(String key);

    public Optional<CurrentUserSession> findByCustomerId(Integer customerId);

}