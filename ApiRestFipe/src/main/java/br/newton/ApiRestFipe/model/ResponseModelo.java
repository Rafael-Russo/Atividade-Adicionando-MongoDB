package br.newton.ApiRestFipe.model;

import java.util.List;

public class ResponseModelo {
    private List<ModeloEntity> modelos;
    private List<AnosEntity> anos;

    // Getters e Setters
    public List<ModeloEntity> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloEntity> modelos) {
        this.modelos = modelos;
    }

    public List<AnosEntity> getAnos() {
        return anos;
    }

    public void setAnos(List<AnosEntity> anos) {
        this.anos = anos;
    }
}

