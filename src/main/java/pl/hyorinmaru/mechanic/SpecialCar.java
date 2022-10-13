package pl.hyorinmaru.mechanic;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SpecialCar {

    private String objectId;
    private int Year;
    private String Make;
    private String Model;
    private String Category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
