package fr.hadriel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Entity 
public class Restaurant {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String city;
    
    @Column
    private String state;
    
    @Column
    private String zipCode;
}
