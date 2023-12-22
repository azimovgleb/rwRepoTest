package rw.vtb.dolomit.dolomit.services;

import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.models.CarriageType;

import java.util.List;

@Service
public interface CarriageTypeService {
    CarriageType findById(Integer id);
    List<CarriageType> getAllCarriageTypes();

    CarriageType create(CarriageType requestCarriageType);

    CarriageType update(CarriageType requestCarriageType);

    void delete(Integer id);
}
