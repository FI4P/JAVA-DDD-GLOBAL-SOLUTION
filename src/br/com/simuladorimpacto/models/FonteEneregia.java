package br.com.simuladorimpacto.models;

/**
 * Classe base para representar uma fonte de energia.
 * Cada tipo de fonte de energia deve herdar dessa classe e implementar os métodos de cálculo de emissão e custo.
 */
public abstract class FonteEneregia {

        private String nome; // Nome da fonte de energia

        // Construtor para inicializar o nome
        public FonteEneregia(String nome) {
                this.nome = nome;
        }

        /**
         * Retorna o nome da fonte de energia.
         * @return Nome da fonte de energia.
         */
        public String getNome() {
                return nome;
        }

        public abstract double calcularEmissoes(double consumo); // Calcula emissões de CO2 em kg
        public abstract double calcularCusto(double consumo);     // Calcula o custo de energia em R$
}
