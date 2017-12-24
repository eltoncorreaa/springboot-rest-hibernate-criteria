# language: pt_br  
# TASK - Aplicação de gerenciamento de Tarefas - 009

Funcionalidade: Alterar uma Task da aplicação
    Eu como usuário
    Desejo Alterar uma Task da aplicação
    A fim de manter a Task para futuros planos de ações da aplicação
		
	Esquema do Cenário: Alterar uma Task validando o preenchimento do nome da Task
    Dado uma Task cadastrada
    Quando informo o nome da Task <task>
    Quando tento alterar a Task
    Entao <resultado>
    Exemplos: considera espaços à esquerda e a direita
       | task                     | resultado                        |
       | "TASK 2015"              | A Task foi alterada com sucesso. |
       | "TASK    2015"           | A Task foi alterada com sucesso. |
       | "32323"                  | A Task foi alterada com sucesso. |
       | "ALTERação TASK - 32323" | A Task foi alterada com sucesso. |
       | "C%?&?^`^^^"             | A Task foi alterada com sucesso. |
       
    Esquema do Cenário: Alterar uma Task na aplicação validando regras de preenchimento
 	Dado uma Task cadastrada
    E a informação obrigatória <informacao_obrigatoria> da task tem seu valor alterado para o valor <valor>
    Quando tento alterar a Task
	Entao <resultado>
	Exemplos: considera espaços à esquerda e a direita
       | informacao_obrigatoria | valor        | resultado                        |
	   | Name                   | ""           | falha:Name is Required.          |
       | Name                   | " "          | falha:Name is Required.          |
       | Name                   | "TASK 1"     | A Task foi alterada com sucesso. |
       | startDate              | ""           | falha:Start Date is Required.    |
       | startDate              | " "          | falha:Start Date is Required.    |
       | startDate              | "15/05/2018" | A Task foi alterada com sucesso. |
       
    Cenário: Incluir uma Task validando desatualização de entidade lock otimista
 	Dado uma Task cadastrada
 	Quando tento alterar a task desatualizada
 	Entao falha:Entidade desatualizada, favor atualizar a página para concluir alteração.
 	