import java.util.ArrayList;

public class Cliente extends Usuario implements Impressao{
    private Convenio convenio= new Convenio();
    private String cpf;
    ArrayList<String> agendamento =  new ArrayList<>();
    public Cliente() {

    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    //Interface
    public void imprimirAgendamentos() {
            System.out.println(agendamento);
    }

    // Polimorfismo
    public void agendar(String nome, String dia, String horario) {
        agendamento.add(nome);
        agendamento.add(dia);
        agendamento.add(horario);
        agendamento.add("|| ");
    }
    public void agendar(String nome, String dia, String horario, String especialidade) {
        agendamento.add(nome);
        agendamento.add(dia);
        agendamento.add(horario);
        agendamento.add(especialidade);
        agendamento.add("|| ");
    }
    public void agendar(String nome, String dia, String horario, String especialidade, String exame) {
        agendamento.add(nome);
        agendamento.add(dia);
        agendamento.add(horario);
        agendamento.add(especialidade);
        agendamento.add(exame);
        agendamento.add("|| ");
    }
    public void agendar(String tratamento, String nome, String dia, String horario, String especialidade, String exame) {
        agendamento.add(tratamento);
        agendamento.add(nome);
        agendamento.add(dia);
        agendamento.add(horario);
        agendamento.add(especialidade);
        agendamento.add(exame);
        agendamento.add("|| ");
    }
}
