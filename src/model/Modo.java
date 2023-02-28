/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import file.EscreverFicheiro;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oivlis
 */
public abstract class Modo {

    private float tempoDeProduto;
    private int numeroDeCaixa;
    private float intervaloMaximo;
    private Caixa caixa[];
    private Scanner leia = new Scanner(System.in);

    //Este constructor é responsável por iniciliazar alguns atributos;
    public Modo() {
        this.tempoDeProduto = 5;
        this.numeroDeCaixa = 4;
        this.intervaloMaximo = 15;
        inicializarCaixa(numeroDeCaixa);
        instanciar();

    }

    //Este método é responsável por adicionar novos caixas;
    public void adicionarCaixa() {
        Caixa auxiliar[] = this.caixa;
        this.numeroDeCaixa++;
        this.caixa = new Caixa[this.numeroDeCaixa];
        instanciar();
        this.caixa[this.caixa.length - 1].setId(this.caixa.length - 1);
        for (int i = 0; i < auxiliar.length; i++) {
            this.caixa[i] = auxiliar[i];
        }
    }

    //Este método é responsável por retornar verdadeiro se o vrctor de caixa estiver vazio e false se não estiver;
    public boolean caixaVazio() {
        return this.caixa.length == 0;
    }

    //Este método é responsável por guardar os dados da simulação;
    public void gravarDadosDaSimulacao() {
        EscreverFicheiro.manipulacaoDosDados(this.caixa);
    }

    //Este método é responsável por retornar verdadeiro se a fila do caixa estiver vazia e false se não estiver;
    public boolean caixaFilaVazia(Caixa caixa) {
        return caixa.getCliente().isEmpty();
    }

    //Este método é responsável por retornar a posicao do caixa mais adequado para inserir um cliente;
    private int escolherCaixa() {
        int posicao = 0;
        for (int i = 1; i < this.caixa.length; i++) {
            if (this.caixa[i].getCliente().size() < this.caixa[posicao].getCliente().size()) {
                posicao = i;
            }
        }
        return posicao;
    }

    //Este método é responsável por retornar os dados de um cliente;
    private Cliente inserirDadosDoCliente(int posicao) {
        Cliente cliente = new Cliente();
        Random aleatoria = new Random();
        cliente.setId(this.caixa[posicao].getCliente().size() + 1);
        cliente.setNumeroDeProduto(aleatoria.nextInt(118) + 2);
        return cliente;

    }

    //Este método é responsável por inserir um cliente em um determinado caixa;
    public void inserirClienteNoCaixa() {
        if (!caixaVazio()) {
            int posicao = escolherCaixa();
            this.caixa[posicao].adicionarCliente(inserirDadosDoCliente(posicao));
            
            if( this.caixa[posicao].getTempoDeAtendimento()==0)actulizarCaixas();
        } else {
            System.out.println("\nNão existe caixa para adicionar o cliente em uma fila!\n");
        }
    }

    //Este método é responsável por remover caixa;
    public void removerCaixa() {
        if (!caixaVazio()) {

            Caixa auxiliar[] = this.caixa;
            int quantidadeRemover = 0;
            int i = 0;
            for (Caixa caixas : auxiliar) {
                if (caixas.getCliente().isEmpty()) {
                    quantidadeRemover++;
                }
            }
            this.numeroDeCaixa -= quantidadeRemover;
            if (quantidadeRemover > 0) {
                this.caixa = new Caixa[this.numeroDeCaixa];
                for (Caixa caixas : auxiliar) {
                    if (!caixas.getCliente().isEmpty()) {
                        this.caixa[i++] = caixas;
                    }
                }
            } else {
                System.out.println("\nTodos os caixas têm filas, logo não é possível remover!\n");
            }

        } else {
            System.out.println("\nNão existe caixa, logo não é possível remover!\n");
        }
    }

    //Este método é responsável por atender T tempo;
        public void atenderTTempo(float t) {
        for (int i = 0; i < this.caixa.length; i++) {
            caixa[i].atender(t, this.getTempoDeProduto(), this.intervaloMaximo);

        }

    }

