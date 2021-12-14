package com.example.reist_app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
    @JsonProperty("cpfusuario")
    public int cpfusuario;
    @JsonProperty("nomeusuario")
    public String nomeusuario;
    @JsonProperty("emailusuario")
    public String emailusuario;
    @JsonProperty("senhausuario")
    public String senhausuario;
    @JsonProperty("celularusuario")
    public String celularusuario;
    @JsonProperty("sexousuario")
    public String sexousuario;
    @JsonProperty("nascimentousuario")
    public String nascimentousuario;
    @JsonProperty("numerousuario")
    public int numerousuario;
    @JsonProperty("cepusuario")
    public String cepusuario;

    public Usuario(){

    }

    public Usuario(int cpf, String nome, String email, String senha, String celular, String sexo, String nascimento, int numero, String cep){
        this.cpfusuario = cpf;
        this.nomeusuario = nome;
        this.emailusuario = email;
        this.senhausuario = senha;
        this.celularusuario = celular;
        this.sexousuario = sexo;
        this.nascimentousuario = nascimento;
        this.numerousuario = numero;
        this.cepusuario = cep;
    }

    public int getCpfusuario() {
        return cpfusuario;
    }

    public void setCpfusuario(int cpfusuario) {
        this.cpfusuario = cpfusuario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    public String getCelularusuario() {
        return celularusuario;
    }

    public void setCelularusuario(String celularusuario) {
        this.celularusuario = celularusuario;
    }

    public String getSexousuario() {
        return sexousuario;
    }

    public void setSexousuario(String sexousuario) {
        this.sexousuario = sexousuario;
    }

    public String getNascimentousuario() {
        return nascimentousuario;
    }

    public void setNascimentousuario(String nascimentousuario) {
        this.nascimentousuario = nascimentousuario;
    }

    public int getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(int numerousuario) {
        this.numerousuario = numerousuario;
    }

    public String getCepusuario() {
        return cepusuario;
    }

    public void setCepusuario(String cepusuario) {
        this.cepusuario = cepusuario;
    }
}