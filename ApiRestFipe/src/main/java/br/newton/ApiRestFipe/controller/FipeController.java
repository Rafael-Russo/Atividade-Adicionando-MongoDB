package br.newton.ApiRestFipe.controller;

import br.newton.ApiRestFipe.model.MarcaEntity;
import br.newton.ApiRestFipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FipeController {
    @Autowired
    private FipeService fipeService;

    @GetMapping("/marcas")
    public String consultarMarcas(){
        return fipeService.consultarMarcas();
    }
    @GetMapping("/marca/{id}")
    public MarcaEntity marcaPorId(@PathVariable String id){
        return fipeService.marcaPorId(id);
    }
    @PostMapping("/marca")
    public MarcaEntity inserirMarca(@RequestBody MarcaEntity marca){
        return fipeService.inserirMarca(marca);
    }
    @PutMapping("/marca/{id}")
    public MarcaEntity atualizaMarca(@PathVariable String id, @RequestBody MarcaEntity marca){
        return fipeService.atualizaMarca(id, marca);
    }
    @DeleteMapping("/marca/{id}")
    public void deletaMarca(@PathVariable String id){
        fipeService.deletaMarca(id);
    }

    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca){
        return fipeService.consultarModelos(marca);
    }
    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo){
        return fipeService.consultarAnos(marca, modelo);
    }
    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano){
        return fipeService.consultarValor(marca, modelo, ano);
    }
}
