Basicamente uma expressão ------ e um dicionario (hashmap) de string e double (EXEMPLO: x, 2)

A partir da String recebida calcular hascode para identificar se existe ou nao a expressao

1 Classe base com metodo calcule
2 copiar e alterar nome (nome seria numero do hash?)e adicionar doubles e alterar return
3 Carregar classe x
4 Criar uma instancia via reflexao, definir o valor das variaveis e chamar o metodo calcula
5 Referenciar a instancia

Salvar todas as expressoes em disco, pois se ficar na memoria e ter que compilar denovo perde desempenho


Descrição do módulo:
Avaliação de expressões matemáticas só conhecidas em tempo de execução, mas posteriormente reutilizada inúmeras vezes, possivelmente ao longo de meses e anos. Neste caso, a expectativa é que a expressão possa ser compilada para bytecodes, em tempo de execução, oferecendo um ganho em desempenho. Nesta proposta, a biblioteca ASM deve ser utilizada.

Requisitos:
R1 - Uma expressão matemática deve ser recebida como uma sequência de caracteres e os valores associados as variáveis da mesma.
R2 - A expressão matemática recebida deve ser avaliada com finalidade de verificar se a mesma foi utilizada anteriormente ou não, e caso não utilizada, deve ser convertida para bytecodes através da biblioteca ASM e armazenada para ser reutilizada posteriormente.
Observação: O uso da biblioteca ASM é uma restrição imposta ao desenvolvimento do módulo.
R3 - A expressão matemática está restrita a valores numéricos (tipo Double em Java).
R4 - A expressão matemática deverá ter um identificador ao ser armazenada, para que com este seja chamada posteriormente para uma execução.

Design:
1 - Deve-se criar uma classe Main aonde será executado o código para receber os dados da expressão.
2 - Deve-se criar uma classe base ExpBase com o método calcule() que retorna um double.
3 - Ao ser recebida uma expressão se deve calcular o hashcode da mesma para verificar se a expressão já foi passada anteriormente ou não.
4 - Caso a expressão recebida nunca tenha sido utilizada, deve ser usada a biblioteca ASM para copiar a classe ExpBase e alterar o retorno do método calcule() para que siga as especificações da expressão. Feito isso, deve ser alterado o nome da nova classe para Exp###, aonde ### é o número do hashcode da expressão.
5 - Caso a expressão recebida tenha sido utilizada, deve ser usado o Java Reflection para criar uma instância da mesma e chamar o método calcule() passando os valores (double) a serem utilizados naquela expressão.
6 - As expressões convertidas para bytecode devem ser armazenadas em disco para que possam ser acessadas posteriormente para serem reutilizadas.


-------------------------------------------------------------------------------------------------------

Olhar classe do professor (Diretorio parser, classe Gerador). La tem uso do ASM explicado. 
Sobre o design a grosso modo fica:
receber a expressao como string
criar classe dinamicamente utilizando Gerador do professor
criar metodo pelo Gerador tbm
utilizar compilador pra transformar de in-fix para post-fix (ou seja (x+y)*200    ->   xy+200*)
Pegar esse post-fix e transformar em instruções (explicado no Gerador tbm)
Se atentar a ordem de uso das variaveis (Pense em como implementar, por ordem de chegada não é bom... uma ideia seria armazenar elas primeiramente e apos isso executar a expressao para ter os valores salvos -> armazenar quantas vezes precisar no caso, pois quando precisar sera usada)
DETALHE IMPORTANTE a classe devera se chamar C####.java aonde o #### é o número do hashcode 
criar classe main que chama por reflexao a classe especifica (chama sempre baseado no hashcode da expressao, se existe chama. Se nao, cria e depois chama)
Enviar variaveis da expressao por hashmap????
