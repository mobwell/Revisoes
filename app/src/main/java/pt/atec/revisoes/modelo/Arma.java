package pt.atec.revisoes.modelo;

/**
 * Created by eu on 19-10-2016.
 */
public class Arma {
    private int imagem;
    private String nome;
    private int ataque;

    public Arma(int imagem, String nome, int ataque) {
        this.imagem = imagem;
        this.nome = nome;
        this.ataque = ataque;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
