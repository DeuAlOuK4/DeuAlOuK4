package br.TrabalhoFinal.BackEnd.BanckEnd.Entidade;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Professor {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="idade")
    private Integer idade;

    @Column(name="nome")
    private String nome;

    public Professor(Integer id, Integer idade, String nome) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
