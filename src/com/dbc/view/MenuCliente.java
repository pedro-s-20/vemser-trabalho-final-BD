package com.dbc.view;

import com.dbc.model.Usuario;
import com.dbc.service.AgendamentoService;
import com.dbc.service.ClienteService;

import java.util.Scanner;

public class MenuCliente {
    public static void exibirMenu(Usuario usuarioAtivo){
        AgendamentoService agendamentoService = new AgendamentoService();
        ClienteService clienteService = new ClienteService();
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
                    clienteService.mostrarInformacoesClienteUsuario(usuarioAtivo);
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
