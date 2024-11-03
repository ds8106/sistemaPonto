package com.ponto.modulo.model;


import jakarta.persistence.*;


@Entity
public class BoletaPontoModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registroEntrada;
    private String registroSaida;
    @ManyToOne
    @JoinColumn(name = "cadastro_model_id")
    private CadastroModel cadastroModel;
    private double bancoDeHoras;

    public BoletaPontoModel(Long id, String registroEntrada, String registroSaida, CadastroModel cadastroModel, double bancoDeHoras) {
        this.id = id;
        this.registroEntrada = registroEntrada;
        this.registroSaida = registroSaida;
        this.cadastroModel = cadastroModel;
        this.bancoDeHoras = bancoDeHoras;
    }

    BoletaPontoModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(String registroEntrada) {
        this.registroEntrada = registroEntrada;
    }

    public String getRegistroSaida() {
        return registroSaida;
    }

    public void setRegistroSaida(String registroSaida) {
        this.registroSaida = registroSaida;
    }

    public CadastroModel getCadastroModel() {
        return cadastroModel;
    }

    public void setCadastroModel(CadastroModel cadastroModel) {
        this.cadastroModel = cadastroModel;
    }

    public double getBancoDeHoras() {
        return bancoDeHoras;
    }

    public void setBancoDeHoras(double bancoDeHoras) {
        this.bancoDeHoras = bancoDeHoras;
    }
}