package rw.vtb.dolomit.dolomit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.vtb.dolomit.dolomit.models.CarriageType;
import rw.vtb.dolomit.dolomit.services.CarriageTypeService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dolomit/carriage")
public class CarriageTypeController {

    @Autowired
    private final CarriageTypeService carriageTypeService;

    public CarriageTypeController(CarriageTypeService carriageTypeService) {
        this.carriageTypeService = carriageTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarriageType>> getAll(){
        List<CarriageType> carriageTypeList = carriageTypeService.getAllCarriageTypes();
        return new ResponseEntity<>(carriageTypeList, HttpStatus.OK);
    }

    @PostMapping("/create")
    //  @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<CarriageType> create(@RequestBody CarriageType carriageTypeList) {
        CarriageType createdCarriageType = carriageTypeService.create(carriageTypeList);

        return new ResponseEntity<>(createdCarriageType, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    // @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<CarriageType> update(@RequestBody CarriageType carriageType) {
        CarriageType updatedCarriageType = carriageTypeService.update(carriageType);

        if (updatedCarriageType != null) {
            return new ResponseEntity<>(updatedCarriageType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        carriageTypeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
