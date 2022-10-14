package pl.hyorinmaru.mechanic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Calendar {

    @Id
    private LocalDateTime date;

    @OneToOne
    private Orders orders;
}
