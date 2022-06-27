package com.example.data.service.task4;

import com.example.data.entity.task4.BIF;
import com.example.data.entity.task4.PaymentType;
import com.example.data.entity.task4.TIF;
import com.example.data.repository.task4.BIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BIFService {

    @Autowired
    BIFRepository bifRepository;

    @Transactional
    public PaymentType create(PaymentType paymentType) {
        return bifRepository.save(paymentType);
    }

    @Transactional
    public PaymentType update(PaymentType paymentType) {
        return bifRepository.save(paymentType);
    }

    @Transactional(readOnly = true)
    public PaymentType findById(Long id) {
        return bifRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<PaymentType> findall() {
        return bifRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        bifRepository.deleteById(id);
    }


    @Transactional
    public List<PaymentType> addTotal(long total) {
        List<PaymentType> paymentTypeList = bifRepository.findAll().stream().
                filter(paymentType -> paymentType.getClass()==BIF.class).collect(Collectors.toList());
        paymentTypeList.forEach(paymentType -> paymentType.setTotal(paymentType.getTotal() + total));
        return paymentTypeList;
    }
}
