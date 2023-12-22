package rw.vtb.dolomit.dolomit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.models.CarriageType;
import rw.vtb.dolomit.dolomit.repositories.CarriageTypeRepository;
import rw.vtb.dolomit.dolomit.services.CarriageTypeService;

import java.util.List;

@Service
public class CarriageTypeServiceImpl implements CarriageTypeService {

    private final CarriageTypeRepository carriageTypeRepository;

    @Autowired
    public CarriageTypeServiceImpl(CarriageTypeRepository carriageTypeRepository) {
        this.carriageTypeRepository = carriageTypeRepository;
    }

    @Override
    public CarriageType findById(Integer id) {
        return carriageTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<CarriageType> getAllCarriageTypes() {
        return carriageTypeRepository.findAll();
    }

    @Override
    public CarriageType create(CarriageType requestCarriageType) {
        List<CarriageType> carriageTypes = carriageTypeRepository.findAll();
        CarriageType newType = new CarriageType(
                carriageTypes.size()+1,
                requestCarriageType.getType(),
                requestCarriageType.getDescription()
        );

        return carriageTypeRepository.save(newType);
    }

    @Override
    public CarriageType update(CarriageType requestCarriageType) {

        CarriageType updatingCarriageType =
                carriageTypeRepository.findById(requestCarriageType.getId()).orElse(null);

        if (updatingCarriageType != null) {
            updatingCarriageType.setType(requestCarriageType.getType());
            updatingCarriageType.setDescription(requestCarriageType.getDescription());
            return carriageTypeRepository.save(updatingCarriageType);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        CarriageType deletingCarriageType = carriageTypeRepository.findById(id).orElse(null);
        if (deletingCarriageType != null) {
            carriageTypeRepository.delete(deletingCarriageType);
        }
    }
}
