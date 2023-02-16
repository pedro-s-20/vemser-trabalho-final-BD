import java.util.ArrayList;
import java.util.List;

public class AdministrativoManipulacao implements Manipulacao {
    private List<Administrativo> listaDeAdministrativo;

    public AdministrativoManipulacao() {
        this.listaDeAdministrativo = new ArrayList<>();
    }

    public void adicionar(Administrativo pessoa) {
        this.listaDeAdministrativo.add(pessoa);
    }

    public void remover(Integer index) {
        this.listaDeAdministrativo.remove(index.intValue());
    }

    public void editar(Integer index, Administrativo pessoa) {
        Administrativo pessoaProcurada = listaDeAdministrativo.get(index);
        pessoaProcurada.setCodigoDoAdministrativo(pessoa.getCodigoDoAdministrativo());
        pessoaProcurada.setNome(pessoa.getNome());
        pessoaProcurada.setTelefone(pessoa.getTelefone());
        pessoaProcurada.setEndereco(pessoa.getEndereco());
    }

    public void listar() {
        for (int i = 0; i < listaDeAdministrativo.size(); i++) {
            System.out.println("id=" + i + " | " + " Nome: " +  listaDeAdministrativo.get(i).getNome() + " | " + " Codigo do administrativo: " + listaDeAdministrativo.get(i).getCodigoDoAdministrativo() +  " Enderço: "  + listaDeAdministrativo.get(i).getEndereco() + " | " + " telefone: " + listaDeAdministrativo.get(i).getTelefone());
        }
    }

}

