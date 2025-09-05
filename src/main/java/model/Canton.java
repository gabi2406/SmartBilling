package model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Canton {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Province province;
}
