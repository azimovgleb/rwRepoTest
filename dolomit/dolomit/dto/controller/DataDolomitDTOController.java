package rw.vtb.dolomit.dolomit.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.vtb.dolomit.dolomit.dto.model.DataDolomitDTO;
import rw.vtb.dolomit.dolomit.dto.service.DataDolomitDTOService;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.services.impl.LogDolomitServiceImpl;
import rw.vtb.dolomit.dolomit.utils.Constants;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/dolomit/data/dto")
public class DataDolomitDTOController {


//    private final DataDolomitDTOService dataDolomitDTOService;
//    private final LogDolomitServiceImpl logsDolomitService;
//
//    @Autowired
//    public DataDolomitDTOController(DataDolomitDTOService dataDolomitDTOService, LogDolomitServiceImpl logsDolomitService) {
//        this.dataDolomitDTOService = dataDolomitDTOService;
//        this.logsDolomitService = logsDolomitService;
//    }
//
//
//    @GetMapping("/getAllLastMonth")
//    public ResponseEntity<List<DataDolomitDTO>> getAllLastMonth() {
//        List<DataDolomitDTO> dataDolomitDTOList = dataDolomitDTOService.getAllLastMonth();
//        return new ResponseEntity<>(dataDolomitDTOList, HttpStatus.OK);
//    }
//
//    @GetMapping("/getAllPreLastMonth")
//    public ResponseEntity<List<DataDolomitDTO>> getAllPreLastMonth() {
//        List<DataDolomitDTO> dataDolomitDTOList = dataDolomitDTOService.getAllPreLastMonth();
//        return new ResponseEntity<>(dataDolomitDTOList, HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    //  @PreAuthorize("hasAuthority('users:write')")
//    public ResponseEntity<List<DataDolomit>> create(@RequestBody DataDolomitDTO dataDolomitDTO) {
//        List<DataDolomit> createdDataDolomitList = dataDolomitDTOService.create(dataDolomitDTO);
//        if (dataDolomitDTO != null) {
//            logsDolomitService.create(createdDataDolomitList,
//                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd")
//            );
//            return new ResponseEntity<>(createdDataDolomitList, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
////    @PostMapping("/create/empty")
////    //@Scheduled(fixedRate = 3000)
////    public ResponseEntity<List<DataDolomit>> createEmpty() {
////        System.out.println("Java made record!!!");
////        List<DataDolomit> createdDataDolomit = dataDolomitService.createDataDolomitEmpty();
////        if (createdDataDolomit != null) {
////            logsDolomitService.create(createdDataDolomit,
////                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd")
////            );
////        }
////        return new ResponseEntity<>(createdDataDolomit, HttpStatus.CREATED);
////    }
//
//    @PutMapping("/update")
//    // @PreAuthorize("hasAuthority('users:write')")
//    public ResponseEntity<List<DataDolomit>> update(@RequestBody DataDolomitDTO dataDolomitDTO) {
//
//        List<DataDolomit> updatedDataDolomitList = dataDolomitDTOService.update(dataDolomitDTO);
//        if (updatedDataDolomitList.size() == Constants.CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
//            logsDolomitService.create(updatedDataDolomitList,
//                    UUID.fromString("d2af7384-3c13-402a-9e9f-625257a0d0fd")
//            );
//            return new ResponseEntity<>(updatedDataDolomitList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/delete")
////    @PreAuthorize("hasAuthority('users:write')")
//    public ResponseEntity<List<DataDolomit>> delete(@RequestBody DataDolomitDTO requestDataDolomitDTO) {
//        dataDolomitDTOService.delete(requestDataDolomitDTO);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
