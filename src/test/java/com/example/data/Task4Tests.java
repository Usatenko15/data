package com.example.data;

import com.example.data.entity.task3.Task;
import com.example.data.entity.task4.*;
import com.example.data.entity.task4.enums.TypeBIF;
import com.example.data.entity.task4.enums.TypeCIF;
import com.example.data.entity.task4.enums.TypeTIF;
import com.example.data.repository.BoroverRepository;
import com.example.data.repository.task4.BIFRepository;
import com.example.data.repository.task4.CIFRepository;
import com.example.data.repository.task4.PaymentTypeRepository;
import com.example.data.service.task4.BIFService;
import com.example.data.service.task4.BoroberService;
import com.example.data.service.task4.CIFService;
import com.example.data.service.task4.TIFService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Task4Tests {

    @Autowired
    BIFRepository bifRepository;

    @Autowired
    CIFRepository cifRepository;

    @Autowired
    BIFService bifService;

    @Autowired
    CIFService cifService;

    @Autowired
    TIFService tifService;

    @Autowired
    BoroverRepository boroverRepository;

    @Autowired
    BoroberService boroberService;


    @Test
    void test() {
        Borover borover = new Borover();

        BIF paymentTypeBIF = new BIF(3l, TypeBIF.FORM_1065, "fsdfds", "fsd");
        CIF paymentTypeCIF = new CIF(3l, TypeCIF.PS_BASE, "fsdfds", 5l);
        TIF paymentTypeTIF = new TIF(3l, TypeTIF.SHEDULE_C, "fsdfds", 5l);

        borover.getBIF().add(paymentTypeBIF);
        borover.getCIF().add(paymentTypeCIF);
        borover.getTIF().add(paymentTypeTIF);

//        boroverRepository.save(borover);
        boroberService.create(borover);

        bifService.create(paymentTypeBIF);
        cifService.create(paymentTypeCIF);
        tifService.create(paymentTypeTIF);

        paymentTypeBIF.setType(TypeBIF.FORM_1120.toString());
        paymentTypeCIF.setType(TypeCIF.PS_Total.toString());
        paymentTypeTIF.setType(TypeTIF.SHEDULE_F.toString());

        bifService.update(paymentTypeBIF);
        cifService.update(paymentTypeCIF);
        tifService.update(paymentTypeTIF);
    }

    @Test
    void test1() {
        bifService.addTotal(30l);
    }
}
