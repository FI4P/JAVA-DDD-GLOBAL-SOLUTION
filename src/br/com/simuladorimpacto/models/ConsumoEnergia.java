package br.com.simuladorimpacto.models;

/**
 * Representa o consumo de energia de um usuário ou empresa.
 */

public class ConsumoEnergia {

    private double consumo;

    public ConsumoEnergia(double consumo){
        this.consumo = consumo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}

