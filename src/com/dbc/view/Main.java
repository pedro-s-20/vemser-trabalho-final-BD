package com.dbc.view;

import com.dbc.model.Usuario;
import com.dbc.service.UsuarioService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario usuarioAtivo = login();
        usuarioAtivo.getTipoUsuario().exibirMenu(usuarioAtivo);
    }

    public static Usuario login() {
        UsuarioService usuarioService = new UsuarioService();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String credenciais[] = new String[2];
            System.out.println("Email: ");
            credenciais[0] = scanner.nextLine();
            System.out.println("Senha: ");
            credenciais[1] = scanner.nextLine();
            Usuario usuario = usuarioService.findUser(credenciais[0], credenciais[1]);

            if (usuario != null) {
                System.out.println("################################");
                System.out.println("#### Bem-Vindo ao SofetySoft ###");
                System.out.println("################################");
                return usuario;
            }
            System.out.println("Não foi encontrado usuário com essas credenciais!");
        }
    }


}