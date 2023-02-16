import java.util.ArrayList;
import java.util.List;

public class MedicoManipulacao implements Manipulacao {
    private List<Medico> listaDeMedico;

    public MedicoManipulacao() {
        this.listaDeMedico = new ArrayList<>();
    }

    public void adicionar(Medico pessoa) {
        this.listaDeMedico.add(pessoa);
    }

    public void remover(Integer index) {
        this.listaDeMedico.remove(index.intValue());
    }

    public void editar(Integer index, Medico pessoa) {
        Medico pessoaProcurada = listaDeMedico.get(index);
        pessoaProcurada.setNome(pessoa.getNome());
        pessoaProcurada.setEndereco(pessoa.getEndereco());
        pessoaProcurada.setTelefone(pessoa.getTelefone());
        pessoaProcurada.setCrm(pessoa.getCrm());
    }
    public void listar() {
        for (int i = 0; i < listaDeMedico.size(); i++) {
            System.out.println("id=" + i + " | " + " Nome: " +  listaDeMedico.get(i).getNome() + " | " + " CRM do médico: " + listaDeMedico.get(i).getCrm() +  " Enderço: "  + listaDeMedico.get(i).getEndereco() + " | " + " telefone: " + listaDeMedico.get(i).getTelefone());
        }
    }
}
