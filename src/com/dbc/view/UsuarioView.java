package com.dbc.view;

import com.dbc.model.Endereco;
import com.dbc.model.Usuario;
import com.dbc.service.ContatoService;
import com.dbc.service.EnderecoService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioView {
    public static void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        EnderecoService enderecoService = new EnderecoService();
        ContatoService contatoService = new ContatoService();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Digite 1 para criar Usuário");
            System.out.println("Digite 2 para listar Usuário");
            System.out.println("Digite 3 para editar Usuário");
            System.out.println("Digite 4 para excluir Usuário");
            System.out.println("Digite 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1: {
                    // adição Cliente
                    Usuario usuario = new Usuario();

                    System.out.println("Digite a nome: ");
                    usuario.setNome(scanner.nextLine());

                    System.out.println("Digite a CPF: ");
                    usuario.setCpf(scanner.nextLine());

                    System.out.println("Digite a email: ");
                    usuario.setEmail(scanner.nextLine());

                    System.out.println("Digite o senha: ");
                    usuario.setSenha(scanner.nextLine());

                    System.out.println("Deseja inserir um endereço? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Escolha um endereço: ");
                        enderecoService.listar();
                        usuario.setIdEndereco(scanner.nextInt());
                    }

                    System.out.println("Deseja inserir um contato? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Escolha um contato: ");
                        contatoService.listar();
                        usuario.setIdUsuario(scanner.nextInt());
                    }

                    usuarioService.adicionar(usuario);
                    break;
                }
                case 2: {
                    // listagem
                    usuarioService.listar();
                    break;
                }
                case 3: {
                    // edição
                    System.out.println("Qual endereço você deseja editar?");
                    usuarioService.listar();
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Usuario usuario = new Usuario();

                    System.out.println("Deseja editar o nome? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o nome: ");
                        usuario.setNome(scanner.nextLine());
                    }

                    System.out.println("Deseja editar o cpf? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o cpf: ");
                        usuario.setCpf(scanner.nextLine());
                    }

                    System.out.println("Deseja editar o email? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite o email: ");
                        usuario.setEmail(scanner.nextLine());
                    }

                    System.out.println("Deseja ALTERAR a senha? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Digite a  nova senha: ");
                        usuario.setSenha(scanner.nextLine());
                        scanner.nextLine();
                    }

                    System.out.println("Deseja trocar o Endereço? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Escolha o registtro de Endereços: ");
                        enderecoService.listar();
                        usuario.setIdEndereco(scanner.nextInt());
                    }
                    scanner = new Scanner(System.in);

                    System.out.println("Deseja trocar o Contato? ('s' para confirmar)");
                    if ("s".equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println("Escolha o registro de contatos: ");
                        contatoService.listar();
                        scanner = new Scanner(System.in);
                        usuario.setIdContato(scanner.nextInt());
                    }

                    usuarioService.editar(id, usuario);
                    break;
                }
                case 4: {
                    // exclusão
                    System.out.println("Qual endereço você deseja excluir?");
                    usuarioService.listar();
                    boolean validouNumero = false;
                    while (!validouNumero) {
                        try {
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            usuarioService.remover(id);
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
    }
}
