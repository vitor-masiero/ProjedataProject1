package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class FuncionarioService {
    public  List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public FuncionarioService() {
        //Inicializa automaticamente ao instanciar um FuncionárioService
        inserirFuncionario();
    }

    public void inserirFuncionario(){
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }
    public void imprimirFuncionario() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários, insira primeiro.");
        } else {
            funcionarios.forEach(System.out::println);
        }


    }

    public void removerFuncionario(){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase("João"));
    }

    public void aplicarAumento(){
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("1.1"));
            funcionario.setSalario(aumento);
        }

        funcionarios.forEach(System.out::println);
    }

    public void somarSalarios() {
        BigDecimal soma = new BigDecimal(0);
        for(Funcionario funcionario : funcionarios) {
            soma = soma.add(funcionario.getSalario());
        }
        NumberFormat formatoBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("Total de salários: " + formatoBR.format(soma));
    }

    public void calcularSalarioMinimo() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salario = funcionario.getSalario();
            BigDecimal minimo = new BigDecimal("1212.00");
            BigDecimal quantidadeSalariosMinimos;
            quantidadeSalariosMinimos = salario.divide(minimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.format("\nO funcionário %s ganha %.2f salários mínimos.", funcionario.getNome(), quantidadeSalariosMinimos);
        }
    }

    public void agruparPorFuncao() {
        Map<String, List<Funcionario>> grupoFuncao = new HashMap<>();
        funcionarios.forEach(funcionario ->
                grupoFuncao.computeIfAbsent(funcionario.getFuncao(), k -> new ArrayList<>()).add(funcionario));

        grupoFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
        });
    }

    public void imprimirAniversariantes(int... meses) {
        System.out.println("\nAniversariantes dos meses informados: ");

        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getDataNascimento().getMonthValue();

            for (int mes : meses) {
                if (mes == mesNascimento) {
                    System.out.println(funcionario);
                }
            }
        }
    }

    public void imprimirFuncionarioMaisVelho() {
        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionario;
            }
        }

        System.out.println("\nFuncionário mais velho: " + maisVelho);
    }

    public void imprimirPorOrdemAlfabetica() {
        System.out.println("Funcionários em ordem alfabética:");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);
    }
}
