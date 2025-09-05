package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String identification;
    private String name;
    private String lastname;
    private String email;
    private int phoneNumber;
    @ManyToOne
    private Neighborhood neighborhood;
}
