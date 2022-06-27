package com.example.data.entity.task4;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Borover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borover_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "borover_id")
    Set<BIF> BIF = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "borover_id")
    Set<CIF> CIF = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "borover_id")
    Set<TIF> TIF = new HashSet<>();

}
