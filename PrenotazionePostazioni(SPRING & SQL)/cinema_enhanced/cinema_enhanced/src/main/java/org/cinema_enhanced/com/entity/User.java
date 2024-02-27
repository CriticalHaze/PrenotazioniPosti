package org.cinema_enhanced.com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private Short ruolo;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Prenotazione> prenotazioni = new ArrayList<>();

}
