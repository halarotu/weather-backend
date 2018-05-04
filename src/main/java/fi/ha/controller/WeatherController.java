package fi.ha.controller;

import fi.ha.domain.Observation;
import fi.ha.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"${allowed.origins}"})
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
