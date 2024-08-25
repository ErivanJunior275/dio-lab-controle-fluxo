package br.com.dio.lab.controle.fluxo.exception;

public class InvalidParametersException extends Exception {

    public InvalidParametersException() {
        super("Ops, tivemos um problema. O segundo parâmetro deve ser maior que o primeiro!");
    }

}
