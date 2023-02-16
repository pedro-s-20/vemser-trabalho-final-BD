import java.util.ArrayList;
import java.util.List;

public class ConvenioManipulacao implements Manipulacao {
    private List<Convenio> listaDeConvenio;

    public ConvenioManipulacao() {
        this.listaDeConvenio = new ArrayList<>();
    }

    public void adicionar(Convenio pessoa) {
        this.listaDeConvenio.add(pessoa);
    }

    public void remover(Integer index) {
        this.listaDeConvenio.remove(index.intValue());
    }

    public void editar(Integer index, Convenio pessoa) {
        Convenio pessoaProcurada = listaDeConvenio.get(index);
        pessoaProcurada.setNome(pessoa.getNome());
        pessoaProcurada.setCadastroDoConvenioNoOragaoRegulador(pessoa.getCadastroDoConvenioNoOragaoRegulador());
        pessoaProcurada.setTaxaDeAbatimentoNaConsulta(pessoa.getTaxaDeAbatimentoNaConsulta());
    }

    public List<Convenio> getListaDeConvenio() {
        return listaDeConvenio;
    }

    public void listar() {
        for (int i = 0; i < listaDeConvenio.size(); i++) {
            System.out.println("id=" + i + " | " + " Nome: " +  listaDeConvenio.get(i).getNome() + " | " + " Código de cadastro no orgão regulador: " + listaDeConvenio.get(i).getCadastroDoConvenioNoOragaoRegulador() +  " Taxa de abatimento na consulta (%): "  + listaDeConvenio.get(i).getTaxaDeAbatimentoNaConsulta());
        }
    }

}

