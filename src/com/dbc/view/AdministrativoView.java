package com.dbc.view;

import com.dbc.exceptions.ValorDeEntradaException;
import com.dbc.model.Administrativo;
import com.dbc.service.AdministrativoService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdministrativoView {

    public static void exibirMenu() {

        AdministrativoService administrativoService = new AdministrativoService();
        UsuarioService usuarioService = new UsuarioService();

        int opcao = -1;

        try {
            Scanner scanner = new Scanner(System.in);
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

                        usuarioService.listar();
                        System.out.println("Digite o id do usuário que deseja vincular ao novo administrador: ");
                        administrativo.setIdUsuario(scanner.nextInt());
                        scanner.nextLine();

                        ValorEntrada.validarEntrada(administrativo.getIdUsuario(), 1, 999999999);

                        if(usuarioService.verificarIdUsuario(administrativo.getIdUsuario())){
                            throw new ValorDeEntradaException("Usuário já registrado para outro login.");
                        }

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
                        Administrativo administrativo = new Administrativo();

                        System.out.println("Digite o id do administrador você deseja editar: ");
                        administrativoService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        System.out.println("Escolha um usuário: ");
                        usuarioService.listar();
                        System.out.println("Digite o id do usuário que deseja vincular ao novo administrador: ");
                        administrativo.setIdUsuario(scanner.nextInt());
                        scanner.nextLine();

                        ValorEntrada.validarEntrada(administrativo.getIdUsuario(), 1, 999999999);

                        if(usuarioService.verificarIdUsuario(administrativo.getIdUsuario())){
                            throw new ValorDeEntradaException("Usuário já registrado para outro login.");
                        }

                        administrativoService.editar(id, administrativo);

                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual administrador você deseja excluir?");
                        administrativoService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        administrativoService.remover(id);

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
