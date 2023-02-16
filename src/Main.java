import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConvenioManipulacao convenioManipulacao = new ConvenioManipulacao();
        EspecialidadesManipulacao especialidadesManipulacao = new EspecialidadesManipulacao();
        Medico pessoaMedico = new Medico();
        Especialidades especialidade = new Especialidades();
        Administrativo pessoaAdministrativo = new Administrativo();
        Cliente agendamento = new Cliente();
        Scanner scanner = new Scanner(System.in);
        Cliente pessoaCliente = new Cliente();
        Convenio convenio = new Convenio();
        ClienteManipulacao clienteManipulacao = new ClienteManipulacao();
        AdministrativoManipulacao administrativoManipulacao = new AdministrativoManipulacao();
        MedicoManipulacao medicoManipulacao = new MedicoManipulacao();
        int escolha = -1;
        while (escolha != 9) {
            System.out.println("Digite 0 para Cadastros\n" + "Digite 1 para consultas de valores\n" + "Digite 2 para fazer agendamentos.\nDigite 9 para sair.");
            escolha = scanner.nextInt();
            scanner.nextLine();
            if (escolha == 0) {
                int escolhaTipoDeCadastro = -1;
                while (escolhaTipoDeCadastro != 9) {
                    System.out.println("Digite 0 para cadastrar Usuários\n" + "Digite 1 para cadastar Convênio\n" + "Digite 2 para cadastrar Especialidades médicas.\nDigite 9 para sair.");
                    escolhaTipoDeCadastro = scanner.nextInt();
                    scanner.nextLine();
                    if (escolhaTipoDeCadastro == 0) {
                        int escolhacadastro = -1;
                        while (escolhacadastro != 9) {
                            System.out.println("Digite 0 para cadastrar Cliente\n" + "Digite 1 para cadastar administrativo\n" + "Digite 2 para cadastrar médico.\nDigite 9 para sair.");
                            escolhacadastro = scanner.nextInt();
                            scanner.nextLine();
                            if (escolhacadastro == 0) {
                                //ClienteManipulacao clienteManipulacao = new ClienteManipulacao();
                                int opcao = 0;
                                while (opcao != 9) {
                                    System.out.println("Digite 1 para criar cliente");
                                    System.out.println("Digite 2 para listar clientes");
                                    System.out.println("Digite 3 para editar uma cliente");
                                    System.out.println("Digite 4 para excluir cliente");
                                    System.out.println("Digite 9 para sair");
                                    opcao = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao) {
                                        case 1:
                                            //Cliente pessoa = new Cliente();
                                            //Convenio convenio = new Convenio();
                                            System.out.println("Digite o nome do cliente");
                                            pessoaCliente.setNome(scanner.nextLine());
                                            System.out.println("Digite a idade do cliente");
                                            String idade = scanner.nextLine();
                                            System.out.println("Digite o endereço do cliente");
                                            pessoaCliente.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone do cliente");
                                            pessoaCliente.setTelefone(scanner.nextLine());
                                            System.out.println("Digite o cpf do cliente");
                                            pessoaCliente.setCpf(scanner.nextLine());
                                            System.out.println("Digite o convênio do cliente");
                                            convenio.setNome(scanner.nextLine());
                                            System.out.println("Digite o cadastro no orgão regulador do convênio");
                                            convenio.setCadastroDoConvenioNoOragaoRegulador(scanner.nextLine());
                                            System.out.println("Digite a taxa de abatimento do convênio");
                                            convenio.setTaxaDeAbatimentoNaConsulta(scanner.nextDouble());
                                            clienteManipulacao.adicionar(pessoaCliente);
                                            convenioManipulacao.adicionar(convenio);
                                            System.out.println("Cliente adicionado com sucesso.");

                                            break;
                                        case 2:
                                            clienteManipulacao.listar();
                                            break;
                                        case 3:
                                            System.out.println("Qual cliente você deseja editar?");
                                            clienteManipulacao.listar();
                                            int index = scanner.nextInt();
                                            scanner.nextLine();
                                            Cliente pessoaNova = new Cliente();
                                            System.out.println("Digite o novo nome do cliente");
                                            pessoaNova.setNome(scanner.nextLine());
                                            System.out.println("Digite cpf");
                                            pessoaNova.setCpf(scanner.nextLine());
                                            System.out.println("Digite o endereço");
                                            pessoaNova.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone");
                                            pessoaNova.setTelefone(scanner.nextLine());
                                            clienteManipulacao.editar(index, pessoaNova);
                                            System.out.println("Cliente editado com sucesso.");
                                            break;
                                        case 4:
                                            System.out.println("Qual cliente você deseja excluir?");
                                            clienteManipulacao.listar();
                                            int id = scanner.nextInt();
                                            clienteManipulacao.remover(id);
                                            System.out.println("Cliente removido com sucesso.");
                                            break;
                                        case 9:
                                            break;
                                        default:
                                            System.err.println("opção inválida");
                                            break;
                                    }
                                }
                            }
                            if (escolhacadastro == 1) {

                                int opcao = 0;
                                while (opcao != 9) {
                                    System.out.println("Digite 1 para criar pessoa do administrativo");
                                    System.out.println("Digite 2 para listar pessoas do administrativo");
                                    System.out.println("Digite 3 para editar uma pessoa do administrativo");
                                    System.out.println("Digite 4 para excluir pessoas do administrativo");
                                    System.out.println("Digite 9 para sair");
                                    opcao = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao) {
                                        case 1:
                                            //Administrativo pessoa = new Administrativo();
                                            System.out.println("Digite o nome da pessoa");
                                            pessoaAdministrativo.setNome(scanner.nextLine());
                                            System.out.println("Digite o endereço da pessoa");
                                            pessoaAdministrativo.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone da pessoa");
                                            pessoaAdministrativo.setTelefone(scanner.nextLine());
                                            System.out.println("Digite a mátricula da pessoa");
                                            pessoaAdministrativo.setCodigoDoAdministrativo(scanner.nextLine());
                                            administrativoManipulacao.adicionar(pessoaAdministrativo);
                                            System.out.println("Administrativo adicionado com sucesso.");
                                            break;
                                        case 2:
                                            administrativoManipulacao.listar();
                                            break;
                                        case 3:
                                            System.out.println("Qual pessoa do administrativo você deseja editar?");
                                            administrativoManipulacao.listar();
                                            int index = scanner.nextInt();
                                            scanner.nextLine();
                                            Administrativo pessoaNova = new Administrativo();
                                            System.out.println("Digite o novo nome da pessoa");
                                            pessoaNova.setNome(scanner.nextLine());
                                            System.out.println("Digite cpf");
                                            pessoaNova.setCodigoDoAdministrativo(scanner.nextLine());
                                            System.out.println("Digite o endereço");
                                            pessoaNova.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone");
                                            pessoaNova.setTelefone(scanner.nextLine());
                                            administrativoManipulacao.editar(index, pessoaNova);
                                            System.out.println("Administrativo editado com sucesso.");
                                            break;
                                        case 4:
                                            System.out.println("Qual administrativo você deseja excluir?");
                                            administrativoManipulacao.listar();
                                            int id = scanner.nextInt();
                                            administrativoManipulacao.remover(id);
                                            System.out.println("Administrativo removido com sucesso.");
                                            break;
                                        case 9:
                                            break;
                                        default:
                                            System.err.println("opção inválida");
                                            break;
                                    }
                                }
                            }
                            if (escolhacadastro == 2) {
                                //MedicoManipulacao medicoManipulacao = new MedicoManipulacao();
                                int opcao = 0;
                                while (opcao != 9) {
                                    System.out.println("Digite 1 para criar médico");
                                    System.out.println("Digite 2 para listar médicos");
                                    System.out.println("Digite 3 para editar  médico");
                                    System.out.println("Digite 4 para excluir  médico");
                                    System.out.println("Digite 9 para sair");
                                    opcao = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (opcao) {
                                        case 1:
                                            //Medico pessoa = new Medico();
                                            //Especialidades especialidade = new Especialidades();
                                            System.out.println("Digite o nome do médico");
                                            pessoaMedico.setNome(scanner.nextLine());
                                            System.out.println("Digite o endereço do médico");
                                            pessoaMedico.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone do médico");
                                            pessoaMedico.setTelefone(scanner.nextLine());
                                            System.out.println("Digite o CRM do médico");
                                            pessoaMedico.setCrm(scanner.nextLine());
                                            System.out.println("Digite a especialidade do médico");
                                            especialidade.setNome(scanner.nextLine());
                                            System.out.println("Digite o valor da consulta da especialidade do médico");
                                            especialidade.setValor(scanner.nextDouble());
                                            scanner.nextLine();
                                            medicoManipulacao.adicionar(pessoaMedico);
                                            especialidadesManipulacao.adicionar(especialidade);
                                            System.out.println("Médico adicionado com sucesso.");
                                            break;
                                        case 2:
                                            medicoManipulacao.listar();
                                            break;
                                        case 3:
                                            System.out.println("Qual médico você deseja editar?");
                                            medicoManipulacao.listar();
                                            int index = scanner.nextInt();
                                            scanner.nextLine();

                                            Medico pessoaNova = new Medico();
                                            System.out.println("Digite o nome do médico");
                                            pessoaNova.setNome(scanner.nextLine());
                                            System.out.println("Digite o CRM");
                                            pessoaNova.setCrm(scanner.nextLine());
                                            System.out.println("Digite o endereço");
                                            pessoaNova.setEndereco(scanner.nextLine());
                                            System.out.println("Digite o telefone");
                                            pessoaNova.setTelefone(scanner.nextLine());
                                            medicoManipulacao.editar(index, pessoaNova);
                                            System.out.println("Médico editado com sucesso.");
                                            break;
                                        case 4:
                                            System.out.println("Qual médico você deseja excluir?");
                                            medicoManipulacao.listar();
                                            int id = scanner.nextInt();
                                            medicoManipulacao.remover(id);
                                            System.out.println("Médico excluído com sucesso.");

                                            break;
                                        case 9:
                                            break;
                                        default:
                                            System.err.println("opção inválida");
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    if (escolhaTipoDeCadastro == 1) {
                        int opcao = 0;
                        while (opcao != 9) {
                            System.out.println("Digite 1 para criar convênio");
                            System.out.println("Digite 2 para listar convênios");
                            System.out.println("Digite 3 para editar um convênio");
                            System.out.println("Digite 4 para excluir convênio");
                            System.out.println("Digite 9 para sair");
                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcao) {
                                case 1:
                                    Convenio pessoa = new Convenio();
                                    System.out.println("Digite o nome do convênio");
                                    pessoa.setNome(scanner.nextLine());
                                    System.out.println("Digite o codigo de verificação no orgão regulamentador");
                                    pessoa.setCadastroDoConvenioNoOragaoRegulador(scanner.nextLine());
                                    System.out.println("Digite a taxa de abatimento do plano (0 a 1)");
                                    pessoa.setTaxaDeAbatimentoNaConsulta(scanner.nextDouble());
                                    scanner.nextLine();
                                    convenioManipulacao.adicionar(pessoa);
                                    System.out.println("Convênio adicionado com sucesso.");

                                    break;
                                case 2:
                                    convenioManipulacao.listar();
                                    break;
                                case 3:
                                    System.out.println("Qual cliente você deseja editar?");
                                    convenioManipulacao.listar();
                                    int index = scanner.nextInt();
                                    scanner.nextLine();

                                    Convenio pessoaNova = new Convenio();
                                    System.out.println("Digite o novo nome do convênio");
                                    pessoaNova.setNome(scanner.nextLine());
                                    System.out.println("Digite o código de verificação no orgão regulamentador");
                                    pessoaNova.setCadastroDoConvenioNoOragaoRegulador(scanner.nextLine());
                                    System.out.println("Digite a taxa de abatimento (0 a 1)");
                                    pessoaNova.setTaxaDeAbatimentoNaConsulta(scanner.nextDouble());
                                    convenioManipulacao.editar(index, pessoaNova);
                                    System.out.println("Convênio editado com sucesso.");

                                    break;
                                case 4:
                                    System.out.println("Qual convênio você deseja excluir?");
                                    convenioManipulacao.listar();
                                    int id = scanner.nextInt();
                                    convenioManipulacao.remover(id);
                                    System.out.println("Convênio removido com sucesso.");

                                    break;
                                case 9:
                                    break;
                                default:
                                    System.err.println("opção inválida");
                                    break;
                            }
                        }
                    }

                    if (escolhaTipoDeCadastro == 2) {
                        //EspecialidadesManipulacao especialidadesManipulacao = new EspecialidadesManipulacao();
                        int opcao = 0;
                        while (opcao != 9) {
                            System.out.println("Digite 1 para criar especialidade");
                            System.out.println("Digite 2 para listar especialidades");
                            System.out.println("Digite 3 para editar uma especialidade");
                            System.out.println("Digite 4 para excluir especialidade");
                            System.out.println("Digite 9 para sair");
                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcao) {
                                case 1:
                                    Especialidades pessoa = new Especialidades();
                                    System.out.println("Digite o nome da especialidade");
                                    pessoa.setNome(scanner.nextLine());
                                    System.out.println("Digite o valor da consulta da especialidade");
                                    pessoa.setValor(scanner.nextDouble());
                                    scanner.nextLine();
                                    especialidadesManipulacao.adicionar(pessoa);
                                    System.out.println("Especialidade adicionada com sucesso.");

                                    break;
                                case 2:
                                    especialidadesManipulacao.listar();
                                    break;
                                case 3:
                                    System.out.println("Qual especialidade você deseja editar?");
                                    especialidadesManipulacao.listar();
                                    int index = scanner.nextInt();
                                    scanner.nextLine();

                                    Especialidades pessoaNova = new Especialidades();
                                    System.out.println("Digite o novo nome da especialidade");
                                    pessoaNova.setNome(scanner.nextLine());
                                    System.out.println("Digite o valor da consulta da especialidade");
                                    pessoaNova.setValor(scanner.nextDouble());
                                    especialidadesManipulacao.editar(index, pessoaNova);
                                    System.out.println("Especialidade editada com sucesso.");

                                    break;
                                case 4:
                                    System.out.println("Qual cliente você deseja excluir?");
                                    especialidadesManipulacao.listar();
                                    int id = scanner.nextInt();
                                    especialidadesManipulacao.remover(id);
                                    System.out.println("Especialidade removida com sucesso.");

                                    break;
                                case 9:

                                    break;
                                default:
                                    System.err.println("opção inválida");
                                    break;
                            }
                        }
                    }
                }
            }
            if (escolha == 1) {
                int idade = 0;
                System.out.println("Digite 1 para consulta de valores particular e 2 para consulta de valores convênio.");
                int escolhaConsulta = scanner.nextInt();
                scanner.nextLine();
                String convenio1 = "";
                if (escolhaConsulta == 2) {
                    System.out.println("Digite seu nome");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a sua idade");
                    idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do seu plano de saúde");
                    String escolhaConvenio = scanner.nextLine();
                    convenio1 =escolhaConvenio;
                }
                System.out.println("Digite o nome da especialidade que deseja saber o valor");
                String escolhaEspecialidade = scanner.nextLine();
                double choice;
                double valorDaConsulta = 0.0;
                double taxa = 0;
                double valorDoAbatimento = 0;

                //ArrayList<Especialidades> listaDeEspecialidades = convenioManipulacao.;
                //ArrayList<Convenio> listaDeConvenios = new ArrayList<>();
                for(Especialidades especialidades : especialidadesManipulacao.getListaDeEspecialidades()) {
                    String nome = especialidades.getNome();
                    if (nome.equals(escolhaEspecialidade)) {
                        choice = especialidades.getValor();
                        valorDaConsulta = choice;
                    }
                }


                for(Convenio convenios : convenioManipulacao.getListaDeConvenio()) {
                    String nome = convenios.getNome();
                    if (nome.equals(convenio1)) {
                        taxa = convenios.getTaxaDeAbatimentoNaConsulta();
                        valorDoAbatimento = taxa;
                    }
                }
                if (idade >= 70){
                    valorDoAbatimento = valorDoAbatimento - 0.3;
                }
                System.out.println("O valor da consulta selecionada, é:" + (valorDaConsulta - (valorDaConsulta * valorDoAbatimento)));
            }
            if (escolha == 2) {
                System.out.println("Digite 1 para agendamento de consulta.\nDigite 2 para agendamento de exame. \nDigite 3 para agendamento de cirurgia.\nDigite 4 para agendamento de tratamento especial.");
                int escolhaAgenda = scanner.nextInt();
                scanner.nextLine();
                if (escolhaAgenda == 1){
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a especialidade");
                    String especialidades = scanner.nextLine();
                    System.out.println("Digite o dia");
                    String dia = scanner.nextLine().toString();
                    System.out.println("Digite o horario");
                    String horario = scanner.nextLine().toString();
                    agendamento.agendar(nome, dia, horario, especialidades);
                    System.out.println("Consulta agendada com sucesso.");


                }
                if (escolhaAgenda == 2){
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a especialidade");
                    String especialidades = scanner.nextLine();
                    System.out.println("Digite o dia");
                    String dia = scanner.nextLine().toString();
                    System.out.println("Digite o horario");
                    String horario = scanner.nextLine().toString();
                    System.out.println("Digite o exame");
                    String exame = scanner.nextLine();
                    agendamento.agendar(nome, dia, horario, especialidades, exame);
                    System.out.println("Exame agendado com sucesso.");


                }
                if (escolhaAgenda == 3){
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a especialidade");
                    String especialidades = scanner.nextLine();
                    System.out.println("Digite o dia");
                    String dia = scanner.nextLine().toString();
                    System.out.println("Digite o horario");
                    String horario = scanner.nextLine().toString();
                    System.out.println("Digite o tipo de cirurgia");
                    String cirurgia = scanner.nextLine();
                    agendamento.agendar(nome, dia, horario, especialidades, cirurgia);
                    System.out.println("Cirurgia agendada com sucesso.");


                }
                if (escolhaAgenda == 4){
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o dia");
                    String dia = scanner.nextLine().toString();
                    System.out.println("Digite o horario");
                    String horario = scanner.nextLine().toString();
                    System.out.println("Digite o tipo de tratamento");
                    String cirurgia = scanner.nextLine();
                    String tratamento = "Tratamento especial";
                    agendamento.agendar(tratamento, nome, dia, horario, cirurgia);
                    System.out.println("Tratamento especial agendado com sucesso.");

                }
                agendamento.imprimirAgendamentos();
            }
        }
    }
}