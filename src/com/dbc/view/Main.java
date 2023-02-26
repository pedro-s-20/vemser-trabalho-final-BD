package com.dbc.view;

import com.dbc.model.Usuario;
import com.dbc.service.UsuarioService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario usuarioAtivo = login();
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("[9] - Usuario");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    ClienteView.exibirMenu();
                    break;
                }
                case 2: {
                    MedicoView.exibirMenu();
                    break;
                }
                case 3: {
                    AgendamentoView.exibirMenu();
                    break;
                }
                case 4: {
                    AdministrativoView.exibirMenu();
                    break;
                }
                case 5: {
                    ConvenioView.exibirMenu();
                    break;
                }
                case 6: {
                    EspecialidadeView.exibirMenu();
                    break;
                }
                case 7: {
                    ContatoView.exibirMenu();
                    break;
                }
                case 8: {
                    EnderecoView.exibirMenu();
                    break;
                }
                case 9: {
                    UsuarioView.exibirMenu();
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

    public static Usuario login() {
        UsuarioService usuarioService = new UsuarioService();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String credenciais[] = new String[2];
            System.out.println("Email: ");
            credenciais[0] = scanner.nextLine();
            System.out.println("Senha: ");
            credenciais[0] = scanner.nextLine();
            Usuario usuario = usuarioService.findUser(credenciais[0], credenciais[1]);

            if (usuario != null) {
                System.out.println("################################");
                System.out.println("#### Bem-Vindo ao SofetySoft ###");
                System.out.println("################################");
                return usuario;
            }
            System.out.println("Não foi encontrado usuário com essas credenciais!");
        }
    }


}