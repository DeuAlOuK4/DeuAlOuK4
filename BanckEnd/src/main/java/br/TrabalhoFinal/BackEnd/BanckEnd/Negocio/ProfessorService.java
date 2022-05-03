package br.TrabalhoFinal.BackEnd.BanckEnd.Negocio;

import br.TrabalhoFinal.BackEnd.BanckEnd.Entidade.Professor;

import java.util.List;

public interface ProfessorService {

    public Professor incluir(Professor professor);
    public List<Professor> listar();
    public Professor consultar(Integer id);
    public void alterar(Professor professor);
    public void excluir(Integer id);
}
