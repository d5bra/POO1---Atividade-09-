title Sistema de Atendimento Médico - Diagrama de Classes

' ===== CLASSES =====

class Paciente { 
  private - Nome : String 
  private - Prioridade : Int
  private - Médico da Consulta : String
  private - Horário Entrada : LocalDateTime 
  private - Horário Atendimento : LocalDateTime 
  public  + Paciente()
  public  + Mostrar Informação()
  public  + Registrar Horario Consulta()
  public  + Get Prioridade Descrição()
  public  + Get Name () : String
  public  + Get Prioridade ()
  public  + Get Horario Entrada ()
  public  + Get Medico Atendente ()
  public  + Get Horario Entrada Formatado()
  public  + Get Horario Consulta Formatado()
  public  + Set Nome()
}

class Medico {
 private - Nome : String
 public  + Médico()
 public  + Get Name ()
 public  + Set Nome()
}

class Atendimento {
 private  - Pacientes : Array
 private  - Total de Pacientes : Int
 private  - Médicos List : Array
 private  - Histórico Fila List : Array 
 private  - Índice dos Médicos : Int
 public  + Main()
 private  - Mostrar Menu()
 private  - Ler Opção Menu()
 private  - Cadastrar Medicos Iniciais()
 private  - Inserir Paciente()
 private  - Perguntar Prioridade()
 private  - Mostrar Fila por Prioridade()
 private  - Pegar Próximo Paciente()
 private  - Remover Paciente()
 private  - Atender Próximo Paciente()
 private  - Mostrar Histórico da Fila()
 private  - horarioChegadaPaciente : LocalDateTime
 private  - horarioInicioAtendimento : LocalDateTime
 private  - horarioFimAtendimento : LocalDateTime
}

' ===== RELACIONAMENTOS =====
Medico "1" *-- "1..*" Atendimento (Pelo menos 1/ 1 ou varios.)
Paciente "0"--> "0..*" Atendimento (Pode 0/ 0 ou varios)
Paciente "1" <--> "1" Medico (Pode 0 // pelo menos 1)
Atendimento - depende de Medico
Paciente - depende de Atendimento
Paciente e Medico Associação
