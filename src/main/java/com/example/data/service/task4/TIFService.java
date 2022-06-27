package com.example.data.service.task4;

import com.example.data.entity.task4.PaymentType;
import com.example.data.entity.task4.TIF;
import com.example.data.repository.task4.CIFRepository;
import com.example.data.repository.task4.TIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TIFService {

    @Autowired
    TIFRepository tifRepository;

    @Transactional
    public PaymentType create(PaymentType paymentType){
        return tifRepository.save(paymentType);
    }

    @Transactional
    public PaymentType update(PaymentType paymentType){
        return tifRepository.save(paymentType);
    }

    @Transactional(readOnly = true)
    public PaymentType findById(Long id){
        return tifRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<PaymentType> findall(){
        return tifRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id){
        tifRepository.deleteById(id);
    }
}
