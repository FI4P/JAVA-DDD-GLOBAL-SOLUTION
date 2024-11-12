package br.com.simuladorimpacto.models;

public class EmissaoCo2 {

   public double totalEmissoes;

    public EmissaoCo2(double totalEmissoes) {
        this.totalEmissoes = totalEmissoes;
    }

    public double getTotalEmissoes() {
        return totalEmissoes;
    }

    public void setTotalEmissoes(double totalEmissoes) {
        this.totalEmissoes = totalEmissoes;
    }

    public double calcularEmissoesTotais(ConsumoEnergia energia, FonteEneregia fonteEneregia) {
        return energia.getConsumo() * fonteEneregia.calcularEmissoes(energia.getConsumo());
    }
}
