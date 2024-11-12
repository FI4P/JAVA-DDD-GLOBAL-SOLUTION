package br.com.simuladorimpacto.models;


/**
 * Fonte de energia Hidrogênio Verde.
 */

public class HidrogenioVerde extends FonteEneregia{

    public HidrogenioVerde() {
        super("Hidrogênio verde");
    }

    @Override
    public double calcularEmissoes(double consumo) {
        // Emissões muito baixas para o hidrogênio verde
        return consumo * 0.01; // 0.01 kg de CO2 por kWh
    }

    @Override
    public double calcularCusto(double consumo) {
        // Custo do hidrogênio verde
        return consumo * 0.20; // R$ 0.20 por kWh
    }

}
