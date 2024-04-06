package br.newton.ApiClima.service;

import br.newton.ApiClima.repository.ClimaRepository;
import br.newton.ApiClima.model.ClimaEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;

    public String preverTempo(){
        String dadosMetereoogicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=af069e25afbd606e9f2a726663e86ed3";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMetereoogicos = responseEntity.getBody();

            ObjectMapper mapper = new ObjectMapper();
            try {
                ClimaEntity[] climas = mapper.readValue(dadosMetereoogicos, ClimaEntity[].class);
                for (ClimaEntity clima : climas) {
                    climaRepository.save(clima);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else {
            dadosMetereoogicos = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }

        return dadosMetereoogicos;
    }

    public String preverTempoBH(){
        String dadosMetereoogicos = "";
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/weather/locale/6879/current?token=af069e25afbd606e9f2a726663e86ed3";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMetereoogicos = responseEntity.getBody();
        }else {
            dadosMetereoogicos = "Falha ao obter dados meteorológicos de BH. Código de status: " + responseEntity.getStatusCode();
        }
        return dadosMetereoogicos;
    }
}
