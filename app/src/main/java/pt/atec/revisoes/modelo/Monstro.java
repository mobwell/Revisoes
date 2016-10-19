package pt.atec.revisoes.modelo;

/**
 * Created by eu on 19-10-2016.
 */
public class Monstro {
    private int image;
    private int hp;

    public Monstro(int image, int hp) {
        this.image = image;
        this.hp = hp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
