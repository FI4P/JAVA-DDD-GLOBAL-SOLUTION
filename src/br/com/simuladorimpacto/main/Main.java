package br.com.simuladorimpacto.main;

import br.com.simuladorimpacto.services.CalculadoraImpactoService;
import br.com.simuladorimpacto.services.EmpresaService;
import br.com.simuladorimpacto.ui.Menu;

public class Main {
    public static void main(String[] args) {
        EmpresaService empresaService = new EmpresaService();
        CalculadoraImpactoService calculadoraImpactoService = new CalculadoraImpactoService();

        Menu menu = new Menu(empresaService, calculadoraImpactoService);

        menu.exibirMenu();

    }
}