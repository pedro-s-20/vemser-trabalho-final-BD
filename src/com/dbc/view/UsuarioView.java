package com.dbc.view;

import com.dbc.model.TipoUsuario;
import com.dbc.model.Usuario;
import com.dbc.service.ContatoService;
import com.dbc.service.EnderecoService;
import com.dbc.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsuarioView {
    public static void exibirMenu() {

        UsuarioService usuarioService = new UsuarioService();
        EnderecoService enderecoService = new EnderecoService();
        ContatoService contatoService = new ContatoService();

        int opcao = -1;
        try {
            Scanner scanner = new Scanner(System.in);
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
                        int tipo;

                        System.out.println("Digite a nome: ");
                        usuario.setNome(scanner.nextLine());
                        ValorEntrada.validarEntrada(usuario.getNome(), 1, 255);

                        System.out.println("Digite a CPF: ");
                        usuario.setCpf(scanner.nextLine());
                        ValorEntrada.validarEntrada(usuario.getCpf(), 11);

                        System.out.println("Digite a email: ");
                        usuario.setEmail(scanner.nextLine());
                        ValorEntrada.validarEntrada(usuario.getEmail(), 1, 300);

                        System.out.println("Digite o senha: ");
                        usuario.setSenha(scanner.nextLine());
                        ValorEntrada.validarEntrada(usuario.getSenha(), 1, 500);

                        System.out.println("Deseja inserir um endereço? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Escolha um endereço: ");
                            enderecoService.listar();
                            usuario.setIdEndereco(scanner.nextInt());
                            ValorEntrada.validarEntrada(usuario.getIdEndereco(), 1, 999999999);
                        }

                        System.out.println("Deseja inserir um contato? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            System.out.println("Escolha um contato: ");
                            contatoService.listar();
                            usuario.setIdContato(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(usuario.getIdContato(), 1, 999999999);
                        }

                        System.out.println("Qual o tipo do usuário?");

                        TipoUsuario[] tipos = TipoUsuario.values();

                        do {
                            int pos;
                            for (int i = 0; i < tipos.length; i++) {
                                pos = i + 1;
                                System.out.println("[" + pos + "] - " + tipos[i]);
                            }
                            tipo = scanner.nextInt();
                            scanner.nextLine();
                        } while (tipo < 1 || tipo > tipos.length);

                        switch (tipo) {
                            case 1 -> {
                                usuario.setTipoUsuario(TipoUsuario.ADMINISTRATIVO);
                            }
                            case 2 -> {
                                usuario.setTipoUsuario(TipoUsuario.MEDICO);
                            }
                            case 3 -> {
                                usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                            }
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
                        System.out.println("Qual usuário você deseja editar?");
                        usuarioService.listar();
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);

                        Usuario usuario = new Usuario();

                        Integer contadorDeAlteracoes = 0;
                        System.out.println("Deseja editar o nome? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o nome: ");
                            usuario.setNome(scanner.nextLine());
                            ValorEntrada.validarEntrada(usuario.getNome(), 1, 255);
                        }

                        System.out.println("Deseja editar o cpf? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o cpf: ");
                            usuario.setCpf(scanner.nextLine());
                            ValorEntrada.validarEntrada(usuario.getCpf(), 11);
                        }

                        System.out.println("Deseja editar o email? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite o email: ");
                            usuario.setEmail(scanner.nextLine());
                            ValorEntrada.validarEntrada(usuario.getEmail(), 1, 300);
                        }

                        System.out.println("Deseja ALTERAR a senha? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Digite a  nova senha: ");
                            usuario.setSenha(scanner.nextLine());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(usuario.getSenha(), 1, 500);
                        }

                        System.out.println("Deseja trocar o Endereço? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Escolha o registro de Endereços: ");
                            enderecoService.listar();
                            usuario.setIdEndereco(scanner.nextInt());
                            ValorEntrada.validarEntrada(usuario.getIdEndereco(), 1, 999999999);
                        }

                        System.out.println("Deseja trocar o Contato? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {
                            contadorDeAlteracoes++;
                            System.out.println("Escolha o registro de contatos: ");
                            contatoService.listar();
                            usuario.setIdContato(scanner.nextInt());
                            scanner.nextLine();
                            ValorEntrada.validarEntrada(usuario.getIdContato(), 1, 999999999);
                        }

                        System.out.println("Deseja alterar o tipo de usuário? ('s' para confirmar)");
                        if ("s".equalsIgnoreCase(scanner.nextLine())) {

                            int tipo;
                            System.out.println("Qual o tipo do usuário?");
                            TipoUsuario[] tipos = TipoUsuario.values();

                            do {
                                int pos;
                                for (int i = 0; i < tipos.length; i++) {
                                    pos = i + 1;
                                    System.out.println("[" + pos + "] - " + tipos[i]);
                                }
                                tipo = scanner.nextInt();
                                scanner.nextLine();
                            } while (tipo < 1 || tipo > tipos.length);

                            switch (tipo) {
                                case 1 -> {
                                    usuario.setTipoUsuario(TipoUsuario.ADMINISTRATIVO);
                                }
                                case 2 -> {
                                    usuario.setTipoUsuario(TipoUsuario.MEDICO);
                                }
                                case 3 -> {
                                    usuario.setTipoUsuario(TipoUsuario.CLIENTE);
                                }
                            }
                        }

                        if (contadorDeAlteracoes == 0) {
                            System.err.println("Nenhuma alteração foi feita.");
                            break;
                        }

                        usuarioService.editar(id, usuario);
                        break;
                    }
                    case 4: {
                        // exclusão
                        System.out.println("Qual usuário você deseja excluir?");
                        usuarioService.listar();

                        int id = scanner.nextInt();
                        scanner.nextLine();
                        ValorEntrada.validarEntrada(id, 1, 999999999);
                        usuarioService.remover(id);

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
