package rw.vtb.dolomit.dolomit.services;

import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.models.DataDolomit;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface DataDolomitService {

    //Map<String, List<DataDolomit>> getAllLastMonth();
    List<DataDolomit> getAllLastMonth();
   // Map<String, List<DataDolomit>> getAllPreLastMonth();
    List<DataDolomit> getAllPreLastMonth();

    DataDolomit getById(UUID id);
    List<DataDolomit> create(List<DataDolomit> requestDataDolomitList);

    List<DataDolomit> createEmpty();

    List<DataDolomit> update(List<DataDolomit> requestDataDolomitList);

    List<DataDolomit> delete(List<DataDolomit> requestDataDolomitList);


}

