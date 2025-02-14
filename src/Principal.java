import controller.FuncionarioController;
import enumeration.Funcionalidade;
import model.Funcionario;
import model.Pessoa;
import service.FuncionarioService;
import test.FuncionarioTest;

import java.math.BigDecimal;
import java.sql.Array;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        FuncionarioService funcionarioService = new FuncionarioService();
        FuncionarioTest funcionarioTest = new FuncionarioTest(funcionarioService);
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioTest);

        Funcionalidade funcionalidade = Funcionalidade.AGRUPAR_POR_FUNCAO;
        funcionarioController.testar(funcionalidade);
    }
}
