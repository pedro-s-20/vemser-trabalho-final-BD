package com.dbc.view;

import com.dbc.model.Contato;
import com.dbc.service.ContatoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContatoView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        ContatoService contatoService = new ContatoService();

        int opcao = -1;

        try {
            while (opcao != 0) {
                System.out.println("Digite 1 para criar contato");
                System.out.println("Digite 2 para listar contatos");
                System.out.println("Digite 3 para editar contatos");
                System.out.println("Digite 4 para excluir contatos");
                System.out.println("Digite 0 para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1: {
                        // adição contato
                        Contato contato = new Contato();

                        System.out.println("Digite o Telefone 1: ");
                        contato.setTelefone1(scanner.nextLine());
                        ValorEntrada.validarEntrada(contato.getTelefone1(), 10, 11);


                        System.out.println("Deseja inserir o Telefone 2? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o Telefone 2: ");
                            contato.setTelefone1(scanner.nextLine());
                            ValorEntrada.validarEntrada(contato.getTelefone2(), 10, 11);

                            System.out.println("Deseja inserir o Telefone 3? ('s' para confirmar)");
                            if ("s".equalsIgnoreCase(scanner.nextLine())) {
                                System.out.println("Digite o Telefone 3: ");
                                contato.setTelefone1(scanner.nextLine());
                                ValorEntrada.validarEntrada(contato.getTelefone3(), 10, 11);

                            }
                        }

                        contatoService.adicionar(contato);
                        break;
                    }
                    case 2: {
                        // listagem
                        contatoService.listar();
                        break;
                    }
                    case 3: {
                        // edição
                        System.out.println("Qual contato você deseja editar?");
                        contatoService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Contato contato = new Contato();
                        Integer contadorDeAlteracoes = 0;
                        System.out.println("Deseja alterar o telefone1? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o novo número de telefone: ");
                            contato.setTelefone1(scanner.nextLine());
                            ValorEntrada.validarEntrada(contato.getTelefone1(), 10, 11);
                        }

                        System.out.println("Deseja alterar o telefone2? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o novo número de telefone: ");
                            contato.setTelefone2(scanner.nextLine());
                            ValorEntrada.validarEntrada(contato.getTelefone2(), 10, 11);

                            System.out.println("Deseja alterar o telefone3? ('s' para confirmar)");
                            if ("s".equalsIgnoreCase(scanner.nextLine())) {
                                contadorDeAlteracoes++;
                                System.out.println("Digite o novo número de telefone: ");
                                contato.setTelefone3(scanner.nextLine());
                                ValorEntrada.validarEntrada(contato.getTelefone3(), 10, 11);

                            }
                        }

                        if (contadorDeAlteracoes == 0) {
                            System.err.println("Nenhuma alteração foi feita.");
                            break;
                        }

                        contatoService.editar(id, contato);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual contato você deseja excluir?");
                        contatoService.listar();
                        boolean validouNumero = false;
                        while (!validouNumero) {
                            try {
                                int id = scanner.nextInt();
                                contatoService.remover(id);
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
        } catch (InputMismatchException e) {
            e.printStackTrace();
            exibirMenu();
        }
    }


}
