import java.util.List;

public class Jogador {

    private String nome;
    private int valorAposta;
    private int vitorias;

    public Jogador(String nome, int valorAposta) {
        this.nome = nome;
        this.valorAposta = valorAposta;
        this.vitorias = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValorAposta() {
        return valorAposta;
    }
    public void setValorAposta(int valorAposta) {
        this.valorAposta = valorAposta;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }
}
