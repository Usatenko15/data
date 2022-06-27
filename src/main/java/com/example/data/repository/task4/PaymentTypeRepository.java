package com.example.data.repository.task4;

import com.example.data.entity.task4.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}