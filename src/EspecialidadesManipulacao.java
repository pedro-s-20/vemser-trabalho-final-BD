import java.util.ArrayList;
import java.util.List;

public class EspecialidadesManipulacao implements Manipulacao {
    private List<Especialidades> listaDeEspecialidades;

    public EspecialidadesManipulacao() {
        this.listaDeEspecialidades = new ArrayList<>();
    }

    public void adicionar(Especialidades pessoa) {
        this.listaDeEspecialidades.add(pessoa);
    }

    public void remover(Integer index) {
        this.listaDeEspecialidades.remove(index.intValue());
    }

    public void editar(Integer index, Especialidades pessoa) {
        Especialidades pessoaProcurada = listaDeEspecialidades.get(index);
        pessoaProcurada.setNome(pessoa.getNome());
        pessoaProcurada.setValor(pessoa.getValor());
    }

    public List<Especialidades> getListaDeEspecialidades() {
        return listaDeEspecialidades;
    }

    public void listar() {
        for (int i = 0; i < listaDeEspecialidades.size(); i++) {
            System.out.println("id=" + i + " | " + " Nome: " +  listaDeEspecialidades.get(i).getNome() + " | " + listaDeEspecialidades.get(i).getValor());
        }
    }

}
