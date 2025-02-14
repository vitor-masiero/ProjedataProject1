package controller;

import enumeration.Funcionalidade;
import model.Funcionario;
import test.FuncionarioTest;

public class FuncionarioController {
    private final FuncionarioTest funcionarioTest;

    public FuncionarioController(FuncionarioTest funcionarioTest) {
        this.funcionarioTest = funcionarioTest;
    }

    public void testar(Funcionalidade funcionalidade) {
        switch (funcionalidade) {
            case INSERIR_FUNCIONARIO -> funcionarioTest.inserir();
            case IMPRIMIR_FUNCIONARIOS -> funcionarioTest.imprimir();
            case REMOVER_FUNCIONARIO -> funcionarioTest.excluir();
            case AGRUPAR_POR_FUNCAO -> funcionarioTest.agruparFuncao();
            case IMPRIMIR_ANIVERSARIANTES -> funcionarioTest.imprimirAniversariantes();
            case IMPRIMIR_FUNC_MAIS_VELHO -> funcionarioTest.imprimirMaisVelho();
            case APLICAR_AUMENTO -> funcionarioTest.aplicarAumento();
            case IMPRIMIR_ORDEM_ALFABETICA -> funcionarioTest.imprimirOrdemAlfabetica();
            case SOMAR_SALARIOS -> funcionarioTest.somarSalario();
            case IMPRIMIR_SALARIO_MINIMO -> funcionarioTest.calcularSalarioMinimo();
        }
    }
}

