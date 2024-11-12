package br.com.simuladorimpacto.services;


import br.com.simuladorimpacto.models.ConsumoEnergia;
import br.com.simuladorimpacto.models.EmissaoCo2;
import br.com.simuladorimpacto.models.FonteEneregia;

/**
 * Classe que contém os métodos para calcular o impacto financeiro e ambiental de fontes de energia.
 */
public class CalculadoraImpactoService {

    public double calcularEconomiaCo2(ConsumoEnergia consumoEnergia, FonteEneregia fonteAtual, FonteEneregia novaFonte ){
        EmissaoCo2 emissaoAtual = new EmissaoCo2(fonteAtual.calcularEmissoes(consumoEnergia.getConsumo()));
        EmissaoCo2 emissaoNova = new EmissaoCo2(novaFonte.calcularEmissoes(consumoEnergia.getConsumo()));

        return emissaoAtual.getTotalEmissoes() - emissaoNova.getTotalEmissoes();

    }

    /**
     * Calcula a economia financeira ao mudar para uma fonte de energia mais barata.
     */
    public double calcularEconomiaFinanceira(ConsumoEnergia consumoEnergia, FonteEneregia fonteAtual, FonteEneregia novaFonte) {
        double custoAtual = fonteAtual.calcularCusto(consumoEnergia.getConsumo());
        double custoFuturo = novaFonte.calcularCusto(consumoEnergia.getConsumo());
        return custoAtual - custoFuturo;
    }



}
