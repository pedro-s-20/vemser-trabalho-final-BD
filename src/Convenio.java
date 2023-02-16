public class Convenio {
    private String nome;
    private String cadastroDoConvenioNoOragaoRegulador;
    private double taxaDeAbatimentoNaConsulta;



    public Convenio(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCadastroDoConvenioNoOragaoRegulador() {
        return cadastroDoConvenioNoOragaoRegulador;
    }

    public void setCadastroDoConvenioNoOragaoRegulador(String cadastroDoConvenioNoOragaoRegulador) {
        this.cadastroDoConvenioNoOragaoRegulador = cadastroDoConvenioNoOragaoRegulador;
    }

    public double getTaxaDeAbatimentoNaConsulta() {
        return taxaDeAbatimentoNaConsulta;
    }

    public void setTaxaDeAbatimentoNaConsulta(double taxaDeAbatimentoNaConsulta) {
        this.taxaDeAbatimentoNaConsulta = taxaDeAbatimentoNaConsulta;
    }
}
