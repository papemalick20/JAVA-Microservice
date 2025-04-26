package org.statistique.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.statistique.dto.StatistiqueResponseDTO;
import org.statistique.services.StatistiqueServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class StatistiqueController {

    private final StatistiqueServiceImpl statistiqueService;

    public StatistiqueController(StatistiqueServiceImpl statistiqueService) {
        this.statistiqueService = statistiqueService;
    }

    @GetMapping(path="/calculer")
    public StatistiqueResponseDTO getStatistiques() {
        return statistiqueService.getStatistiques();
    }
}
