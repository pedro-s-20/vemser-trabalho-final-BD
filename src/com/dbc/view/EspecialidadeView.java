package com.dbc.view;

import com.dbc.model.Especialidade;
import com.dbc.service.EspecialidadeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EspecialidadeView {
    public static void exibirMenu() {

        EspecialidadeService especialidadeService = new EspecialidadeService();

        int opcao = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            while (opcao != 0) {
                System.out.println("Digite 1 para criar especialidade");
                System.out.println("Digite 2 para listar especialidade");
                System.out.println("Digite 3 para editar especialidade");
                System.out.println("Digite 4 para excluir especialidade");
                System.out.println("Digite 0 para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1: {
                        // adição contato
                        Especialidade especialidade = new Especialidade();

                        System.out.println("Digite o nome da especialidade: ");
                        especialidade.setNome(scanner.nextLine());
                        ValorEntrada.validarEntrada(especialidade.getNome(), 1, 260);

                        System.out.println("Digite o valor da especialidade: ");
                        especialidade.setValor(scanner.nextDouble());
                        ValorEntrada.validarEntrada(especialidade.getValor());

                        especialidadeService.adicionar(especialidade);
                        break;
                    }
                    case 2: {
                        // listagem
                        especialidadeService.listar();
                        break;
                    }
                    case 3: {
                        // edição
                        System.out.println("Qual especialidade você deseja editar?");
                        especialidadeService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Especialidade especialidade = new Especialidade();

                        System.out.println("Digite o novo valor: ");
                        especialidade.setValor(scanner.nextDouble());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(especialidade.getValor());

                        System.out.println("Digite o novo nome: ");
                        especialidade.setNome(scanner.nextLine());
                        ValorEntrada.validarEntrada(especialidade.getNome(), 1, 9);

                        especialidadeService.editar(id, especialidade);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual especialidade você deseja excluir?");
                        especialidadeService.listar();

                        int id = scanner.nextInt();
                        especialidadeService.remover(id);
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        especialidadeService.remover(id);

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
