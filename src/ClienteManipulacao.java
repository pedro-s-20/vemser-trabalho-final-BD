import java.util.ArrayList;
import java.util.List;

public class ClienteManipulacao implements Manipulacao {
    private List<Cliente> listaDeCliente;

    public ClienteManipulacao() {
        this.listaDeCliente = new ArrayList<>();
    }

    public void adicionar(Cliente pessoa) {
        this.listaDeCliente.add(pessoa);
    }

    public void remover(Integer index) {
        this.listaDeCliente.remove(index.intValue());
    }

    public void editar(Integer index, Cliente pessoa) {
        Cliente pessoaProcurada = listaDeCliente.get(index);
        pessoaProcurada.setCpf(pessoa.getCpf());
        pessoaProcurada.setNome(pessoa.getNome());
        pessoaProcurada.setTelefone(pessoa.getTelefone());
        pessoaProcurada.setEndereco(pessoa.getEndereco());
    }

    public void listar() {
        for (int i = 0; i < listaDeCliente.size(); i++) {
            //this.imprimir();
            System.out.println("id=" + i + " | " + " Nome: " +  listaDeCliente.get(i).getNome() + " | " + " CPF: " + listaDeCliente.get(i).getCpf() +  " Enderço: "  + listaDeCliente.get(i).getEndereco() + " | " + " telefone: " +listaDeCliente.get(i).getTelefone());
        }
    }

}
