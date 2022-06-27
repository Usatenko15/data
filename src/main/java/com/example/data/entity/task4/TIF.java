package com.example.data.entity.task4;

import com.example.data.entity.task4.enums.TypeCIF;
import com.example.data.entity.task4.enums.TypeTIF;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TIF")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TIF extends PaymentType {
    private long rate;

    public TIF(Long total, TypeTIF type, String description, long rate) {
        super(total, type.toString(), description);
        this.rate = rate;
    }

    public void setType(TypeTIF type) {
        this.setType(type.toString());
    }
}
