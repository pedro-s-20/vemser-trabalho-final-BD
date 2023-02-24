package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Convenio;
import com.dbc.repository.ConvenioRepository;


public class ConvenioService implements Service<Integer, Convenio>{
    private ConvenioRepository convenioRepository;

    public ConvenioService(){
        convenioRepository = new ConvenioRepository();
    }
    @Override
    public void adicionar(Convenio convenio) {
        try {
            if (validarEntradas(convenio)) {
                Convenio enderecoAdicionado = convenioRepository.adicionar(convenio);
                System.out.println("Convênio adicinado com sucesso! " + enderecoAdicionado);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = convenioRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Convenio convenio) {
        try {
            if (validarEntradas(convenio)){
                boolean conseguiuEditar = convenioRepository.editar(id, convenio);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            convenioRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validarEntradas(Convenio convenio) {
        if (convenio.getCadastroOragaoRegulador() != null && convenio.getCadastroOragaoRegulador().length() > 40){
            System.err.println("Erro em 'Orgão Regulador': Número de caracteres além do permitodo (40) !");
            return false;
        }
        if (convenio.getTaxaAbatimento() != null ){
            if (convenio.getTaxaAbatimento() > 99){
                System.err.println("Erro em 'Taxa de Abatimento': Número inválido como taxa (%)!");
                return false;
            }

            Double valorDeEntrada = convenio.getTaxaAbatimento();
            String valorComCasasDividas[] = valorDeEntrada.toString().split("\\.");

            if (valorComCasasDividas[0].length() > 2 || (valorComCasasDividas.length == 2 && valorComCasasDividas[1].length() > 2)) {
                System.err.println("Erro em 'Taxa de Abatimento': Número decimal inválido (exemplo: 50.00)");
                return false;
            }
        }

        return true;
    }
}
