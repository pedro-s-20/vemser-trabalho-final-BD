package com.dbc.view;

import com.dbc.exceptions.ValorDeEntradaException;
import com.dbc.model.Medico;
import com.dbc.service.EspecialidadeService;
import com.dbc.service.MedicoService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MedicoView {
    public static void exibirMenu() {

        MedicoService medicoService = new MedicoService();
        UsuarioService usuarioService = new UsuarioService();
        EspecialidadeService especialidadeService = new EspecialidadeService();
        int opcao = -1;

        try {
            Scanner scanner = new Scanner(System.in);
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
                        // adição médico
                        Medico medico = new Medico();

                        usuarioService.listar();
                        System.out.println("Digite o código do Usuário:");
                        medico.setIdUsuario(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(medico.getIdUsuario(), 1, 999999999);
                        if(usuarioService.verificarIdUsuario(medico.getIdUsuario())){
                            throw new ValorDeEntradaException("Usuário já registrado para outro login.");
                        }

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
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Medico medico = new Medico();

                        Integer contadorDeAlteracoes = 0;
                        System.out.println("Deseja trocar os dados para outro Usuário? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            usuarioService.listar();
                            System.out.println("Escolha o registro de Usuário: ");
                            medico.setIdUsuario(scanner.nextInt());
                            ValorEntrada.validarEntrada(medico.getIdUsuario(), 1, 999999999);
                            if(usuarioService.verificarIdUsuario(medico.getIdUsuario())){
                                throw new ValorDeEntradaException("Usuário já registrado para outro login.");
                            }
                        }

                        System.out.println("Deseja trocar a especialidade? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            especialidadeService.listar();
                            System.out.println("Escolha o registro de especialidade: ");
                            medico.setIdEspecialidade(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(medico.getIdEspecialidade(), 1, 9);
                        }

                        if (contadorDeAlteracoes == 0) {
                            System.err.println("Nenhuma alteração foi feita.");
                            break;
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
            exibirMenu();
        }
    }
}
