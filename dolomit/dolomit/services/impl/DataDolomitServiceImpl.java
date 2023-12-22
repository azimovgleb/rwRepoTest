package rw.vtb.dolomit.dolomit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.models.CarriageType;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.repositories.DataDolomitRepository;
import rw.vtb.dolomit.dolomit.repositories.LogRepository;
import rw.vtb.dolomit.dolomit.services.CarriageTypeService;
import rw.vtb.dolomit.dolomit.services.DataDolomitService;
import rw.vtb.dolomit.dolomit.services.LogService;

import java.util.*;

import static rw.vtb.dolomit.dolomit.utils.Constants.CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST;
import static rw.vtb.dolomit.dolomit.utils.DataUtil.addOneDay;
import static rw.vtb.dolomit.dolomit.utils.DataUtil.formatDate;


@Service
public class DataDolomitServiceImpl implements DataDolomitService {

    private final DataDolomitRepository dataDolomitRepository;

    private final LogRepository logRepository;
    private final CarriageTypeService carriageTypeService;

    private final LogService logService;


    @Autowired
    public DataDolomitServiceImpl(DataDolomitRepository dataDolomitRepository, CarriageTypeService carriageTypeService, LogRepository logRepository, LogService logService) {
        this.dataDolomitRepository = dataDolomitRepository;
        this.carriageTypeService = carriageTypeService;
        this.logRepository = logRepository;
        this.logService = logService;
    }


    @Override
    public List<DataDolomit> getAllPreLastMonth() {
        List<DataDolomit> dataDolomitsMonthsList = dataDolomitRepository.findByPreLastMonth();
        Collections.sort(dataDolomitsMonthsList);
        dataDolomitsMonthsList.forEach(
                record -> record.setPlusMinusPrinyato(record.getPogruzheno() - record.getPrinyato()));
//        for (DataDolomit record : dataDolomitsMonthsList) {
//            record.setPlusMinusPrinyato(record.getPogruzheno() - record.getPrinyato());
//        }

        return dataDolomitsMonthsList;
    }

    @Override
    public List<DataDolomit> getAllLastMonth() {
        List<DataDolomit> dataDolomitsMonthsList = dataDolomitRepository.findByLastMonth();
        Collections.sort(dataDolomitsMonthsList);
        dataDolomitsMonthsList.forEach(
                record -> record.setPlusMinusPrinyato(record.getPogruzheno() - record.getPrinyato()));
//        for (DataDolomit record : dataDolomitsMonthsList) {
//            record.setPlusMinusPrinyato(record.getPogruzheno() - record.getPrinyato());
//        }
//        TreeMap<String, List<DataDolomit>> recordsListSortedByDate = new TreeMap<>();
//       // Map<String, List<DataDolomit>> groupedRecordsByDate = new HashMap<>();
//
//            String date = formatDate(record.getDateCreated());
//            recordsListSortedByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(record);
//        }
//        for (Map.Entry<String, List<DataDolomit>> entry : recordsListSortedByDate.entrySet()) {
//            List<DataDolomit> dataList = entry.getValue();
//            Collections.sort(dataList, Comparator.comparing(data -> data.getCarriageType().getId()));
//        }

        return dataDolomitsMonthsList;
    }

    @Override
    public DataDolomit getById(UUID id) {
        return dataDolomitRepository.findById(id).orElse(null);
    }

    @Override
    public List<DataDolomit> create(List<DataDolomit> requestDataDolomitList) {
        List<DataDolomit> newDataDolomitRecordsList = new ArrayList<>();

        for (DataDolomit record : requestDataDolomitList) {
            DataDolomit newRecord = new DataDolomit(
                    new Date(),
                    record.getZayavleno(),
                    record.getPrinyato(),
                    record.getPogruzheno(),
                    record.getCarriageType()
            );
            newDataDolomitRecordsList.add(newRecord);
        }

        return dataDolomitRepository.saveAll(newDataDolomitRecordsList);
    }

    @Override
    public List<DataDolomit> createEmpty() {
        Date lastRecordDateFromBD = dataDolomitRepository.findFirstByOrderByDateCreatedDesc().getDateCreated();
        List<CarriageType> carriageTypeList = carriageTypeService.getAllCarriageTypes();
        List<DataDolomit> dataDolomitEmptyList = new ArrayList<>();
        String actualDate = formatDate(new Date());
        String lastDateFromDBToString = formatDate(lastRecordDateFromBD);

        while (!Objects.equals(lastDateFromDBToString, actualDate)) {
            lastRecordDateFromBD = addOneDay(lastRecordDateFromBD);
            lastDateFromDBToString = formatDate(lastRecordDateFromBD);
            Date dateForNewEmptyElem = lastRecordDateFromBD;
            carriageTypeList.forEach(carriageType -> dataDolomitEmptyList.add(
                    new DataDolomit(dateForNewEmptyElem, 0, 0, 0, carriageType)
            ));
        }

        return dataDolomitRepository.saveAll(dataDolomitEmptyList);
    }

    @Override
    public List<DataDolomit> update(List<DataDolomit> requestDataDolomitList) {
        List<DataDolomit> dataDolomitListForUpdate = new ArrayList<>();

        for (DataDolomit elem : requestDataDolomitList) {
            DataDolomit existingDataDolomit = dataDolomitRepository.findById(elem.getId()).orElse(null);

            if (existingDataDolomit != null) {
                existingDataDolomit.setZayavleno(elem.getZayavleno());
                existingDataDolomit.setPrinyato(elem.getPrinyato());
                existingDataDolomit.setPogruzheno(elem.getPogruzheno());
                //existingDataDolomit.setPlusMinusPrinyato(elem.getPogruzheno() - elem.getPrinyato());
                dataDolomitListForUpdate.add(existingDataDolomit);
            }
        }
        if (dataDolomitListForUpdate.size() == CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
            return dataDolomitRepository.saveAll(dataDolomitListForUpdate);
        } else {
            return null;
        }

    }

    @Override
    public List<DataDolomit> delete(List<DataDolomit> requestDataDolomitList) {
        List<DataDolomit> dataDolomitListForUpdate = new ArrayList<>();

        for (DataDolomit elem : requestDataDolomitList) {
            DataDolomit updatingDataDolomitRecord = dataDolomitRepository.findById(elem.getId()).orElse(null);

            if (updatingDataDolomitRecord != null) {
                updatingDataDolomitRecord.setZayavleno(0);
                updatingDataDolomitRecord.setPrinyato(0);
                updatingDataDolomitRecord.setPogruzheno(0);
                //updatingDataDolomitRecord.setPlusMinusPrinyato(0);
                dataDolomitListForUpdate.add(updatingDataDolomitRecord);
            }
        }
        if (dataDolomitListForUpdate.size() == CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
            return dataDolomitRepository.saveAll(dataDolomitListForUpdate);
        } else {
            return null;
        }
    }


}

