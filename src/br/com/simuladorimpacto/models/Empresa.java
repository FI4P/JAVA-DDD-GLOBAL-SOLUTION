package br.com.simuladorimpacto.models;

public class Empresa {

    private String nome;
    private String cnpj;
    private ConsumoEnergia consumoEnergia;
    private FonteEneregia fonteEnergia;

    public Empresa(String nome, String cnpj, ConsumoEnergia consumoEnergia, FonteEneregia fonteEnergia) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.consumoEnergia = consumoEnergia;
        this.fonteEnergia = fonteEnergia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ConsumoEnergia getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(ConsumoEnergia consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public FonteEneregia getFonteEnergia() {
        return fonteEnergia;
    }

    public void setFonteEnergia(FonteEneregia fonteEnergia) {
        this.fonteEnergia = fonteEnergia;
    }

    /**
     * Calcula o impacto ambiental (emissões de CO2) de uma empresa com base no consumo e fonte de energia.
     */

    public double calcularEmissoes() {
        return fonteEnergia.calcularEmissoes(consumoEnergia.getConsumo());
    }

    /**
     * Calcula o custo da energia de uma empresa com base no consumo e fonte de energia.
     */
    public double calcularCusto() {
        return fonteEnergia.calcularCusto(consumoEnergia.getConsumo());
    }


}
