package fi.ha.controller;

import fi.ha.domain.Observation;
import fi.ha.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class WeatherController {

    @Autowired
    ObservationRepository observationRepo;

    @RequestMapping(value = "/observation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody()
    public List<Observation> getObservations() {
        List<Observation> observations = observationRepo.findAll();
        return observations;
    }

    @RequestMapping(value = "/observation", method = RequestMethod.POST)
    @ResponseBody()
    public Observation home(@RequestBody Observation observation) {
        
        return observationRepo.save(observation);
    }
}
