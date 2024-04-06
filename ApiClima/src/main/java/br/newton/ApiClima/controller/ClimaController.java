package br.newton.ApiClima.controller;

import br.newton.ApiClima.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/clima")
    public String getClima(){
        return climaService.preverTempo();
    }
    @GetMapping("/climaBH")
    public String getClimaBH(){
        return climaService.preverTempoBH();
    }
}
