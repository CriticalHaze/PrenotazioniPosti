package org.cinema_enhanced.com.controller;

import org.cinema_enhanced.com.entity.*;
import org.cinema_enhanced.com.repository.*;
import org.cinema_enhanced.com.service.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.text.*;
import java.util.*;

@Controller
@RequestMapping("/azione")
public class PrenotazioneController {

    private final UserRepository userRepository;
    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(UserRepository userRepository, PrenotazioneService prenotazioneService) {
        this.userRepository = userRepository;
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping("/seldata/{id_utente}")
    public String scegliData(Model model, @PathVariable String id_utente){
        User loggedUser = userRepository.findById(Long.parseLong(id_utente)).orElse(null);
        model.addAttribute("loggedUser", loggedUser);
        return "dashboard/list";
    }

    @PostMapping("/seldata")
    public String selezioneData(@RequestParam("id_utente") String id_utente, @RequestParam("data_prenotazione") String data_prenotazione, Model model) throws ParseException {
        Date data_pren =new SimpleDateFormat("yyyy-MM-dd").parse(data_prenotazione);
        User loggedUser = userRepository.findById(Long.parseLong(id_utente)).orElse(null);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("postazioni", prenotazioneService.postazioniLiberePerData(data_pren));
        return "dashboard/prenota";
    }
}
