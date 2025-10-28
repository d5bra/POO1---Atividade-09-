package Fila;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa {
   
	private String nome;
    private int prioridade;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private String medicoAtendente;

    public Pessoa(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.horarioEntrada = LocalDateTime.now();
    }

    public String getNome() { return nome; }
    public int getPrioridade() { return prioridade; }
    public LocalDateTime getHorarioEntrada() { return horarioEntrada; }

    
    public void registrarSaida(String medico) {
        this.horarioSaida = LocalDateTime.now();
        this.medicoAtendente = medico;
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

    public void mostrarInfo() {
        System.out.printf(
            "Nome: %-15s | Prioridade: %d | Entrada: %s | Saída: %s | Médico: %s%n",
            nome, prioridade, getHorarioEntradaFormatado(), getHorarioSaidaFormatado(), getMedicoAtendente()
        );
    }
}
