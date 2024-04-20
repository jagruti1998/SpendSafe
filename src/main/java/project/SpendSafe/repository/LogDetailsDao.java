package project.SpendSafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpendSafe.model.LogDetails;


public interface LogDetailsDao extends JpaRepository<LogDetails, Integer>{

}
