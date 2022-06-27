package com.example.data.service.task4;

import com.example.data.entity.task4.PaymentType;
import com.example.data.entity.task4.TIF;
import com.example.data.repository.task4.CIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CIFService {

    @Autowired
    CIFRepository cifRepository;

    @Transactional
    public PaymentType create(PaymentType paymentType){
        return cifRepository.save(paymentType);
    }

    @Transactional
    public PaymentType update(PaymentType paymentType){
        return cifRepository.save(paymentType);
    }

    @Transactional(readOnly = true)
    public PaymentType findById(Long id){
        return cifRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<PaymentType> findall(){
        return cifRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        cifRepository.deleteById(id);
    }
}
