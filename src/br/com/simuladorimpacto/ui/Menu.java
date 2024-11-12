package br.com.simuladorimpacto.ui;

import br.com.simuladorimpacto.models.*;
import br.com.simuladorimpacto.services.CalculadoraImpactoService;
import br.com.simuladorimpacto.services.EmpresaService;

import java.util.Scanner;

public class Menu {

    private EmpresaService empresaService;
    private CalculadoraImpactoService calculadoraService;
    private Scanner scanner;


    public Menu(EmpresaService empresaService, CalculadoraImpactoService calculadoraService) {
        this.empresaService = empresaService;
        this.calculadoraService = calculadoraService;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Menu Simulador de Impacto ---");
            System.out.println("1 - Adicionar Empresa");
            System.out.println("2 - Consultar Estatísticas de Empresa");
            System.out.println("3 - Listar Empresas Cadastradas");
            System.out.println("4. Calcular impacto ambiental");
            System.out.println("5. Calcular economia financeira");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEmpresa();
                    break;
                case 2:
                    consultarEstatisticas();
                    break;
                case 3:
                    listarEmpresas();
                    break;
                case 4:
                    compararImpactoAmbiental();
                    break;
                case 5:
                    compararEconomiaFinanceira();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }




    private void cadastrarEmpresa() {
        System.out.print("Informe o nome da empresa: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o CNPJ da empresa: ");
        String cnpj = scanner.nextLine();
        System.out.print("Informe o consumo de energia (kWh): ");
        double consumo = scanner.nextDouble();
        scanner.nextLine();  // Consumir o caractere de nova linha

        System.out.println("Escolha a fonte de energia:");
        System.out.println("1 - Carvão");
        System.out.println("2 - Solar");
        System.out.println("3 - Hidrogênio Verde");
        int escolhaFonte = scanner.nextInt();
        FonteEneregia fonteEnergia = null;

        fonteEnergia = selecionarFonte(escolhaFonte);

        ConsumoEnergia consumoEnergia = new ConsumoEnergia(consumo);
        Empresa empresa = new Empresa(nome, cnpj, consumoEnergia, fonteEnergia);
        empresaService.cadastrarEmpresa(empresa);
        System.out.println("Empresa cadastrada com sucesso!");
    }

    private void consultarEstatisticas() {
        System.out.print("Informe o nome da empresa para consultar as estatísticas: ");
        String nomeConsulta = scanner.nextLine();
        empresaService.consultarEstatisticas(nomeConsulta);
    }

    private void listarEmpresas() {
        empresaService.listarEmpresas();
    }

    private void compararImpactoAmbiental() {
        System.out.println("Escolha a empresa para comparar as fontes de energia:");
        System.out.print("Informe o nome da empresa: ");
        String nomeConsulta = scanner.nextLine();

        Empresa empresa = empresaService.buscarEmpresa(nomeConsulta);

        if (empresa == null) {
            System.out.println("Empresa não encontrada.");
            return;
        }

        System.out.println("Escolha a fonte de energia atual:");
        System.out.println("1 - Carvão");
        System.out.println("2 - Solar");
        System.out.println("3 - Hidrogênio Verde");
        int fonteAtualEscolha = scanner.nextInt();

        FonteEneregia fonteAtual = selecionarFonte(fonteAtualEscolha);
        if (fonteAtual == null) {
            System.out.println("Fonte de energia inválida.");
            return;
        }

        System.out.println("Escolha a nova fonte de energia:");
        int novaFonteEscolha = scanner.nextInt();
        FonteEneregia novaFonte = selecionarFonte(novaFonteEscolha);
        if (novaFonte == null) {
            System.out.println("Fonte de energia inválida.");
            return;
        }

        // Comparação de economia de CO2 entre fontes utilizando CalculadoraImpacto
        double economia = calculadoraService.calcularEconomiaCo2(empresa.getConsumoEnergia(), fonteAtual, novaFonte);
        System.out.println("Economia de CO2 ao trocar de " + fonteAtual.getNome() + " para " + novaFonte.getNome() + ": " + economia + " toneladas de CO2.");
    }

    private void compararEconomiaFinanceira() {
        System.out.println("Escolha a empresa para comparar as fontes de energia:");
        System.out.print("Informe o nome da empresa: ");
        String nomeConsulta = scanner.nextLine();

        Empresa empresa = empresaService.buscarEmpresa(nomeConsulta);

        if (empresa == null) {
            System.out.println("Empresa não encontrada.");
            return;
        }

        System.out.println("Escolha a fonte de energia atual:");
        System.out.println("1 - Carvão");
        System.out.println("2 - Solar");
        System.out.println("3 - Hidrogênio Verde");
        int fonteAtualEscolha = scanner.nextInt();

        FonteEneregia fonteAtual = selecionarFonte(fonteAtualEscolha);
        if (fonteAtual == null) {
            System.out.println("Fonte de energia inválida.");
            return;
        }

        System.out.println("Escolha a nova fonte de energia:");
        int novaFonteEscolha = scanner.nextInt();
        FonteEneregia novaFonte = selecionarFonte(novaFonteEscolha);
        if (novaFonte == null) {
            System.out.println("Fonte de energia inválida.");
            return;
        }

        // Comparação de Financeira entre fontes utilizando CalculadoraImpactoService
        double economia = calculadoraService.calcularEconomiaFinanceira(empresa.getConsumoEnergia(), fonteAtual, novaFonte);
        System.out.println("Economia de Financeira ao trocar de " + fonteAtual.getNome() + " para " + novaFonte.getNome() + ": R$  " + economia);
    }

    private FonteEneregia selecionarFonte(int escolha) {
        switch (escolha) {
            case 1:
                return new Carvao();
            case 2:
                return new Solar();
            case 3:
                return new HidrogenioVerde();
            default:
                return null;
        }
    }


}
