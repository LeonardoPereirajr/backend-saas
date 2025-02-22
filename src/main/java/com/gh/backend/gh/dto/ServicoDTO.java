package com.gh.backend.gh.dto;

import com.gh.backend.gh.model.TipoServico;

public class ServicoDTO {
    private String id;
    private String nomeCliente;
    private String tipoServico;
    private double valorHora;
    private int horasMensais;
    private double valorMensal;
    private double deslocamentoKm;
    private double custoPorKm;
    private double totalCustoDeslocamento;

    // Construtor
    public ServicoDTO(String id, String nomeCliente, TipoServico tipoServico, double valorHora, int horasMensais, double valorMensal, double deslocamentoKm, double custoPorKm, double totalCustoDeslocamento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.tipoServico = String.valueOf(tipoServico);
        this.valorHora = valorHora;
        this.horasMensais = horasMensais;
        this.valorMensal = valorMensal;
        this.deslocamentoKm = deslocamentoKm;
        this.custoPorKm = custoPorKm;
        this.totalCustoDeslocamento = totalCustoDeslocamento;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getTipoServico() { return tipoServico; }
    public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico; }

    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }

    public int getHorasMensais() { return horasMensais; }
    public void setHorasMensais(int horasMensais) { this.horasMensais = horasMensais; }

    public double getValorMensal() { return valorMensal; }
    public void setValorMensal(double valorMensal) { this.valorMensal = valorMensal; }

    public double getDeslocamentoKm() { return deslocamentoKm; }
    public void setDeslocamentoKm(double deslocamentoKm) { this.deslocamentoKm = deslocamentoKm; }

    public double getCustoPorKm() { return custoPorKm; }
    public void setCustoPorKm(double custoPorKm) { this.custoPorKm = custoPorKm; }

    public double getTotalCustoDeslocamento() { return totalCustoDeslocamento; }
    public void setTotalCustoDeslocamento(double totalCustoDeslocamento) { this.totalCustoDeslocamento = totalCustoDeslocamento; }
}
