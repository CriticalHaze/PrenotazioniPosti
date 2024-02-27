package org.cinema_enhanced.com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Transient
    private boolean occupata;

    @OneToMany(mappedBy = "postazione", orphanRemoval = true)
    private List<Prenotazione> prenotazioni = new ArrayList<>();
}
