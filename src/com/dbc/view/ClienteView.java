package com.dbc.view;

import com.dbc.model.Endereco;
import com.dbc.service.ClienteService;
import com.dbc.service.EnderecoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteView {
    public static void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();

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
                    break;
                }
                case 2: {
                    // listagem
                    clienteService.listar();
                    break;
                }
                case 3: {
                    // edição
                    System.out.println("Qual endereço você deseja editar?");
                    clienteService.listar();
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Endereco endereco = new Endereco();

                    System.out.println("Deseja editar um cidade? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite a cidade: ");
                        endereco.setCidade(scanner.nextLine());
                    }

                    System.out.println("Deseja editar um estado? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite a estado: ");
                        endereco.setEstado(scanner.nextLine());
                    }

                    System.out.println("Deseja editar um rua? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite a rua: ");
                        endereco.setLogradouro(scanner.nextLine());
                    }

                    System.out.println("Deseja editar um número? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o número: ");
                        endereco.setNumero(scanner.nextInt());
                        scanner.nextLine();
                    }

                    System.out.println("Deseja editar um bairro? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o bairro: ");
                        endereco.setBairro(scanner.nextLine());
                    }

                    System.out.println("Deseja editar um CEP? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite a CEP: ");
                        endereco.setCep(scanner.nextLine());
                    }
                    System.out.println("Deseja editar um complemento? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o complemento: ");
                        endereco.setComplemento(scanner.nextLine());
                    }

                    clienteService.editar(id, endereco);
                    break;
                }
                case 4: {
                    // exclusão
                    System.out.println("Qual endereço você deseja excluir?");
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
