# simulador_de_caixas_de_shopping

# 1. Objectivos
O objetivo do trabalho é desenvolver uma aplicação para gerir filas de supermercado. As filas de 
supermercado têm a seguinte representação esquemática:

![Captura de Ecrã (783)](https://user-images.githubusercontent.com/89141127/222217975-fe90f073-4f2f-4bdc-a782-74501c4925dd.png)

### Cada caixa possui os seguintes campos: 
- Identificador da caixa; 
- Número de clientes em fila; 
- Número de clientes atendidos desde a abertura da caixa; 
- Tempo total de atendimento dos clientes desde a abertura da caixa; 
- Tempo médio de atendimento por cliente desde a abertura da caixa; 

### Cada cliente possui os seguintes dados: 
- Identificador do cliente; 
- Número de produtos carregados para o carrinho de compras;

O programa deverá incluir um modo de funcionamento manual e um modo de funcionamento 
automático, perguntando ao utilizador como deseja fazer a simulação.

# 1.1. Modo Manual

No início de uma simulação manual o programa pergunta ao utilizador os seguintes 
parâmetros, que não poderão variar durante a simulação: 

- Tempo de atendimento de um produto, considerando por omissão o valor de 5 segundos;
- Número de caixas no início da simulação, considerando por omissão 4; 
No modo de funcionamento manual o programa deve construir um menu que permita ao utilizador 
as seguintes operações:

## 1.1.1.Mostrar as filas das caixas
O programa deve mostrar em modo de texto a lista de caixas e as respetivas filas, usando uma 
representação em texto que simule o diagrama acima apresentado.

## 1.1.2. Criar cliente
Esta opção deve criar um cliente, o que implica as seguintes operações: 

- Geração aleatória da quantidade de produtos que ele vai guardar no carrinho. Essa 
quantidade será um valor entre 2 e 120 unidades; 
- O cliente é colocado na fila da caixa que tem menor número de clientes em espera. Para 
esta atribuição não interessa o número de produtos que estão nos carrinhos de compra, 
mas sim apenas a contagem de clientes que estão na fila; 
- Se o cliente for o primeiro da fila deve atualizar o contador da caixa que guarda o Tempo 
Restante para Atender o Cliente de Topo. Este valor é calculado tendo em conta o número 
de produtos que estão no carrinho de compras e o tempo de atendimento de cada 
produto; 

## 1.1.3.Adicionar Caixa
Permite adicionar uma nova caixa de atendimento de clientes, que será inicializada com a fila
vazia.

## 1.1.4.Retirar Caixa de atendimento
Percorre toda a lista de caixas e retira as que não tiverem clientes em fila.

## 1.1.5.Atender T tempo
Pede ao utilizador um valor de tempo de atendimento (T). Em seguida percorre todas as caixas 
para atender T segundos. Em cada caixa deve subtrair T segundos ao contador da caixa que indica o 
tempo que falta para atender o cliente do topo da fila e ter em conta o seguinte: 
- Se T for inferior ao tempo de atendimento deve atualizar o contador de tempo total de 
atendimento da caixa e retirar valor ao tempo de atendimento do cliente; 
- Se T for igual ao tempo de atendimento deve retirar o cliente do topo da fila, atualizar o 
contador de clientes atendidos, atualizar o contador total de tempo da caixa, assim 
como recalcular o tempo médio de atendimento de um cliente; 
- Se T for superior ao tempo de atendimento deve: 
  o Executar as operações descritas no ponto anterior referentes ao atendimento 
  de um cliente; 
  o Considerar como novo valor de T o que sobra e repetir a operação de atender T 
  tempo; 

# 1.2. Modo automático
No início de uma simulação automática o programa pergunta ao utilizador os seguintes 
parâmetros, que não poderão variar durante a simulação:

- Tempo de atendimento de um produto, considerando por omissão os 5 segundos; 
- Número de caixas no início da simulação, considerando por omissão 4; 
- Intervalo de tempo máximo entre clientes, considerando por omissão 15 segundos; 
- Neste modo o programa executa as operações descritas no modo manual seguindo uma 
sequência, parando quando o utilizador indicar fim.
Mostra as filas das caixas; 
- Gera um número aleatório X entre 1 e o intervalo de tempo máximo entre clientes; 
- Cria um cliente; 
- Atende X tempo; 

