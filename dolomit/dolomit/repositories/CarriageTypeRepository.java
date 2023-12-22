package rw.vtb.dolomit.dolomit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.vtb.dolomit.dolomit.models.CarriageType;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import java.util.UUID;

@Repository
public interface CarriageTypeRepository extends JpaRepository<CarriageType, Integer> {

}
