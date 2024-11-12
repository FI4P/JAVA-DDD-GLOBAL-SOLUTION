package br.com.simuladorimpacto.models;

public class Carvao extends FonteEneregia{

    public Carvao(){
        super("Carvão");
    }

    @Override
    public double calcularEmissoes(double consumo) {
        // Emissões do carvão (emissões altas)
        return consumo * 1.2; // 1.2 kg de CO2 por kWh
    }

    @Override
    public double calcularCusto(double consumo) {
        // Custo do carvão
        return consumo * 0.15; // R$ 0.15 por kWh
    }

}
