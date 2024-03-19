package br.insper.campeonato.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/time")
    public ArrayList<Time> getTimes(@RequestParam(required = false) String estado) { // PathVariable normalmente só para id
        return timeService.listarTimes(estado);
    }

    @GetMapping("/time/{identificador}")
    public Time getTime(@PathVariable String identificador) {
        return timeService.getTime(identificador);
    }

    @PostMapping("/time")
    public Time salvarTime(@RequestBody Time time) {
        return timeService.cadastrarTime(time);
    }

    @DeleteMapping("/time/{identificador}")
    public void delete(@PathVariable String identificador) {
        timeService.excluirTimes(identificador);
    }


}
