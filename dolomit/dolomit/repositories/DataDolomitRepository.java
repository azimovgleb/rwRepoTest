package rw.vtb.dolomit.dolomit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rw.vtb.dolomit.dolomit.models.DataDolomit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DataDolomitRepository extends JpaRepository<DataDolomit, UUID> {

    @Query(value = "SELECT * FROM dolomit_data\n" +
            "WHERE EXTRACT(MONTH FROM date_now) = EXTRACT(MONTH FROM date_trunc('month', CURRENT_DATE) - INTERVAL '1 month')\n" +
            "  AND EXTRACT(YEAR FROM date_now) = EXTRACT(YEAR FROM date_trunc('month', CURRENT_DATE) - INTERVAL '1 month')",
            nativeQuery = true)
    List<DataDolomit> findByPreLastMonth();

    @Query(value = "SELECT * FROM dolomit_data\n" +
            "WHERE EXTRACT(MONTH FROM date_now) = EXTRACT(MONTH FROM CURRENT_DATE)\n" +
            "  AND EXTRACT(YEAR FROM date_now) = EXTRACT(YEAR FROM CURRENT_DATE)",
            nativeQuery = true)
    List<DataDolomit> findByLastMonth();

    DataDolomit findFirstByOrderByDateCreatedDesc();

    DataDolomit getById(UUID uuid);
}
