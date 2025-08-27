// Paulo André Carminati - RM: 557881 - Turma: 2TDSPZ
package br.com.fiap.teste;

import java.util.*;

public class Cp4 {

    public enum Classificacao {
        EXCELENTE, BOA, RAZOAVEL, RUIM, INACEITAVEL
    }

    private final double thresholdT;

    public Cp4(double thresholdT) {
        if (thresholdT <= 0) throw new IllegalArgumentException("O threshold T deve ser > 0");
        this.thresholdT = thresholdT;
    }

    public double calcularScore(List<Double> tempos) {
        Objects.requireNonNull(tempos, "Lista de tempos não pode ser nula");
        if (tempos.isEmpty()) throw new IllegalArgumentException("Lista não pode ser vazia");

        int total = tempos.size(), satisfeitos = 0, toleraveis = 0;

        for (Double t : tempos) {
            if (t == null || t < 0) throw new IllegalArgumentException("Tempo inválido: " + t);
            if (t <= thresholdT) satisfeitos++;
            else if (t <= 4 * thresholdT) toleraveis++;
        }

        return (satisfeitos + 0.5 * toleraveis) / total;
    }

    public Classificacao classificar(double score) {
        if (score >= 0.94) return Classificacao.EXCELENTE;
        if (score >= 0.85) return Classificacao.BOA;
        if (score >= 0.70) return Classificacao.RAZOAVEL;
        if (score >= 0.50) return Classificacao.RUIM;
        return Classificacao.INACEITAVEL;
    }

    public Classificacao classificar(List<Double> tempos) {
        return classificar(calcularScore(tempos));
    }

    public static List<Double> construirAmostras(int total, int satisfeitos, int toleraveis, double T) {
        if (total <= 0) throw new IllegalArgumentException("Total deve ser > 0");
        int frustrados = total - satisfeitos - toleraveis;
        if (frustrados < 0) throw new IllegalArgumentException("Soma inválida");

        List<Double> tempos = new ArrayList<>(total);
        tempos.addAll(Collections.nCopies(satisfeitos, T));
        tempos.addAll(Collections.nCopies(toleraveis, 2 * T));
        tempos.addAll(Collections.nCopies(frustrados, 5 * T));
        return tempos;
    }
}
