package com.example.data.entity.task4;


import com.example.data.entity.task2.AnotherBuilding;
import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "Payment_Type",
        discriminatorType = DiscriminatorType.STRING
)
@NoArgsConstructor
@Getter
@Setter
public abstract class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long total;
    private String type;
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "borover_id", referencedColumnName = "borover_id")
//    private Borover borover;

    public PaymentType(Long total, String type, String description) {
        this.total = total;
        this.type = type;
        this.description = description;
    }
}
