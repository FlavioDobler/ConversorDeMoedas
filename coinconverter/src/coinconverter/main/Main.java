package coinconverter.main;

import coinconverter.request.Request;
import coinconverter.view.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Request request = new Request();
        View ui = new View();
        String from = null;
        String to = null;

        int input;
        do {

            ui.showInterface();
            input = leitura.nextInt();

            switch (input){
                case 1 :
                     from = "USD";
                     to = "ARS";
                    break;
                case 2 :
                     from = "ARS";
                     to = "USD";
                    break;
                case 3 :
                     from = "USD";
                     to = "BRL";
                    break;
                case 4 :
                     from = "BRL";
                     to = "USD";
                    break;
                case 5 :
                     from = "USD";
                     to = "COP";
                    break;
                case 6 :
                     from = "COP";
                     to = "USD";
                    break;
                case 7 :
                    from = "CLP";
                    to = "USD";
                    break;
                case 8 :
                    from = "BOB";
                    to = "USD";
                    break;
                default:
                    System.out.println("Digite uma opção válida");
            }

            if(input <= 6 && input >= 1){
                System.out.println("Digite a quantidade de " + from + " a ser convertida para " + to);
                double amount = leitura.nextDouble();
                request.fazerRequisicao(from,to,amount);
           }
        } while (input != 9);
    }
}




