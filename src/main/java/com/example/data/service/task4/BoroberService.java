package com.example.data.service.task4;

import com.example.data.entity.task3.Order;
import com.example.data.entity.task4.Borover;
import com.example.data.repository.BoroverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoroberService {

    @Autowired
    BoroverRepository boroverRepository;

    @Transactional
    public Borover create(Borover borover) {
        return boroverRepository.save(borover);
    }
}
