package br.newton.ApiRestFipe.service;

import br.newton.ApiRestFipe.model.*;
import br.newton.ApiRestFipe.repository.AnosRepository;
import br.newton.ApiRestFipe.repository.MarcaRepository;
import br.newton.ApiRestFipe.repository.ModeloRepository;
import br.newton.ApiRestFipe.repository.ValorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FipeService {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private AnosRepository anosRepository;
    @Autowired
    private ValorRepository valorRepository;

    private String consutarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        }else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarMarcas(){
        String dados = consutarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");

        ObjectMapper mapper =new ObjectMapper();

        try{
            MarcaEntity[] marcas = mapper.readValue(dados, MarcaEntity[].class);
            for (MarcaEntity marca : marcas){
                marcaRepository.save(marca);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return dados;
    }
    public String consultarModelos(int id){
        String dados = consutarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");

        ObjectMapper mapper =new ObjectMapper();

        try{
            ResponseModelo modelos = mapper.readValue(dados, ResponseModelo.class);
            for (ModeloEntity modelo : modelos.getModelos()){
                modeloRepository.save(modelo);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return dados;
    }
    public String consultarAnos(int marca, int modelo){
        String dados = consutarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");

        ObjectMapper mapper = new ObjectMapper();

        try{
            AnosEntity[] anos = mapper.readValue(dados, AnosEntity[].class);
            for (AnosEntity ano : anos){
                anosRepository.save(ano);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return dados;
    }
    public String consultarValor(int marca, int modelo, String ano){
        String dados = consutarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos/"+ano);

        ObjectMapper mapper =new ObjectMapper();

        try{
            ValorEntity valor = mapper.readValue(dados, ValorEntity.class);
            valorRepository.save(valor);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return dados;
    }
}