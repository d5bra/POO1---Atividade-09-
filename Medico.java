package Fila;

public class Medico {

  
    private String nome;
    private boolean disponivel;

    // Construtor 
    public Medico(String nome) {
        setNome(nome);        
        this.disponivel = true; 
    }

    // Ocupa o médico 
    public void ocupar() {
        disponivel = false;
    }

    // Libera o médico 
    public void liberar() {
        disponivel = true;
    }

    // Getts e Setts 
    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setNome(String nome) {
     
        if (nome != null && nome.trim().length() >= 3) {
            this.nome = nome.trim();
        } else {
            System.out.println("Nome inválido! Deve ter pelo menos 3 caracteres.");
        }
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
