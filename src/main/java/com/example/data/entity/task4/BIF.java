package com.example.data.entity.task4;

import com.example.data.entity.task4.enums.TypeBIF;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BIF")
@NoArgsConstructor
@Getter
@Setter
public class BIF extends PaymentType {

    private String documentName;

    public BIF(Long total, TypeBIF type, String description, String documentName) {
        super(total, type.toString(), description);
        this.documentName = documentName;
    }

    public void setType(TypeBIF type) {
        this.setType(type.toString());
    }
}
