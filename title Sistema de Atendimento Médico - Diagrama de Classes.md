title Sistema de Atendimento Médico - Diagrama de Classes

' ===== CLASSES =====

class Paciente { 
  - Nome : String
  - Prioridade : Int
  - Médico da Consulta : String
  - Horário Entrada : LocalDateTime 
  - Horário Atendimento : LocalDateTime 
  + Paciente()
  + Mostrar Informação()
  + Registrar Horario Consulta()
  + Get Prioridade Descrição()
  + Get Name () : String
  + Get Prioridade ()
  + Get Horario Entrada ()
  + Get Medico Atendente ()
  + Get Horario Entrada Formatado()
  + Get Horario Consulta Formatado()
  + Set Nome()
}

class Medico {
  - Nome : String
  + Médico()
  + Get Name ()
  + Set Nome()
}

class Atendimento {
  - Pacientes : Array
  - Total de Pacientes : Int
  - Médicos List : Array
  - Histórico Fila List : Array 
  - Índice dos Médicos : Int
  + Main()
  - Mostrar Menu()
  - Ler Opção Menu()
  - Cadastrar Medicos Iniciais()
  - Inserir Paciente()
  - Perguntar Prioridade()
  - Mostrar Fila por Prioridade()
  - Pegar Próximo Paciente()
  - Remover Paciente()
  - Atender Próximo Paciente()
  - Mostrar Histórico da Fila()
  - horarioChegadaPaciente : LocalDateTime
  - horarioInicioAtendimento : LocalDateTime
  - horarioFimAtendimento : LocalDateTime
}

' ===== RELACIONAMENTOS =====
Medico "1" *-- "1..*" Atendimento (Pelo menos 1/ 1 ou varios.)
Paciente "0"--> "0..*" Atendimento (Pode 0/ 0 ou varios)
Paciente "1" <--> "1" Medico (Pode 0 // pelo menos 1)
Atendimento - depende de Medico
Paciente - depende de Atendimento
Paciente e Medico Associação
