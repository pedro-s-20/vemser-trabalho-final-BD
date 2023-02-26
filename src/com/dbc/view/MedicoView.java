package com.dbc.view;

import com.dbc.model.Medico;
import com.dbc.service.EspecialidadeService;
import com.dbc.service.MedicoService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MedicoView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        MedicoService medicoService = new MedicoService();
        UsuarioService usuarioService = new UsuarioService();
        EspecialidadeService especialidadeService = new EspecialidadeService();
        int opcao = -1;

        try {
            while (opcao != 0) {
                System.out.println("Digite 1 para criar Medico");
                System.out.println("Digite 2 para listar Medicos");
                System.out.println("Digite 3 para editar Medico");
                System.out.println("Digite 4 para excluir Medico");
                System.out.println("Digite 0 para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1: {
                        // adição Cliente
                        Medico medico = new Medico();

                        usuarioService.listar();
                        System.out.println("Digite o código do Usuário:");
                        medico.setIdUsuario(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(medico.getIdMedico(), 1, 999999999);

                        System.out.println("Qual seu CRM: ");
                        medico.setCrm(scanner.nextLine());
                        ValorEntrada.validarEntrada(medico.getCrm(), 13);

                        especialidadeService.listar();
                        System.out.println("Escolha uma especialidade: ");
                        medico.setIdEspecialidade(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(medico.getIdEspecialidade(), 1, 9);

                        medicoService.adicionar(medico);
                        break;
                    }
                    case 2: {
                        // listagem
                        medicoService.listar();
                        break;
                    }
                    case 3: {
                        // edição
                        System.out.println("Qual médico você deseja editar?");
                        medicoService.listar();
                        int id = scanner.nextInt();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Medico medico = new Medico();
                        scanner.nextLine();
                        System.out.println("Deseja trocar os dados para outro Usuário? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            usuarioService.listar();
                            System.out.println("Escolha o registtro de Usuário: ");
                            medico.setIdUsuario(scanner.nextInt());
                            ValorEntrada.validarEntrada(medico.getIdUsuario(), 1, 999999999);

                        }

                        System.out.println("Deseja trocar a especialidade? ('s' para confirmar)");
                        scanner.nextLine();
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            especialidadeService.listar();
                            System.out.println("Escolha o registro de especialidade: ");
                            medico.setIdEspecialidade(scanner.nextInt());
                            ValorEntrada.validarEntrada(medico.getIdEspecialidade(), 1, 9);
                        }

                        medicoService.editar(id, medico);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual médico você deseja excluir?");
                        medicoService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        medicoService.remover(id);

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
