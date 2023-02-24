package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Administrativo;
import com.dbc.repository.AdministrativoRepository;

public class AdministrativoService implements Service<Integer, Administrativo>{

    private AdministrativoRepository administrativoRepository;

    public AdministrativoService(){
        administrativoRepository = new AdministrativoRepository();
    }

    @Override
    public void adicionar(Administrativo administrativo) {
        try{
            if(validarEntradas(administrativo)){
                Administrativo administrativoAdicionado = administrativoRepository.adicionar(administrativo);
                System.out.println("Administrativo adicionado com sucesso!" + administrativoAdicionado);
            }
        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Integer id) {

        try{
            boolean conseguiuRemover= administrativoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }

    }

    @Override
    public void editar(Integer id, Administrativo administrativo) {
        try{
            if(validarEntradas(administrativo)){
                boolean conseguiuEditar= administrativoRepository.editar(id, administrativo);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try{
            administrativoRepository.listar().forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validarEntradas(Administrativo administrativo) {
        if(administrativo.getIdUsuario() < 1 || administrativo.getIdUsuario().toString().length() > 10){
            System.err.println("Erro em 'Código usuário'! Id inválido!");
            return false;
        }
        return true;
    }
}
