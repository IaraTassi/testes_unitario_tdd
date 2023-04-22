package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static br.com.alura.tdd.modelo.Desempenho.OTIMO;
import static org.testng.Assert.assertEquals;

//Trecho do código omitido

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }
    // precisar ser static o beforall e afterall
    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("Antes de todos");
    }
    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("Depois de todos");
    }


    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
       service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}