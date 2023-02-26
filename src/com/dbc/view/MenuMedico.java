package com.dbc.view;

import com.dbc.model.Usuario;
import com.dbc.service.AgendamentoService;
import com.dbc.service.MedicoService;

import java.util.Scanner;

public class MenuMedico {
    public static void exibirMenu(Usuario usuarioAtivo){
        MedicoService medicoService = new MedicoService();
        AgendamentoService agendamentoService = new AgendamentoService();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] - Meu perfil");
            System.out.println("[2] - Agendamentos");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    System.out.println("------------SUAS INFORMAÇÕES------------");
                    medicoService.mostrarInformacoesMedicoUsuario(usuarioAtivo);
                    System.out.println("----------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("------------SEUS AGENDAMENTOS------------");
                    agendamentoService.mostrarAgendamentosUsuario(usuarioAtivo);
                    System.out.println("-----------------------------------------");
                    break;
                }
                case 0:
                    System.out.println("Obrigado por usar o programa!\n\n");
                    scanner.close();
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }
    }
}
