package com.dbc.view;

import com.dbc.model.Endereco;
import com.dbc.service.EnderecoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnderecoView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        EnderecoService enderecoService = new EnderecoService();

        int opcao = -1;
        try {
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
                        ValorEntrada.validarEntrada(endereco.getCidade(), 1, 40);

                        System.out.println("Digite a estado: ");
                        endereco.setEstado(scanner.nextLine());
                        ValorEntrada.validarEntrada(endereco.getEstado(), 1, 100);

                        System.out.println("Digite a rua: ");
                        endereco.setLogradouro(scanner.nextLine());
                        ValorEntrada.validarEntrada(endereco.getLogradouro(), 1, 255);

                        System.out.println("Digite o número: ");
                        endereco.setNumero(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(endereco.getNumero(), 1, 99999999);

                        System.out.println("Digite o bairro: ");
                        endereco.setBairro(scanner.nextLine());
                        ValorEntrada.validarEntrada(endereco.getLogradouro(), 1, 50);

                        System.out.println("Digite a CEP: ");
                        endereco.setCep(scanner.nextLine());
                        ValorEntrada.validarEntrada(endereco.getCep(), 9);

                        System.out.println("Deseja inserir um complemento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o complemento: ");
                            endereco.setComplemento(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getComplemento(), 1, 1000);

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
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Endereco endereco = new Endereco();

                        System.out.println("Deseja editar um cidade? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite a cidade: ");
                            endereco.setCidade(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getCidade(), 1, 40);
                        }

                        System.out.println("Deseja editar um estado? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite a estado: ");
                            endereco.setEstado(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getEstado(), 1, 100);
                        }

                        System.out.println("Deseja editar um rua? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite a rua: ");
                            endereco.setLogradouro(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getLogradouro(), 1, 255);
                        }

                        System.out.println("Deseja editar um número? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o número: ");
                            endereco.setNumero(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(endereco.getNumero(), 1, 99999999);
                        }

                        System.out.println("Deseja editar um bairro? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o bairro: ");
                            endereco.setBairro(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getLogradouro(), 1, 50);
                        }

                        System.out.println("Deseja editar um CEP? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite a CEP: ");
                            endereco.setCep(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getCep(), 9);
                        }
                        System.out.println("Deseja editar um complemento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o complemento: ");
                            endereco.setComplemento(scanner.nextLine());
                            ValorEntrada.validarEntrada(endereco.getComplemento(), 1, 1000);
                        }

                        enderecoService.editar(id, endereco);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual endereço você deseja excluir?");
                        enderecoService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        enderecoService.remover(id);

                        break;
                    }
                    case 0:
                        break;
                    default:
                        System.err.println("opção inválida");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } finally {
            exibirMenu();
        }

    }
}
