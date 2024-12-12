import java.util.Random;

public class Dado {
    private int lado;

    public int jogarDado(){
        Random random = new Random();
        this.lado = random.nextInt(6) + 1;
        return lado;
    }
}
