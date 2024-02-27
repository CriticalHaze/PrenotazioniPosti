package org.cinema_enhanced.com.repository;

import org.cinema_enhanced.com.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    @Query("select p from Prenotazione p where p.data_prenotazione = ?1")
    List<Prenotazione> postazioniPrenotatePerData(Date data_prenotazione);
}
