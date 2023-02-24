package com.dbc.view;

import com.dbc.model.Cliente;
import com.dbc.model.Endereco;
import com.dbc.service.ClienteService;
import com.dbc.service.ConvenioService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteView {
    public static void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        UsuarioService usuarioService = new UsuarioService();
        ConvenioService convenioService = new ConvenioService();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Digite 1 para criar Cliente");
            System.out.println("Digite 2 para listar Cliente");
            System.out.println("Digite 3 para editar Cliente");
            System.out.println("Digite 4 para excluir Cliente");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1: {
                    // adição Cliente
                    Cliente cliente = new Cliente();

                    usuarioService.listar();
                    System.out.println("Digite o código de Usuário:");
                    cliente.setIdUsuario(scanner.nextInt());

                    scanner = new Scanner(System.in);
                    System.out.println("Cliente possui convênio? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        convenioService.listar();
                        System.out.println("Escolha um convênio: ");
                        cliente.setIdConvenio(scanner.nextInt());
                    }

                    clienteService.adicionar(cliente);
                    break;
                }
                case 2: {
                    // listagem
                    clienteService.listar();
                    break;
                }
                case 3: {
                    // edição
                    System.out.println("Qual cliemte você deseja editar?");
                    clienteService.listar();
                    int id = scanner.nextInt();

                    Cliente cliente = new Cliente();

                    scanner = new Scanner(System.in);
                    System.out.println("Deseja trocar os dados para outro Usuário? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        usuarioService.listar();
                        System.out.println("Escolha o registtro de Usuário: ");
                        cliente.setIdUsuario(scanner.nextInt());
                    }

                    scanner = new Scanner(System.in);
                    System.out.println("Deseja trocar o Convênio? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        convenioService.listar();
                        System.out.println("Escolha o registro de convênio: ");
                        cliente.setIdConvenio(scanner.nextInt());
                    }

                    clienteService.editar(id, cliente);
                    break;
                }
                case 4: {
                    // exclusão
                    System.out.println("Qual cliente você deseja excluir?");
                    clienteService.listar();
                    boolean validouNumero = false;
                    while (!validouNumero) {
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            clienteService.remover(id);
                            if (id <= 0) {
                                throw new InputMismatchException("Código inválido!");
                            }
                            validouNumero = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("numero invalido");
                        }
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    System.err.println("opção inválida");
                    break;
            }
        }
    }
}
