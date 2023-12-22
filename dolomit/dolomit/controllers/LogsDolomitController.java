package rw.vtb.dolomit.dolomit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.vtb.dolomit.dolomit.dto.model.LogDolomitDTO;
import rw.vtb.dolomit.dolomit.models.LogDolomit;
import rw.vtb.dolomit.dolomit.services.impl.LogDolomitServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dolomit/logs")
public class LogsDolomitController {

    private final LogDolomitServiceImpl logsService;

    @Autowired
    public LogsDolomitController(LogDolomitServiceImpl logsService) {
        this.logsService = logsService;
    }


    @GetMapping("/getAll")
    public ResponseEntity <List<LogDolomitDTO>> getAllLogsDolomit() {
        List<LogDolomitDTO> logDolomitList = logsService.getAll();
        return new ResponseEntity<>(logDolomitList, HttpStatus.OK);
    }


}
