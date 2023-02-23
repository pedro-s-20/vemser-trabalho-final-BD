package com.dbc.view;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] - Cliente");
            System.out.println("[2] - Médico");
            System.out.println("[3] - Agendamento");
            System.out.println("[4] - Administrativo");
            System.out.println("[5] - Convênio");
            System.out.println("[6] - Especialidade");
            System.out.println("[7] - Contato");
            System.out.println("[8] - Endereço");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 7: {
                    ContatoView.menuContato();
                    break;
                }
                case 8: {
                    EnderecoView.menuContato();
                    break;
                }

                case 0:
                    System.out.println("Obrigado por usar o programa!\n\n");
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }


    }
}