package pl.hyorinmaru.mechanic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    private String model;

    private String category;

    private int productionDate;

    private String customName;
    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "car")
    private List<Orders> orders;

}
