package com.dbc.view;

import com.dbc.model.Convenio;
import com.dbc.service.ConvenioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvenioView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        ConvenioService convenioService = new ConvenioService();

        int opcao = -1;

        try {
            while (opcao != 0) {
                System.out.println("Digite 1 para criar Convênio");
                System.out.println("Digite 2 para listar Convênio");
                System.out.println("Digite 3 para editar Convênio");
                System.out.println("Digite 4 para excluir Convênio");
                System.out.println("Digite 0 para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1: {
                        // adição Convenio
                        Convenio convenio = new Convenio();

                        System.out.println("Digite o cadastro no Orgão Regulaodr: ");
                        convenio.setCadastroOragaoRegulador(scanner.nextLine());
                        ValorEntrada.validarEntrada(convenio.getCadastroOragaoRegulador(), 1, 40);

                        System.out.println("Digite a Taxa de Abatimento: ");
                        convenio.setTaxaAbatimento(scanner.nextDouble());
                        ValorEntrada.validarEntrada(convenio.getTaxaAbatimento());

                        convenioService.adicionar(convenio);
                        break;
                    }
                    case 2: {
                        // listagem
                        convenioService.listar();
                        break;
                    }
                    case 3: {
                        // edição
                        System.out.println("Qual convênio você deseja editar?");
                        convenioService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Convenio convenio = new Convenio();

                        Integer contadorDeAlteracoes = 0;
                        System.out.println("Deseja editar o cadastro no orgão regulador? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o cadastro no orgão regulador: ");
                            convenio.setCadastroOragaoRegulador(scanner.nextLine());
                            ValorEntrada.validarEntrada(convenio.getCadastroOragaoRegulador(), 1, 40);
                        }

                        System.out.println("Deseja editar o taxa de abatimento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite a taxa: ");
                            convenio.setTaxaAbatimento(scanner.nextDouble());
                            ValorEntrada.validarEntrada(convenio.getTaxaAbatimento());

                        }

                        if (contadorDeAlteracoes == 0) {
                            System.err.println("Nenhuma alteração foi feita.");
                            break;
                        }

                        convenioService.editar(id, convenio);

                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual convênio você deseja excluir?");
                        convenioService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        convenioService.remover(id);

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
        }finally {
            scanner.close();
        }

    }
}
