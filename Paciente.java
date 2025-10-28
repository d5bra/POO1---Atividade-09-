package Fila;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Paciente {
   
	private String nome;
	
	// Prioridade: 1 = NÃO URGENTE, 2 = POUCO URGENTE, 3 = URGÊNCIA, 4 = EMERGÊNCIA
    private int prioridade;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private String medicoAtendente;

    
    // Construtor
    public Paciente(String nome, int prioridade) {
        setNome(nome);                
        this.prioridade = prioridade; 
        this.horarioEntrada = LocalDateTime.now(); 
    }

    // Mostrar informações do paciente 
    public void mostrarInfo() {
        System.out.printf(
            "Nome: %-15s - Prioridade: %-15s - Entrada: %s - Atendimento: %s - Médico: %s%n",
            nome,
            getPrioridadeDescricao(),
            getHorarioEntradaFormatado(),
            getHorarioSaidaFormatado(),
            getMedicoAtendente()
        );
    }
    
 //  Registrar atendimento e médico
    public void registrarSaida(String medico) {
        this.horarioSaida = LocalDateTime.now(); 
        this.medicoAtendente = medico;           
    }

    //  Descrição da prioridade 
    public String getPrioridadeDescricao() {
        switch (prioridade) {
            case 4: return "EMERGÊNCIA";
            case 3: return "URGÊNCIA";
            case 2: return "POUCO URGENTE";
            case 1: return "NÃO URGENTE";
            default: return "DESCONHECIDA";
        }
    }

    //  Getts e Setts
    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public String getMedicoAtendente() {
        return medicoAtendente == null ? "-" : medicoAtendente;
    }

    public String getHorarioEntradaFormatado() {
        return horarioEntrada.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getHorarioSaidaFormatado() {
        if (horarioSaida == null) return "-";
        return horarioSaida.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

  
    public void setNome(String nome) {
        if (nome != null && nome.trim().length() >= 3) {
            this.nome = nome.trim();
        } else {
            System.out.println("Nome inválido! Deve ter pelo menos 3 caracteres.");
        }
    }

}
