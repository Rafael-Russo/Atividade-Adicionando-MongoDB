package br.newton.ApiClima.controller;

import br.newton.ApiClima.model.ClimaEntity;
import br.newton.ApiClima.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @GetMapping("/clima")
    public String getClima() {
        return climaService.preverTempo();
    }

    @GetMapping("/climaBH")
    public String getClimaBH() {
        return climaService.preverTempoBH();
    }

    @GetMapping("/climaBD")
    public List<ClimaEntity> obterTodosClimas(){
        return climaService.obterTodos();
    }

    @PostMapping("/climaBD")
    public ClimaEntity salvaClima(@RequestBody ClimaEntity clima) {
        return climaService.inserir(clima);
    }

    @PutMapping("/climaBD/{id}")
    public ClimaEntity atualizaClima(@PathVariable String id, @RequestBody ClimaEntity clima){
        return climaService.atualizar(id, clima);
    }

    @DeleteMapping("/climaBD/{id}")
    public void deletaClima(@PathVariable String id) {
        climaService.excluir(id);
    }
}
