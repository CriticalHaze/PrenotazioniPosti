package org.cinema_enhanced.com.service;

import org.cinema_enhanced.com.entity.*;
import org.cinema_enhanced.com.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> postazioniLiberePerData(Date data_prenotazione){
        List<Prenotazione> prenotazioniPerData = prenotazioneRepository.postazioniPrenotatePerData(data_prenotazione);
        List<Postazione> allPostazioni = postazioneRepository.findAll();

        for(int i = 0; i < prenotazioniPerData.size();i++){
            Postazione pOccupata = postazioneRepository.findById(prenotazioniPerData.get(i).getId()).orElse(null);
            if(allPostazioni.contains(pOccupata)){
                assert pOccupata != null;
                pOccupata.setOccupata(true);
                allPostazioni.set(allPostazioni.indexOf(pOccupata), pOccupata);
            }
        }

        return allPostazioni;
    }
}
