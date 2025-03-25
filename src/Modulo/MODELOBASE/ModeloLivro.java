package Modulo.MODELOBASE;

import java.util.Date;

// Classe modelo que representa um livro
public class ModeloLivro {
    private int id;
    private String nome;
    private Date dataLancamento;

    // Construtor para inicializar um livro
    public ModeloLivro(int id, String nome, Date dataLancamento) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    // Métodos de acesso (getters e setters)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(Date dataLancamento) { this.dataLancamento = dataLancamento; }

    @Override
    public String toString() {
        return "ModeloLivro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}

