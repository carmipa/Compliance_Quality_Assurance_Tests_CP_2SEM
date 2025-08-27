// Paulo André Carminati - RM: 557881 - Turma: 2TDSPZ
package br.com.fiap.teste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Cp4Test {

    private static final int RM_TOTAL_AMOSTRAS = 557881; // seu RM
    private static final double T = 1.0;

    private Cp4 cp4;

    @BeforeEach
    void setUp() {
        cp4 = new Cp4(T);
    }

    @Test
    void deveSerExcelente() {
        // alvo: ~0.97 (meio da faixa 0.94–1.00)
        int satisfeitos = (int) Math.ceil(RM_TOTAL_AMOSTRAS * 0.97);
        List<Double> tempos = Cp4.construirAmostras(RM_TOTAL_AMOSTRAS, satisfeitos, 0, T);
        assertEquals(Cp4.Classificacao.EXCELENTE, cp4.classificar(tempos));
    }

    @Test
    void deveSerBoa() {
        // alvo: ~0.90 (meio da faixa 0.85–0.93)
        int satisfeitos = (int) Math.ceil(RM_TOTAL_AMOSTRAS * 0.90);
        List<Double> tempos = Cp4.construirAmostras(RM_TOTAL_AMOSTRAS, satisfeitos, 0, T);
        assertEquals(Cp4.Classificacao.BOA, cp4.classificar(tempos));
    }

    @Test
    void deveSerRazoavel() {
        // alvo: ~0.78 (meio da faixa 0.70–0.84)
        int satisfeitos = (int) Math.ceil(RM_TOTAL_AMOSTRAS * 0.78);
        List<Double> tempos = Cp4.construirAmostras(RM_TOTAL_AMOSTRAS, satisfeitos, 0, T);
        assertEquals(Cp4.Classificacao.RAZOAVEL, cp4.classificar(tempos));
    }

    @Test
    void deveSerRuim() {
        // alvo: ~0.60 (meio da faixa 0.50–0.69)
        int satisfeitos = (int) Math.ceil(RM_TOTAL_AMOSTRAS * 0.60);
        List<Double> tempos = Cp4.construirAmostras(RM_TOTAL_AMOSTRAS, satisfeitos, 0, T);
        assertEquals(Cp4.Classificacao.RUIM, cp4.classificar(tempos));
    }

    @Test
    void deveSerInaceitavel() {
        // alvo: ~0.40 (< 0.50)
        int satisfeitos = (int) Math.ceil(RM_TOTAL_AMOSTRAS * 0.40);
        List<Double> tempos = Cp4.construirAmostras(RM_TOTAL_AMOSTRAS, satisfeitos, 0, T);
        assertEquals(Cp4.Classificacao.INACEITAVEL, cp4.classificar(tempos));
    }

    @Test
    void deveFalharComListaVaziaOuNula() {
        assertThrows(IllegalArgumentException.class, () -> cp4.calcularScore(List.of()));
        assertThrows(NullPointerException.class, () -> cp4.calcularScore(null));
    }
}
