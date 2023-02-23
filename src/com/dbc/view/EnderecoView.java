package com.dbc.view;

import com.dbc.model.Contato;
import com.dbc.model.Endereco;
import com.dbc.service.EnderecoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnderecoView {
    public static void menuContato(){
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Digite 1 para criar Endereço");
            System.out.println("Digite 2 para listar Endereço");
            System.out.println("Digite 3 para editar Endereço");
            System.out.println("Digite 4 para excluir Endereço");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1: {
                    // adição contato
                    Endereco endereco = new Endereco();

                    System.out.println("Digite a cidade: ");
                    endereco.setCidade(scanner.nextLine());

                    System.out.println("Digite a estado: ");
                    endereco.setEstado(scanner.nextLine());

                    System.out.println("Digite a rua: ");
                    endereco.setLogradouro(scanner.nextLine());

                    System.out.println("Digite o número: ");
                    endereco.setNumero(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Digite o bairro: ");
                    endereco.setBairro(scanner.nextLine());

                    System.out.println("Digite a CEP: ");
                    endereco.setCep(scanner.nextLine());

                    System.out.println("Deseja inserir um complemento? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o complemento: ");
                        endereco.setComplemento(scanner.nextLine());
                    }

                    enderecoService.adicionar(endereco);
                    break;
                }
                case 2: {
                    // listagem
                    enderecoService.listar();
                    break;
                }
                case 3: {
                    // edição
                    System.out.println("Qual endereço você deseja editar?");
                    enderecoService.listar();
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

                    enderecoService.editar(id, endereco);
                    break;
                }
                case 4: {
                    // exclusão
                    System.out.println("Qual endereço você deseja excluir?");
                    enderecoService.listar();
                    boolean validouNumero = false;
                    while (!validouNumero) {
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            enderecoService.remover(id);
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
