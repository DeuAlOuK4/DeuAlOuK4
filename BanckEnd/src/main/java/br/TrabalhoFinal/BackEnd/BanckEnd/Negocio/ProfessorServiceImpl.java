package br.TrabalhoFinal.BackEnd.BanckEnd.Negocio;

import br.TrabalhoFinal.BackEnd.BanckEnd.BanckEndApplication;
import br.TrabalhoFinal.BackEnd.BanckEnd.Entidade.Professor;
import br.TrabalhoFinal.BackEnd.BanckEnd.Persistencia.ProfessorRepository;
import br.TrabalhoFinal.BackEnd.BanckEnd.Util.BackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class ProfessorServiceImpl implements ProfessorService{

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository repository){
        this.repository=repository;
    }

    @Override
    public Professor incluir(Professor professor){
        try{
            repository.save(professor);
            return professor;
        }
        catch (Exception e){
            throw new BackEndException("Não foi possível incluir usuário");
        }
    }

    @Override
    public List<Professor>listar(){
        try{
            return(List<Professor>)this.repository.findAll();
        }
        catch (Exception e){
            throw new BackEndException("Não foi possível listar os usuários!");
        }
    }

    @Override
    public Professor consultar(Integer id){
        try{
            return this.repository.findById(id).get();
        }
        catch (Exception e){
            throw new BackEndException("Não foi possível consultar o usuário"+id+"!");
        }
    }

    @Override
    public void alterar(Professor professor){
        try{
            repository.save(professor);
        }
        catch (Exception e){
            throw new BackEndException("Não foi possível alterar o nome do professor"+professor.getId()+"!");
        }
    }

    @Override
    public void excluir(Integer id){
        try{
            repository.deleteById(id);
        }
        catch(Exception e){
            throw new BackEndException("Não foi possível excluir o professor"+id+"!");
        }
    }
}
