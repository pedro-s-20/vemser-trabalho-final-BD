package com.dbc.view;

import com.dbc.model.Contato;
import com.dbc.model.ConvenioManipulacao;
import com.dbc.model.EspecialidadesManipulacao;
import com.dbc.model.Medico;
import com.dbc.repository.ConexaoBancoDeDados;
import com.dbc.service.ContatoService;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020

        ContatoService contatoService = new ContatoService();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Digite 5 para criar contato");
            System.out.println("Digite 6 para listar contatos");
            System.out.println("Digite 7 para editar contatos");
            System.out.println("Digite 8 para excluir contatos");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 5: {
                    // adição contato
                    Contato contato = new Contato();

                    System.out.println("Digite o Telefone 1: ");
                    contato.setTelefone1(scanner.nextLine());

                    System.out.println("Deseja inserir o Telefone 2? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o Telefone 2: ");
                        contato.setTelefone1(scanner.nextLine());

                        System.out.println("Deseja inserir o Telefone 3? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o Telefone 3: ");
                            contato.setTelefone1(scanner.nextLine());
                        }
                    }

                    contatoService.adicionarContato(contato);
                    break;
                }
                case 6: {
                    // listagem
                    contatoService.listar();
                    break;
                }
                case 7: {
                    // edição
                    System.out.println("Qual contato você deseja editar?");
                    contatoService.listar();
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Contato contato = new Contato();

                    System.out.println("Digite o Telefone 1: ");
                    contato.setTelefone1(scanner.nextLine());

                    System.out.println("Deseja inserir o Telefone 2? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o Telefone 2: ");
                        contato.setTelefone2(scanner.nextLine());

                        System.out.println("Deseja inserir o Telefone 3? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Digite o Telefone 3: ");
                            contato.setTelefone3(scanner.nextLine());
                        }
                    }

                    contatoService.editar(id, contato);
                    break;
                }
                case 8: {
                    // exclusão
                    System.out.println("Qual contato você deseja excluir?");
                    contatoService.listar();
                    boolean validouNumero = false;
                    while (!validouNumero){
                        try{
                            int id = scanner.nextInt();
                            contatoService.remover(id);
                            if (id <= 0){
                                throw new InputMismatchException("Código inválido!");
                            }
                            validouNumero = true;
                        } catch (InputMismatchException ex){
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