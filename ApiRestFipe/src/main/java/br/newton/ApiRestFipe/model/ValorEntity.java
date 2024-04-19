package br.newton.ApiRestFipe.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "valor")
public class ValorEntity {

    @Id
    private String id;
    private String tipoVeiculo;
    private String valor;
    private String marca;
    private String modelo;
    private String anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String siglaCombustivel;

    @JsonCreator
    public ValorEntity(@JsonProperty("id") String id,
                       @JsonProperty("TipoVeiculo") String tipoVeiculo,
                       @JsonProperty("Valor") String valor,
                       @JsonProperty("Marca") String marca,
                       @JsonProperty("Modelo") String modelo,
                       @JsonProperty("AnoModelo") String anoModelo,
                       @JsonProperty("Combustivel") String combustivel,
                       @JsonProperty("CodigoFipe") String codigoFipe,
                       @JsonProperty("MesReferencia") String mesReferencia,
                       @JsonProperty("SiglaCombustivel") String siglaCombustivel) {
        this.id = id;
        this.tipoVeiculo = tipoVeiculo;
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
        this.siglaCombustivel = siglaCombustivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }
}
