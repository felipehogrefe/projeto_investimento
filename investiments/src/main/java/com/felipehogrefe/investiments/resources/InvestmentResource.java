package com.felipehogrefe.investiments.resources;

import com.felipehogrefe.investiments.entities.DailyValue;
import com.felipehogrefe.investiments.entities.DailyValues;
import com.felipehogrefe.investiments.entities.Investment;
import com.felipehogrefe.investiments.entities.ShareValue;
import com.felipehogrefe.investiments.repositories.InvestmentRepository;
import com.felipehogrefe.investiments.repositories.ShareValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/investments")
public class InvestmentResource {
    private static Logger logger = LoggerFactory.getLogger(InvestmentResource.class);

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private ShareValueRepository shareValueRepository;

    @GetMapping
    public ResponseEntity<List<Investment>> findAll(){
        return ResponseEntity.ok(investmentRepository.findAll());
    }

    @GetMapping(value = "/history/{investmentId}")
    public ResponseEntity<DailyValues> getHistoryOfInvestment(@PathVariable Long investmentId){
        Investment investment = investmentRepository.getById(investmentId);
        List<DailyValue> dailyValueList = new ArrayList<>();
        investment.getLocalStartDate().datesUntil(investment.getLocalEndDate()).forEach(localDate -> {
            dailyValueList.add(new DailyValue(shareValueRepository.getByDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())), investment.getQuantityOfQuotas()));
        });
        DailyValues dailyValues = new DailyValues(dailyValueList);
        return ResponseEntity.ok(dailyValues);
    }

//    @GetMapping(value = "/share/{share_id}/history")
//    public ResponseEntity<DailyValues> getHistoryOfInvestmentOnShare(@PathVariable Long shareId){
//        Investment investment = investmentRepository.getById(investmentId);
//        List<DailyValue> dailyValueList = new ArrayList<>();
//        investment.getLocalStartDate().datesUntil(investment.getLocalEndDate()).forEach(localDate -> {
//            dailyValueList.add(new DailyValue(shareValueRepository.getByDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())), investment.getQuantityOfQuotas()));
//        });
//        DailyValues dailyValues = new DailyValues(dailyValueList);
//        return ResponseEntity.ok(dailyValues);
//    }
//
//    @GetMapping(value = "/share/{share_id}/history/{investmentId}")
//    public ResponseEntity<DailyValues> getHistoryOfSpecificInvestmentOnShare(@PathVariable Long investmentId){
//        Investment investment = investmentRepository.getById(investmentId);
//        List<DailyValue> dailyValueList = new ArrayList<>();
//        investment.getLocalStartDate().datesUntil(investment.getLocalEndDate()).forEach(localDate -> {
//            dailyValueList.add(new DailyValue(shareValueRepository.getByDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())), investment.getQuantityOfQuotas()));
//        });
//        DailyValues dailyValues = new DailyValues(dailyValueList);
//        return ResponseEntity.ok(dailyValues);
//    }
}
