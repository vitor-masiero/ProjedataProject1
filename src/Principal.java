import model.Funcionario;
import model.Pessoa;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Principal {
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void inicializarFuncionarios(){
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
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
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
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inicializarFuncionarios();
        principal.removerFuncionario();
        System.out.println("-----------Imprimindo Funcionários------------");
        principal.imprimirFuncionario();
        principal.aplicarAumento();
        System.out.println("-----------Imprimindo Funcionários Após Aumento------------");
        principal.imprimirFuncionario();


    }
}
