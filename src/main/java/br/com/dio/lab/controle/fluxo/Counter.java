package br.com.dio.lab.controle.fluxo;

import br.com.dio.lab.controle.fluxo.exception.InvalidParametersException;
import br.com.dio.lab.controle.fluxo.model.CounterInputParameters;

import java.util.Locale;
import java.util.Scanner;

public class Counter {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.of("pt", "BR"))) {

            System.out.println("Bem vindo ao contador de diferença!");

            boolean repeat;

            do {
                CounterInputParameters counterInputParameters = getInputParameters(scanner);

                repeat = resolveCount(counterInputParameters, scanner);
            } while (repeat);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static CounterInputParameters getInputParameters(Scanner scanner) {

        System.out.println("Digite o primeiro parâmetro:");

        int firstParameter = scanner.nextInt();

        System.out.println("Digite o segundo parâmetro:");

        int secondParameter = scanner.nextInt();

        return new CounterInputParameters(firstParameter, secondParameter);
    }

    private static boolean resolveCount(CounterInputParameters counterInputParameters, Scanner scanner) {

        try {
            count(counterInputParameters.getFirstParameter(), counterInputParameters.getSecondParameter());

            System.out.println("A contagem terminou.");
        } catch (InvalidParametersException ipex) {
            System.out.println(ipex.getMessage());
        }

        return isReset(scanner);
    }

    private static void count(int firstParameter, int secondParameter) throws InvalidParametersException {

        if (firstParameter >= secondParameter) {
            throw new InvalidParametersException();
        }

        int count = secondParameter - firstParameter;

        for (int i = 1; i <= count; i++) {
            System.out.println("Imprimindo o número " + i);
        }

    }

    private static boolean isReset(Scanner scanner) {

        System.out.println("Deseja continuar? (S/N)");

        String reset = scanner.next();

        if ("S".equals(reset)) {
            return true;
        } else if ("N".equals(reset)) {
            return false;
        } else {
            System.out.println("Ops, resposta inválida ou vazia! Finalizando a aplicação...");

            return false;
        }

    }

}
