package br.com.simuladorimpacto.services;

import br.com.simuladorimpacto.models.Empresa;

import java.util.List;
import java.util.ArrayList;


/**
 * Classe responsável pelo cadastro e gerenciamento de empresas.
 */

public class EmpresaService {

    private List<Empresa> empresas = new ArrayList<>();

    /**
     * Adiciona uma nova empresa ao cadastro.
     */
    public void cadastrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }


    /**
     * Busca uma empresa pelo nome.
     * @param nome O nome da empresa a ser buscada.
     * @return A empresa encontrada ou null se não existir.
     */
    public Empresa buscarEmpresa(String nome) {
        for (Empresa empresa : empresas) {
            if (empresa.getNome().equalsIgnoreCase(nome)) {
                return empresa;
            }
        }
        return null;
    }

    /**
     * Consulta as estatísticas de uma empresa pelo nome.
     */
    public void consultarEstatisticas(String nomeEmpresa) {
        for (Empresa empresa : empresas) {
            if (empresa.getNome().equals(nomeEmpresa)) {
                System.out.println("Estatísticas da empresa: " + empresa.getNome());
                System.out.println("CNPJ: " + empresa.getCnpj());
                System.out.println("Consumo de energia: " + empresa.getConsumoEnergia().getConsumo() + " kWh");
                System.out.println("Custo de energia: R$ " + empresa.calcularCusto());
                System.out.println("Emissões de CO2: " + empresa.calcularEmissoes() + " kg");
                return;
            }
        }
        System.out.println("Empresa não encontrada.");
    }

    /**
     * Exibe todas as empresas cadastradas.
     */
    public void listarEmpresas() {
        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa cadastrada.");
        } else {
            for (Empresa empresa : empresas) {
                System.out.println("Nome: " + empresa.getNome() + " | CNPJ: " + empresa.getCnpj());
            }
        }
    }

}
