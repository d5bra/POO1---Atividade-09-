package Fila;

import java.util.*;


public class AtendimentoMedico {
   
	// Fila de pacientes
	private static Paciente[] fila = new Paciente[20]; 
    private static int totalPacientes = 0;
    
    // Lista de médicos
    private static List<Medico> medicos = new ArrayList<>(); 
    
    // Histórico de atendimentos
    private static List<Paciente> historico = new ArrayList<>();
    
 // Índice do próximo médico para atendimento (distribuição cíclica)
    private static int indiceMedico = 0; 
    
    
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {	
    	System.out.println("SISTEMA DE ATENDIMENTO MÉDICO");

    	// Cadastrar médicos
        cadastrarMedicosIniciais(); 

     // Loop do menu principal
        while (true) {
            mostrarMenu();
            int opcao = lerOpcaoMenu();
            if (opcao == 1) inserirPaciente();
            else if (opcao == 2) mostrarFilaPorPrioridade();
            else if (opcao == 3) mostrarHistorico();
            else if (opcao == 4) atenderProximoPaciente();
        }
    }
    // MENU
    private static void mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Inserir paciente na fila");
        System.out.println("2 - Mostrar fila (por prioridade)");
        System.out.println("3 - Mostrar histórico de atendimentos");
        System.out.println("4 - Atender próxima pessoa");
    }

    // Leitura menu segura
    private static int lerOpcaoMenu() {
        while (true) {
            System.out.print("Escolha uma opção: ");
            String entrada = sc.nextLine().trim();

            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3") || entrada.equals("4")) {
                return Integer.parseInt(entrada);
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

   // Cadastro de medicos
    private static void cadastrarMedicosIniciais() {
        
    	int qtd;

        while (true) {
            System.out.print("Quantos médicos estão de plantão? (máx. 5): ");
            String entrada = sc.nextLine().trim();
            if (entrada.matches("[1-5]")) {
                qtd = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println("Número inválido. Insira entre 1 e 5.");
            }
        }

        for (int i = 1; i <= qtd; i++) {
            System.out.print("Nome do médico " + i + ": ");
            String nome = sc.nextLine().trim();
            medicos.add(new Medico(nome));
        }
        System.out.println(+ medicos.size() + " médico(s) cadastrados.");
    }

    //Inserir paciente
    private static void inserirPaciente() {
        
    	if (totalPacientes >= 20) {
            System.out.println("Fila cheia.");
            return;
        }

        System.out.print("\nDigite o nome do paciente: ");
        String nome = sc.nextLine().trim();

        int prioridade = perguntarPrioridade();
        Paciente p = new Paciente(nome, prioridade);

        fila[totalPacientes] = p; 
        totalPacientes++;

        System.out.println("Paciente adicionado a fila:");
        p.mostrarInfo();
    }

    // Perguntar prioridade com perguntas simples
    private static int perguntarPrioridade() {
        
    	System.out.print("É urgente? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();
        if (resp.equals("s")) return 4;

        System.out.print("É grave? (s/n): ");
        resp = sc.nextLine().trim().toLowerCase();
        if (resp.equals("s")) return 3;

        System.out.print("É pouco grave? (s/n): ");
        resp = sc.nextLine().trim().toLowerCase();
        if (resp.equals("s")) return 2;

        return 1;
    }

    //Mostrar fila por prioridade
    private static void mostrarFilaPorPrioridade() {
        
    	System.out.println("\n		 FILA POR PRIORIDADE		");
        
    	if (totalPacientes == 0) {
            System.out.println("Nenhum paciente na fila.");
            return;
        }

        for (int i = 0; i < totalPacientes - 1; i++) {
            for (int j = 0; j < totalPacientes - 1 - i; j++) {
                if (fila[j].getPrioridade() < fila[j + 1].getPrioridade()) {
                    Paciente temp = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = temp;
                }
            }
        }
        
        // Mostrar pacientes
        for (int i = 0; i < totalPacientes; i++) {
            fila[i].mostrarInfo();
        }
    }

    //Pegar paciente de maior prioridade
    private static Paciente pegarProximo() {
        if (totalPacientes == 0) return null;

        int indice = 0;
        int maxPrior = fila[0].getPrioridade();

        for (int i = 1; i < totalPacientes; i++) {
            if (fila[i].getPrioridade() > maxPrior) {
                maxPrior = fila[i].getPrioridade();
                indice = i;
            }
        }
        return fila[indice];
    }

    //Remover paciente da fila
    private static void removerPaciente(Paciente p) {
    	if (p == null) return;

        int indice = -1;
        for (int i = 0; i < totalPacientes; i++) {
            if (fila[i] == p) {
                indice = i;
                break;
            }
        }

        if (indice >= 0) {
            for (int i = indice; i < totalPacientes - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[--totalPacientes] = null;
        }
    }
    
    //Atender proximo paciente
    private static void atenderProximoPaciente() {
        if (totalPacientes == 0) {
            System.out.println("Fila vazia!");
            return;
        }

        Paciente paciente = pegarProximo();
        if (paciente == null) return;

        // Próximo médico 
        Medico medico = medicos.get(indiceMedico);
        indiceMedico = (indiceMedico + 1) % medicos.size();

        paciente.registrarSaida(medico.getNome());
        historico.add(paciente);
        removerPaciente(paciente);

        System.out.println("\n Atendimento iniciado:");
        paciente.mostrarInfo();
    }

    //Mostrar histórico fila
    private static void mostrarHistorico() {
        System.out.println("\n--- HISTÓRICO DE ATENDIMENTOS ---");
    if (historico.isEmpty()) {
        System.out.println("Nenhum atendimento registrado.");
        return;
    }

    for (int i = 0; i < historico.size(); i++) {
        Paciente p = historico.get(i);
        p.mostrarInfo();
    }
}
}


