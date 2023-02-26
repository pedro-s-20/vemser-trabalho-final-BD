package com.dbc.view;

import com.dbc.exceptions.ValorDeEntradaException;
import com.dbc.model.Agendamento;
import com.dbc.service.AgendamentoService;
import com.dbc.service.ClienteService;
import com.dbc.service.MedicoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendamentoView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        AgendamentoService agendamentoService = new AgendamentoService();
        MedicoService medicoService = new MedicoService();
        ClienteService clienteService = new ClienteService();
        int opcao = -1;

        try {
            while (opcao != 0) {
                System.out.println("Digite 1 para criar um agendamento");
                System.out.println("Digite 2 para listar os agendamentos");
                System.out.println("Digite 3 para editar um agendamento");
                System.out.println("Digite 4 para excluir um agendamento");
                System.out.println("Digite 0 para sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {

                    case 1: {
                        // adição Agendamento
                        Agendamento agendamento = new Agendamento();

                        clienteService.listar();
                        System.out.println("Digite o código do cliente:");
                        agendamento.setIdCliente(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(agendamento.getIdCliente(), 1, 999999999);

                        medicoService.listar();
                        System.out.println("Digite o código do médico:");
                        agendamento.setIdMedico(scanner.nextInt());
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(agendamento.getIdMedico(), 1, 999999999);

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            System.out.println("Digite a data e horário do agendamento (dd/MM/yyyy HH:mm):");
                            agendamento.setDataHorario(LocalDateTime.parse(scanner.nextLine(), formatter));
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new ValorDeEntradaException("Valor de data inserido fora do padrão (dd/MM/yyyy)");
                        }

                        System.out.println("Este agendamento possui um tratamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o tratamento: ");
                            agendamento.setTratamento(scanner.nextLine());
                            ValorEntrada.validarEntrada(agendamento.getTratamento(), 1, 40);

                        }

                        System.out.println("Este agendamento possui um exame? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o exame: ");
                            agendamento.setExame(scanner.nextLine());
                            ValorEntrada.validarEntrada(agendamento.getExame(), 1, 40);
                        }

                        agendamentoService.adicionar(agendamento);
                        break;
                    }
                    case 2: {
                        // listagem
                        agendamentoService.listar();
                        break;
                    }
                    case 3: {
                        // edição
                        System.out.println("Qual agendamento você deseja editar?");
                        agendamentoService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Agendamento agendamento = new Agendamento();

                        Integer contadorDeAlteracoes = 0;
                        System.out.println("Deseja trocar o cliente deste agendamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            clienteService.listar();
                            System.out.println("Escolha o cliente: ");
                            agendamento.setIdCliente(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(agendamento.getIdCliente(), 1, 999999999);
                        }

                        System.out.println("Deseja trocar o médico deste agendamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            medicoService.listar();
                            System.out.println("Escolha o médico: ");
                            agendamento.setIdMedico(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(agendamento.getIdMedico(), 1, 999999999);
                        }

                        System.out.println("Deseja trocar o tratamento deste agendamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o tratamento: ");
                            agendamento.setTratamento(scanner.nextLine());
                            ValorEntrada.validarEntrada(agendamento.getTratamento(), 1, 40);
                        }

                        System.out.println("Deseja trocar o exame deste agendamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o exame: ");
                            agendamento.setExame(scanner.nextLine());
                            ValorEntrada.validarEntrada(agendamento.getExame(), 1, 40);
                        }

                        System.out.println("Deseja trocar a data e hora deste agendamento? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                System.out.println("Digite a data e horário do agendamento (dd/MM/yyyy HH:mm):");
                                agendamento.setDataHorario(LocalDateTime.parse(scanner.nextLine(), formatter));
                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new ValorDeEntradaException("Valor de data inserido fora do padrão (dd/MM/yyyy)");
                            }
                        }

                        if (contadorDeAlteracoes == 0) {
                            System.err.println("Nenhuma alteração foi feita.");
                            break;
                        }

                        agendamentoService.editar(id, agendamento);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual agendamento você deseja excluir?");
                        agendamentoService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        agendamentoService.remover(id);
                        ValorEntrada.validarEntrada(id, 1, 999999999);

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