    //Este método é responsável por instânciar cada posição do vector e colocar os respectivos id's;
    public void instanciar() {
        for (int i = 0; i < this.caixa.length; i++) {
            caixa[i] = new Caixa();
            caixa[i].setId(i + 1);

        }
    }

    //Este método é responsável mostrar na tela os caixas e as suas respectivas filas;
    public void mostrarFilaDaCaixa() {
        int i = 1;
        for (Caixa caixas : this.caixa) {
            System.out.println("                ");
            System.out.println("|-----------------------------------------------|");
            System.out.println("|               Caixa  00" + i + "                      | ");
            System.out.println("|            Clientes na fila: " + caixas.getCliente().size() + "                |");

            System.out.print("|Tempo restante para atender cliente topo: " + caixas.getTempoDeAtendimento() + "s |");
            caixas.verCliente();
            System.out.print("|          Clientes atendidos:  " + caixas.getClienteAtendidos() + "               |");
            caixas.verProdutos();
            System.out.println("|        Tempo total atendimento: " + caixas.getTempoTotalDeAtendimento() + "           |");
            System.out.println("|        Tempo médio de atendimento: " + caixas.getTempoMedioPorCliente() + "        |");

            i++;
            System.out.println("|-----------------------------------------------|");
            System.out.println("");
        }
    }

    //Este método é responsável por retornar o tempo de atendimento de cada produto digitado pelo usuário;
    public float inserirTempoDeProduto() {
        float tempo;
        do {
            System.out.println("Digite o tempo de atendimento de um produto: ");
            tempo = leia.nextFloat();
            if (tempo <= 0) {
                return 5;
            }
        } while (tempo < 0);
        return tempo;
    }

    //Este método é responsável por retornar  o número de caixas digitado pelo usuário;
    public int inserirNumeroDeCaixa() {
        int numeroCaixa;
        do {
            System.out.println("Digite o número de caixas no início da simulação: ");
            numeroCaixa = leia.nextInt();
            if (numeroCaixa <= 0) {
                return 4;
            }
        } while (numeroCaixa < 0);
        return numeroCaixa;
    }

    //Este método é responsável por inicializar o vector caixa ;
    public void inicializarCaixa(int tamanho) {
        this.caixa = new Caixa[tamanho];
    }

    //Este método é responsável por actulizar cada tempo de atendimento do cliente no topo, de todos os caixas;
    private void actulizarCaixas() {
        for (int i = 0; i < this.caixa.length; i++) {
            if (!caixa[i].getCliente().isEmpty()) {
                caixa[i].chamarCliente(caixa[i].getCliente().get(0), this.getTempoDeProduto());
            }

        }

    }

    //Este método é responsável por carregar os dados guardados no ficheiro;
    public void preecherViaFicheiro(Caixa actulizarCaixa[]) {
        if (actulizarCaixa.length > 0) {
            this.caixa = actulizarCaixa;
        }
    }

    //Este método é responsável por modificar o número de caixas;
    public void setNumeroDeCaixa(int numeroDeCaixa) {
        this.numeroDeCaixa = numeroDeCaixa;
        inicializarCaixa(numeroDeCaixa);
        instanciar();
    }

    //Este método é responsável por modificar o tempo de atendimeto de um produto;
    public void setTempoDeProduto(float tempoDeProduto) {
        this.tempoDeProduto = tempoDeProduto;
    }

    //Este método é responsável por modificar o intervalo máximo;
    public void setIntervaloMaximo(float intervaloMaximo) {
        this.intervaloMaximo = intervaloMaximo;
    }

    //Este método é responsável por retornar um vector de caixas;
    public Caixa[] getCaixa() {
        return caixa;
    }

    //Este método é responsável por retornar o tempo de atedimento de um produto;
    public float getTempoDeProduto() {
        return tempoDeProduto;
    }

    //Este método é responsável por retornar o número de caixa;
    public int getNumeroDeCaixa() {
        return numeroDeCaixa;
    }

    //Este método é responsável por retornar O intevelo máximo;
    public float getIntervaloMaximo() {
        return intervaloMaximo;
    }

}
