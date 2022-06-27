package com.example.data.service.task4;

import com.example.data.entity.task4.BIF;
import com.example.data.entity.task4.PaymentType;
import com.example.data.repository.task4.BIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentService {
    @Autowired
    BIFRepository bifRepository;

    @Transactional
    public List<PaymentType> addTotal(long total) {
        List<PaymentType> paymentTypeList = bifRepository.findAll();
        paymentTypeList.forEach(paymentType -> paymentType.setTotal(paymentType.getTotal() + total));
        return paymentTypeList;
    }
}
