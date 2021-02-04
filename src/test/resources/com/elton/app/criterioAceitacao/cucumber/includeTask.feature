# language: pt_br  
# TASK - Aplicação de gerenciamento de Tarefas - 008

Funcionalidade: Incluir uma Task da aplicação
    Eu como usuário
    Desejo Incluir uma Task da aplicação
    A fim de manter a Task para futuros planos de ações da aplicação
		
		
	Esquema do Cenário: Incluir uma Task validando o preenchimento do nome da Task
    Dado uma Task em registro
    Quando informo o nome da Task <task>
    Quando tento salvar a Task
    Entao <resultado>
    Exemplos: considera espaços à esquerda e a direita
       | task                    | resultado                        |
       | "TASK 2015"             | A Task foi incluída com sucesso. |
       | "32323"                 | A Task foi incluída com sucesso. |
       | "INCLUSÃO task - 32323" | A Task foi incluída com sucesso. |
       | "C%¨&Ç^`^^^"            | A Task foi incluída com sucesso. |
     
     
    Esquema do Cenário: Incluir uma Task na aplicação validando regras de preenchimento 
 	Dado uma Task em registro
    E a informação obrigatória <informacao_obrigatoria> da task com o valor <valor>
    Quando tento salvar a Task
	Entao <resultado>
	Exemplos: considera espaços à esquerda e a direita
       | informacao_obrigatoria | valor              | resultado                        |
       | Name                   | ""                 | falha:Name is Required.          |
       | Name                   | " "                | falha:Name is Required.          |
       | Name                   | "TASK1"            | A Task foi incluída com sucesso. |
       | startDate              | ""                 | falha:Start Date is Required.    |
       | startDate              | " "                | falha:Start Date is Required.    |
       | startDate              | "15/05/1994"       | A Task foi incluída com sucesso. |
            
