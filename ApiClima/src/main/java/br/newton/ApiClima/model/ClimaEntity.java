package br.newton.ApiClima.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clima")
public class ClimaEntity {
    @Id
    private String id;
    private String country;
    private String date;
    private String text;

    @JsonCreator
    public ClimaEntity(@JsonProperty("id") String id,
                       @JsonProperty("country") String country,
                       @JsonProperty("date") String date,
                       @JsonProperty("text") String text) {
        this.id = id;
        this.country = country;
        this.date = date;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
