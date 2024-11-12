package br.com.simuladorimpacto.models;

/**
 * Fonte de energia Solar.
 */

public class Solar extends FonteEneregia{
    public Solar() {
        super("Solar");
    }

    @Override
    public double calcularEmissoes(double consumo) {
        // Emissões baixas para a energia solar
        return consumo * 0.05; // 0.05 kg de CO2 por kWh
    }

    @Override
    public double calcularCusto(double consumo) {
        // Custo da energia solar
        return consumo * 0.10; // R$ 0.10 por kWh
    }

}
