package com.gh.backend.gh.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "servicos")
public class Servico {
    @Id
    private String id;
    private String clienteId;
    private String nomeCliente;
    private TipoServico tipoServico;
    private String descricao;

    // Para assessoria
    private Double valorHora;
    private Integer horasMensais;
    private Double valorMensal;

    // Para storymaker
    private Double deslocamentoKm;
    private Double custoPorKm;
    private Double totalCustoDeslocamento;
    private Double horasServico;
    private Double valorTotal;


    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public Integer getHorasMensais() {
        return horasMensais;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public Double getDeslocamentoKm() {
        return deslocamentoKm;
    }

    public Double getCustoPorKm() {
        return custoPorKm;
    }

    public Double getTotalCustoDeslocamento() {
        return totalCustoDeslocamento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setHorasMensais(Integer horasMensais) {
        this.horasMensais = horasMensais;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public void setDeslocamentoKm(Double deslocamentoKm) {
        this.deslocamentoKm = deslocamentoKm;
    }

    public void setCustoPorKm(Double custoPorKm) {
        this.custoPorKm = custoPorKm;
    }

    public void setTotalCustoDeslocamento(Double totalCustoDeslocamento) {
        this.totalCustoDeslocamento = totalCustoDeslocamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double getHorasServico() {
        return horasServico;
    }

    public void setHorasServico(Double horasServico) {
        this.horasServico = horasServico;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}