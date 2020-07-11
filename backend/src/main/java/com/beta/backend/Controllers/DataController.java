package com.beta.backend.Controllers;

import com.beta.backend.Models.Analytics.Analytics;
import com.beta.backend.Models.DataContainer;
import com.beta.backend.Models.Dicts.AbstractDictTable;
import com.beta.backend.Repositories.Analytics.*;
import com.beta.backend.Repositories.Dicts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {
    /**
     * Data controller
     */

    @Autowired
    private ContractTypeAnalyticsRepository contractTypeAnalyticsRepository;

    @Autowired
    private DayOfTheWeekAppliedAnalyticsRepository dayOfTheWeekAppliedAnalyticsRepository;

    @Autowired
    private EducationTypeAnalyticsRepository educationTypeAnalyticsRepository;

    @Autowired
    private GenderAnalyticsRepository genderAnalyticsRepository;

    @Autowired
    private HousingTypeAnalyticsRepository housingTypeAnalyticsRepository;

    @Autowired
    private IncomeTypeAnalyticsRepository incomeTypeAnalyticsRepository;

    @Autowired
    private OccupationTypeAnalyticsRepository occupationTypeAnalyticsRepository;

    @Autowired
    private ContractTypeDictRepository contractTypeDictRepository;

    @Autowired
    private DayOfWeekAppliedDictRepository dayOfWeekAppliedDictRepository;

    @Autowired
    private EducationTypeDictRepository educationTypeDictRepository;

    @Autowired
    private GenderDictRepository genderDictRepository;

    @Autowired
    private HousingTypeDictRepository housingTypeDictRepository;

    @Autowired
    private IncomeTypeDictRepository incomeTypeDictRepository;

    @Autowired
    private OccupationTypeDictRepository occupationTypeDictRepository;

    @GetMapping("/data")
    public ResponseEntity<DataContainer> getData(@RequestParam(name = "type") String dataType){

        List<? extends Analytics> dataList;
        List<? extends AbstractDictTable> dictList;

        switch (dataType){
            case ("contract_type"):
                dataList = contractTypeAnalyticsRepository.findAll();
                dictList = contractTypeDictRepository.findAll();
                break;
            case ("day_of_the_week_applied"):
                dataList = dayOfTheWeekAppliedAnalyticsRepository.findAll();
                dictList = dayOfWeekAppliedDictRepository.findAll();
                break;
            case ("education_type"):
                dataList = educationTypeAnalyticsRepository.findAll();
                dictList = educationTypeDictRepository.findAll();
                break;
            case ("gender"):
                dataList = genderAnalyticsRepository.findAll();
                dictList = genderDictRepository.findAll();
                break;
            case ("housing_type"):
                dataList = housingTypeAnalyticsRepository.findAll();
                dictList = housingTypeDictRepository.findAll();
                break;
            case ("income_type"):
                dataList = incomeTypeAnalyticsRepository.findAll();
                dictList = incomeTypeDictRepository.findAll();
                break;
            case ("occupation_type"):
                dataList = occupationTypeAnalyticsRepository.findAll();
                dictList = occupationTypeDictRepository.findAll();
                break;
            default:
                dataList = new ArrayList<Analytics>();
                dictList = new ArrayList<AbstractDictTable>();
        }

        DataContainer response = new DataContainer(dataList, dictList);
        return ResponseEntity.ok().body(response);
    }



}
