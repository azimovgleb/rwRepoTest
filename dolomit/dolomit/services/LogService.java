package rw.vtb.dolomit.dolomit.services;

import rw.vtb.dolomit.dolomit.dto.model.LogDolomitDTO;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.models.LogAction;
import rw.vtb.dolomit.dolomit.models.LogDolomit;

import java.util.List;
import java.util.UUID;

public interface LogService {

    List<LogDolomitDTO> getAll();

    List<LogDolomit> create(List<DataDolomit> requestDataDolomitList, UUID uuid, LogAction logAction);
}
