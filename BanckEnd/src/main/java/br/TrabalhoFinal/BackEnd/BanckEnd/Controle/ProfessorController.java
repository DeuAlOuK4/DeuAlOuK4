package br.TrabalhoFinal.BackEnd.BanckEnd.Controle;

import br.TrabalhoFinal.BackEnd.BanckEnd.Entidade.Professor;
import br.TrabalhoFinal.BackEnd.BanckEnd.Negocio.ProfessorService;
import br.TrabalhoFinal.BackEnd.BanckEnd.Util.BackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
Classe controladora de professores


 */


@RestController
@CrossOrigin(origins = "*", maxAge =3600)
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public void setProfessorService(ProfessorService professorService){
        this.professorService=professorService;
    }

    /*
    Metodo que lista os professores
     */
    @GetMapping(value="/listar-professores")
    public List<Professor> listar(){
        List<Professor> lista=professorService.listar();
        return lista;
    }

    /*
    Metodo que lista os professore por id
     */
    @GetMapping(value="/consultar-professor/{id}")
    public Professor consultar(@PathVariable Integer id){
        return professorService.consultar(id);
    }

    /*
    Metodo que salva(inclui ou altera) um professor
     */
    @PostMapping(value="/salvar-professor")
    public Professor salvar(@RequestBody Professor professor){
        try{
            if(professor.getId()==null){
                professor=professorService.incluir(professor);
            }
            else{
                professorService.alterar(professor);
            }
            return professor;
        }
        catch (BackEndException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getReason());
        }
    }

    /*
    Metodo que exclui o professor pelo id
     */
    @DeleteMapping(value="/excluir-professor/{id}")
    public void excluir(@PathVariable Integer id){
        professorService.excluir(id);
    }

}
