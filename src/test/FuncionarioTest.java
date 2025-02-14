package test;

import service.FuncionarioService;

public class FuncionarioTest {
    private FuncionarioService funcionarioService;

    public FuncionarioTest(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public void inserir() {
        funcionarioService.inserirFuncionario();
    }

    public void imprimir() {
        funcionarioService.imprimirFuncionario();
    }

    public void excluir() {
        funcionarioService.removerFuncionario();
    }

    public void aplicarAumento() {
        funcionarioService.aplicarAumento();
    }

    public void agruparFuncao() {
        funcionarioService.agruparPorFuncao();
    }

    public void imprimirAniversariantes() {
        funcionarioService.imprimirAniversariantes(10, 9, 8);
    }

    public void imprimirMaisVelho() {
        funcionarioService.imprimirFuncionarioMaisVelho();
    }

    public void imprimirOrdemAlfabetica() {
        funcionarioService.imprimirPorOrdemAlfabetica();
    }

    public void somarSalario() {
        funcionarioService.somarSalarios();
    }

    public void calcularSalarioMinimo() {
        funcionarioService.calcularSalarioMinimo();
    }



}
