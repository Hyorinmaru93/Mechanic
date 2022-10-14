package pl.hyorinmaru.mechanic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Car car;

    private int status;

    private LocalDateTime createdOn;

    private LocalDateTime closedOn;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Services> services;

    @OneToOne
    private Calendar calendar;

}
