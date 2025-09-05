package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Neighborhood {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private District district;
}
