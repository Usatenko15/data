package com.example.data.entity.task4;

import com.example.data.entity.task4.enums.TypeBIF;
import com.example.data.entity.task4.enums.TypeCIF;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CIF")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CIF extends PaymentType {
    private long averageMonthly;

    public CIF(Long total, TypeCIF type, String description, long averageMonthly) {
        super(total, type.toString(), description);
        this.averageMonthly = averageMonthly;
    }

    public void setType(TypeCIF type) {
        this.setType(type.toString());
    }
}
