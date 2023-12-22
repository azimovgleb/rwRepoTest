package rw.vtb.dolomit.dolomit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.vtb.dolomit.dolomit.models.LogDolomit;

import java.util.UUID;

@Repository
public interface LogRepository extends JpaRepository<LogDolomit, UUID> {

}
