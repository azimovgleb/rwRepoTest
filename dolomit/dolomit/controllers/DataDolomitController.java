package rw.vtb.dolomit.dolomit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.models.LogAction;
import rw.vtb.dolomit.dolomit.services.DataDolomitService;
import rw.vtb.dolomit.dolomit.services.impl.LogDolomitServiceImpl;
import rw.vtb.dolomit.dolomit.utils.Constants;

import java.util.*;

import static rw.vtb.dolomit.dolomit.utils.Constants.CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dolomit/data")
public class DataDolomitController {
    private final DataDolomitService dataDolomitService;
    private final LogDolomitServiceImpl logsDolomitService;

    @Autowired
    public DataDolomitController(DataDolomitService dataDolomitService, LogDolomitServiceImpl logsDolomitService) {
        this.dataDolomitService = dataDolomitService;
        this.logsDolomitService = logsDolomitService;
    }

    //private static int i = 0;
    @GetMapping
    // @Scheduled(fixedRate = 3000)
    public String hello() {
        //  i++;
        System.out.println("do Scheduled!!!");
        return "Hello Dolomit";
    }


    @GetMapping("/getAllLastMonth")
    public ResponseEntity<List<DataDolomit>> getAllLastMont() {
        List<DataDolomit> dataDolomitList = dataDolomitService.getAllLastMonth();
        return new ResponseEntity<>(dataDolomitList, HttpStatus.OK);
    }

    @GetMapping("/getAllPreLastMonth")
    public ResponseEntity<List<DataDolomit>> getAllPreLastMonth(){
        List<DataDolomit> dataDolomitList = dataDolomitService.getAllPreLastMonth();
        return new ResponseEntity<>(dataDolomitList, HttpStatus.OK);
    }

    @PostMapping("/create")
    //  @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<List<DataDolomit>> create(@RequestBody List<DataDolomit> dataDolomitList) {
        List<DataDolomit> createdDataDolomit = dataDolomitService.create(dataDolomitList);
        if (createdDataDolomit != null) {
            logsDolomitService.create(createdDataDolomit,
                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd"),
                    LogAction.CREATE
            );
        }

        return new ResponseEntity<>(createdDataDolomit, HttpStatus.CREATED);
    }

    @PostMapping("/create/empty")
    //@Scheduled(fixedRate = 3000)
    public ResponseEntity<List<DataDolomit>> createEmpty() {
//        System.out.println("Java made record!!!");
        List<DataDolomit> createdDataDolomit = dataDolomitService.createEmpty();
        if (createdDataDolomit != null) {
            logsDolomitService.create(createdDataDolomit,
                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd"),
                    LogAction.CREATE
            );
        }
        return new ResponseEntity<>(createdDataDolomit, HttpStatus.CREATED);
    }

    @PutMapping("/update")
   // @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<List<DataDolomit>> update(@RequestBody List<DataDolomit> dataDolomitList) {
        List<DataDolomit> updatedDataDolomitList = dataDolomitService.update(dataDolomitList);
        if (dataDolomitList != null) {
            logsDolomitService.create(updatedDataDolomitList,
                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd"),
                    LogAction.UPDATE
            );
        }
        if (updatedDataDolomitList.size() == CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
            return new ResponseEntity<>(updatedDataDolomitList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<List<DataDolomit>> delete(@RequestBody List<DataDolomit> requestDataDolomitList) {
        dataDolomitService.delete(requestDataDolomitList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}