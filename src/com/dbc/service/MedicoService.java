package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Cliente;
import com.dbc.model.Medico;
import com.dbc.repository.ClienteRepository;
import com.dbc.repository.MedicoRepository;

public class MedicoService implements Service<Integer, Medico>{
    private MedicoRepository medicoRepository;

    public MedicoService(){
        medicoRepository = new MedicoRepository();
    }

    @Override
    public void adicionar(Medico medico) {
        try {
            if (validarEntradas(medico)) {
                Medico medicoAdicionado = medicoRepository.adicionar(medico);
                System.out.println("Cliente adicinado com sucesso! " + medicoAdicionado);
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
            boolean conseguiuRemover = medicoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, Medico medico) {
        try {
            if (validarEntradas(medico)){
                boolean conseguiuEditar = medicoRepository.editar(id, medico);
                System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
            }
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listar() {
        try {
            medicoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validarEntradas(Medico medico) {
        if (medico.getIdMedico() != null && medico.getIdUsuario().toString().length() > 10){
            System.err.println("Erro em 'id_medico': número de caracteres é superior à 10.");
            return false;
        }

        if (medico.getCrm() != null && medico.getCrm().length() > 13){
            System.err.println("Erro em 'crm': número de caracteres é superior à 13.");
            return false;
        }

        if (medico.getIdEspecialidade() != null && medico.getIdEspecialidade().toString().length() > 10){
            System.err.println("Erro em 'id_especialidade': número de caracteres é superior à 10.");
            return false;
        }

        if (medico.getIdUsuario() != null && medico.getIdUsuario().toString().length() > 10){
            System.err.println("Erro em 'id_usuario': número de caracteres é superior à 10.");
            return false;
        }

        return true;
    }
}
