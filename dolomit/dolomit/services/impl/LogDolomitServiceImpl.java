package rw.vtb.dolomit.dolomit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.dto.model.LogDolomitDTO;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.models.LogAction;
import rw.vtb.dolomit.dolomit.models.LogDolomit;
import rw.vtb.dolomit.dolomit.repositories.DataDolomitRepository;
import rw.vtb.dolomit.dolomit.repositories.LogRepository;
import rw.vtb.dolomit.dolomit.repositories.UserRepository;
import rw.vtb.dolomit.dolomit.services.LogService;

import java.util.*;

@Service
public class LogDolomitServiceImpl implements LogService {

    private final UserRepository userRepository;
    private final LogRepository logRepository;

    @Autowired
    public LogDolomitServiceImpl(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<LogDolomitDTO> getAll() {
        List<LogDolomit> logDolomitList = logRepository.findAll();
        List<LogDolomitDTO> logDolomitDTOList = new ArrayList<>();

        for (LogDolomit logDolomit : logDolomitList) {
            LogDolomitDTO logDolomitDTO = new LogDolomitDTO(
                    logDolomit.getId(),
                    logDolomit.getDateCreated(),
                    logDolomit.getLogActions(),
                    logDolomit.getUser().getEmail(),
                    logDolomit.getLogDataId()
            );
            logDolomitDTOList.add(logDolomitDTO);
        }

        return logDolomitDTOList;
    }

    @Override
    public List<LogDolomit> create(List<DataDolomit> requestDataDolomitList, UUID uuid, LogAction logAction) {
        List<LogDolomit> newLogDolomitList = new ArrayList<>();

        for (DataDolomit record : requestDataDolomitList) {
            LogDolomit newLog = new LogDolomit();
                newLog.setLogActions(logAction);
            newLog.setLogDataId(record.getId());
            newLog.setUser(userRepository.findById(uuid).get());
            newLogDolomitList.add(newLog);
        }
        return logRepository.saveAll(newLogDolomitList);
    }
}
