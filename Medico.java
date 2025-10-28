package Fila;

public class Medico {

  
    private String nome;

    // Construtor 
    public Medico(String nome) {
        setNome(nome);        
    }

    // Getts e Setts 
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
     
        if (nome != null && nome.trim().length() >= 3) {
            this.nome = nome.trim();
        } else {
            System.out.println("Nome inválido! Deve ter pelo menos 3 caracteres.");
        }
    }

}
