package com.dbc.view;

import com.dbc.model.Administrativo;
import com.dbc.service.AdministrativoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministrativoView {

    public static void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        AdministrativoService administrativoService = new AdministrativoService();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Digite 1 para criar um administrador");
            System.out.println("Digite 2 para listar um administrador");
            System.out.println("Digite 3 para editar um administrador");
            System.out.println("Digite 4 para excluir um administrador");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1: {
                    // adição contato
                    Administrativo administrativo = new Administrativo();

                    System.out.println("Escolha um usuário: ");
                    administrativoService.listar();
                    System.out.println("Digite o id do usuário que deseja vincular ao novo administrador: ");
                    administrativo.setIdUsuario(scanner.nextInt());
                    scanner.nextLine();

                    administrativoService.adicionar(administrativo);
                    break;
                }
                case 2: {
                    // listagem
                    administrativoService.listar();
                    break;
                }
                case 3: {
                    // edição
                    System.out.println("Qual administrador você deseja editar?");
                    administrativoService.listar();
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Administrativo administrativo = new Administrativo();
                    System.out.println("Escolha um usuário: ");
                    administrativoService.listar();
                    System.out.println("Digite o id do usuário que deseja vincular ao novo administrador: ");
                    administrativo.setIdUsuario(scanner.nextInt());
                    scanner.nextLine();

                    administrativoService.editar(id, administrativo);
                    break;
                }
                case 4: {
                    // exclusão
                    System.out.println("Qual administrador você deseja excluir?");
                    administrativoService.listar();
                    boolean validouNumero = false;
                    while (!validouNumero) {
                        try {
                            int id = scanner.nextInt();
                            administrativoService.remover(id);
                            if (id <= 0) {
                                throw new InputMismatchException("Código inválido!");
                            }
                            validouNumero = true;
                        } catch (InputMismatchException ex) {
                            System.err.println("número invalido");
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
