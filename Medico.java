package Fila;

public class Medico {
    private String nome;
    private boolean disponivel;

    public Medico(String nome) {
        setNome(nome);  // usa o setter para aplicar validação também no construtor
        this.disponivel = true;
    }

    // ---------- GETTERS ----------
    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // ---------- SETTERS ----------
    public void setNome(String nome) {
        if (nome != null && nome.trim().length() >= 3) {
            this.nome = nome.trim();
        } else {
            System.out.println("Nome inválido. Deve ter pelo menos 3 caracteres. Alteração não realizada.");
        }
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // ---------- MÉTODOS DE CONTROLE DE ATENDIMENTO ----------
    public void ocupar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    // ---------- MÉTODO PARA EXIBIR STATUS NO CONSOLE ----------
    public void mostrarStatus() {
        if (disponivel) {
            System.out.println("Dr(a). " + nome + " (Disponível)");
        } else {
            System.out.println("Dr(a). " + nome + " (Ocupado)");
        }
    }
}
