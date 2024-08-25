package br.com.dio.lab.controle.fluxo.model;

public class CounterInputParameters {

    private final int firstParameter;

    private final int secondParameter;

    public CounterInputParameters(int firstParameter, int secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public int getFirstParameter() {
        return firstParameter;
    }

    public int getSecondParameter() {
        return secondParameter;
    }

}
