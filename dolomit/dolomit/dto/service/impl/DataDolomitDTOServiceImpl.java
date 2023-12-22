package rw.vtb.dolomit.dolomit.dto.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.dto.model.DataDolomitDTO;
import rw.vtb.dolomit.dolomit.dto.service.DataDolomitDTOService;
import rw.vtb.dolomit.dolomit.models.CarriageType;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.repositories.DataDolomitRepository;
import rw.vtb.dolomit.dolomit.repositories.LogRepository;
import rw.vtb.dolomit.dolomit.services.CarriageTypeService;
import rw.vtb.dolomit.dolomit.services.LogService;

import java.util.*;
import java.util.stream.Collectors;

import static rw.vtb.dolomit.dolomit.utils.Constants.CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST;
import static rw.vtb.dolomit.dolomit.utils.DataUtil.formatDate;

@Service
public class DataDolomitDTOServiceImpl {

//    private final DataDolomitRepository dataDolomitRepository;
//
//
//    private final CarriageTypeService carriageTypeService;
//    private final LogRepository logRepository;
//
//    private final LogService logService;
//
//    @Autowired
//    public DataDolomitDTOServiceImpl(DataDolomitRepository dataDolomitRepository, CarriageTypeService carriageTypeService,
//                                     LogRepository logRepository, LogService logService) {
//        this.dataDolomitRepository = dataDolomitRepository;
//        this.carriageTypeService = carriageTypeService;
//        this.logRepository = logRepository;
//        this.logService = logService;
//    }
//
//    private CarriageType cs_cmv_carriageType;
//    private CarriageType hp_carriageType;
//    private CarriageType pv_carriageType;
//
//
////    private List<CarriageType> getCarriageTypeList(){
////        return carriageTypeService.getAllCarriageTypes();
////    }
//
//
//    @PostConstruct
//    private void initializeCarriageTypes() {
//        List<CarriageType> carriageTypes = new ArrayList<>();
//        try {
//            carriageTypes = carriageTypeService.getAllCarriageTypes();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (!carriageTypes.isEmpty()) {
//            cs_cmv_carriageType = carriageTypes.get(0);
//            hp_carriageType = carriageTypes.get(1);
//            pv_carriageType = carriageTypes.get(2);
//        }
//    }
//
//    @Override
//    public List<DataDolomitDTO> getAllPreLastMonth() {
//        return null;
//    }
//
//    @Override
//    public List<DataDolomitDTO> getAllLastMonth() {
//        List<DataDolomit> dataDolomitLastMonthsList = dataDolomitRepository.findAll();
//
//        Map<String, List<DataDolomit>> groupedRecordsByDate = dataDolomitLastMonthsList.stream()
//                .collect(Collectors.groupingBy(record -> formatDate(record.getDateCreated())));
//
//        List<DataDolomit> dataDolomitDTOLastMonthsList = groupedRecordsByDate.entrySet();
////                .stream()
////                .map(entry -> {
////                    List<DataDolomit> groupForOneRecordOfDTO = entry.getValue();
//                    return new DataDolomitDTO.Builder()
//                            .cs_cmv_id(groupForOneRecordOfDTO.get(0).getId())
//                            .cs_cmv_dateCreated(groupForOneRecordOfDTO.get(0).getDateCreated())
//                            .cs_cmv_zayavleno(groupForOneRecordOfDTO.get(0).getZayavleno())
//                            .cs_cmv_prinyato(groupForOneRecordOfDTO.get(0).getPrinyato())
//                            .cs_cmv_pogruzheno(groupForOneRecordOfDTO.get(0).getPogruzheno())
//                            .cs_cmv_plusMinusPrinyato(groupForOneRecordOfDTO.get(0).getPogruzheno()
//                                    - groupForOneRecordOfDTO.get(0).getPrinyato())
//                            .hp_id(groupForOneRecordOfDTO.get(1).getId())
//                            .hp_dateCreated(groupForOneRecordOfDTO.get(1).getDateCreated())
//                            .hp_zayavleno(groupForOneRecordOfDTO.get(1).getZayavleno())
//                            .hp_prinyato(groupForOneRecordOfDTO.get(1).getPrinyato())
//                            .hp_pogruzheno(groupForOneRecordOfDTO.get(1).getPogruzheno())
//                            .hp_plusMinusPrinyato(groupForOneRecordOfDTO.get(1).getPogruzheno()
//                                    - groupForOneRecordOfDTO.get(1).getPrinyato())
//                            .pv_id(groupForOneRecordOfDTO.get(2).getId())
//                            .pv_dateCreated(groupForOneRecordOfDTO.get(2).getDateCreated())
//                            .pv_zayavleno(groupForOneRecordOfDTO.get(2).getZayavleno())
//                            .pv_prinyato(groupForOneRecordOfDTO.get(2).getPrinyato())
//                            .pv_pogruzheno(groupForOneRecordOfDTO.get(2).getPogruzheno())
//                            .pv_plusMinusPrinyato(groupForOneRecordOfDTO.get(2).getPogruzheno()
//                                    - groupForOneRecordOfDTO.get(2).getPrinyato())
//                            .build();
//                })
//                .collect(Collectors.toList());
//
//        return dataDolomitDTOLastMonthsList;
//    }
//
//    @Override
//    public List<DataDolomit> create(DataDolomitDTO requestDataDolomitDTO) {
//        List<DataDolomit> newDataDolomitRecordsList = Arrays.asList(
//                new DataDolomit(
//                        new Date(),
//                        requestDataDolomitDTO.getCs_cmv_zayavleno(),
//                        requestDataDolomitDTO.getCs_cmv_prinyato(),
//                        requestDataDolomitDTO.getCs_cmv_pogruzheno(),
//                        carriageTypeService.getAllCarriageTypes().get(0)
//                ),
//                new DataDolomit(
//                        new Date(),
//                        requestDataDolomitDTO.getHp_zayavleno(),
//                        requestDataDolomitDTO.getHp_prinyato(),
//                        requestDataDolomitDTO.getHp_pogruzheno(),
//                        carriageTypeService.getAllCarriageTypes().get(1)
//                ),
//                new DataDolomit(
//                        new Date(),
//                        requestDataDolomitDTO.getPv_zayavleno(),
//                        requestDataDolomitDTO.getPv_prinyato(),
//                        requestDataDolomitDTO.getPv_pogruzheno(),
//                        carriageTypeService.getAllCarriageTypes().get(2)
//                )
//        );
//
//        return dataDolomitRepository.saveAll(newDataDolomitRecordsList);
//    }
//
//
//    @Override
//    public List<DataDolomit> update(DataDolomitDTO requestDataDolomitDTO) {
//        List<DataDolomit> dataDolomitListForUpdate = new ArrayList<>();
//
//        // Обновление записи для cs_cmv
//        dataDolomitRepository.findById(requestDataDolomitDTO.getCs_cmv_id())
//                .ifPresent(cs_cmv_recordForDataDolomit -> {
//                    cs_cmv_recordForDataDolomit.setZayavleno(requestDataDolomitDTO.getCs_cmv_zayavleno());
//                    cs_cmv_recordForDataDolomit.setPrinyato(requestDataDolomitDTO.getCs_cmv_prinyato());
//                    cs_cmv_recordForDataDolomit.setPogruzheno(requestDataDolomitDTO.getCs_cmv_pogruzheno());
//                    cs_cmv_recordForDataDolomit.setCarriageType(cs_cmv_carriageType);
//                    dataDolomitListForUpdate.add(cs_cmv_recordForDataDolomit);
//                });
//
//        // Обновление записи для hp
//        dataDolomitRepository.findById(requestDataDolomitDTO.getHp_id())
//                .ifPresent(hp_recordForDataDolomit -> {
//                    hp_recordForDataDolomit.setZayavleno(requestDataDolomitDTO.getHp_zayavleno());
//                    hp_recordForDataDolomit.setPrinyato(requestDataDolomitDTO.getHp_prinyato());
//                    hp_recordForDataDolomit.setPogruzheno(requestDataDolomitDTO.getHp_pogruzheno());
//                    hp_recordForDataDolomit.setCarriageType(hp_carriageType);
//                    dataDolomitListForUpdate.add(hp_recordForDataDolomit);
//                });
//
//        // Обновление записи для pv
//        dataDolomitRepository.findById(requestDataDolomitDTO.getPv_id())
//                .ifPresent(pv_recordForDataDolomit -> {
//                    pv_recordForDataDolomit.setZayavleno(requestDataDolomitDTO.getPv_zayavleno());
//                    pv_recordForDataDolomit.setPrinyato(requestDataDolomitDTO.getPv_prinyato());
//                    pv_recordForDataDolomit.setPogruzheno(requestDataDolomitDTO.getPv_pogruzheno());
//                    pv_recordForDataDolomit.setCarriageType(pv_carriageType);
//                    dataDolomitListForUpdate.add(pv_recordForDataDolomit);
//                });
//
//        if (dataDolomitListForUpdate.size() == CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
//            return dataDolomitRepository.saveAll(dataDolomitListForUpdate);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public List<DataDolomit> delete(DataDolomitDTO requestDataDolomitDTO) {
//        List<DataDolomit> dataDolomitListForUpdate = new ArrayList<>();
//
//        // Обновление записи для cs_cmv
//        dataDolomitRepository.findById(requestDataDolomitDTO.getCs_cmv_id())
//                .ifPresent(cs_cmv_recordForDataDolomit -> {
//                    cs_cmv_recordForDataDolomit.setZayavleno(0);
//                    cs_cmv_recordForDataDolomit.setPrinyato(0);
//                    cs_cmv_recordForDataDolomit.setPogruzheno(0);
//                    cs_cmv_recordForDataDolomit.setCarriageType(cs_cmv_carriageType);
//                    dataDolomitListForUpdate.add(cs_cmv_recordForDataDolomit);
//                });
//
//        // Обновление записи для hp
//        dataDolomitRepository.findById(requestDataDolomitDTO.getHp_id())
//                .ifPresent(hp_recordForDataDolomit -> {
//                    hp_recordForDataDolomit.setZayavleno(0);
//                    hp_recordForDataDolomit.setPrinyato(0);
//                    hp_recordForDataDolomit.setPogruzheno(0);
//                    hp_recordForDataDolomit.setCarriageType(hp_carriageType);
//                    dataDolomitListForUpdate.add(hp_recordForDataDolomit);
//                });
//
//        // Обновление записи для pv
//        dataDolomitRepository.findById(requestDataDolomitDTO.getPv_id())
//                .ifPresent(pv_recordForDataDolomit -> {
//                    pv_recordForDataDolomit.setZayavleno(0);
//                    pv_recordForDataDolomit.setPrinyato(0);
//                    pv_recordForDataDolomit.setPogruzheno(0);
//                    pv_recordForDataDolomit.setCarriageType(pv_carriageType);
//                    dataDolomitListForUpdate.add(pv_recordForDataDolomit);
//                });
//
//        if (dataDolomitListForUpdate.size() == CONTROL_COUNT_ELEMENTS_DATA_DOLOMIT_LIST) {
//            return dataDolomitRepository.saveAll(dataDolomitListForUpdate);
//        } else {
//            return null;
//        }
//    }
}
