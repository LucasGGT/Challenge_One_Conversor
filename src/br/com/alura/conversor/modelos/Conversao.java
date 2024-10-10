package br.com.alura.conversor.modelos;

public class Conversao {
    private String moedaBase;
    private double usd;
    private double brl;
    private double ars;
    private double cop;

    public Conversao(String moedaBase, double usd, double brl, double ars, double cop) {
        this.moedaBase = moedaBase;
        this.usd = usd;
        this.brl = brl;
        this.ars = ars;
        this.cop = cop;
    }

    public Conversao(ConversaoAPI c) {
        this.moedaBase = c.base_code();
        this.usd = c.conversion_rates().USD();
        this.brl = c.conversion_rates().BRL();
        this.ars = c.conversion_rates().ARS();
        this.cop = c.conversion_rates().COP();
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public void setMoedaBase(String moedaBase) {
        this.moedaBase = moedaBase;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public double getArs() {
        return ars;
    }

    public void setArs(double ars) {
        this.ars = ars;
    }

    public double getCop() {
        return cop;
    }

    public void setCop(double cop) {
        this.cop = cop;
    }
}
