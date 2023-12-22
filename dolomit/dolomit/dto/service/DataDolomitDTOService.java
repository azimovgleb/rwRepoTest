package rw.vtb.dolomit.dolomit.dto.service;

import rw.vtb.dolomit.dolomit.dto.model.DataDolomitDTO;
import rw.vtb.dolomit.dolomit.models.DataDolomit;

import java.util.List;

public interface DataDolomitDTOService {

    List<DataDolomitDTO> getAllLastMonth();

    List<DataDolomitDTO> getAllPreLastMonth();

    List<DataDolomit> create(DataDolomitDTO requestDataDolomitDTO);


    List<DataDolomit> update(DataDolomitDTO requestDataDolomitDTO);

    List<DataDolomit> delete(DataDolomitDTO requestDataDolomitDTO);
}
