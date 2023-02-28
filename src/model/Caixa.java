/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Oivlis
 */
public class Caixa {

    private int id;
    private int clienteAtendidos = 0;
    private double tempoTotalDeAtendimento = 0;
    private double tempoMedioPorCliente = 0;
    private double tempoDeAtendimento = 0;
    private ArrayList<Cliente> cliente = new ArrayList();
    private int tempoMaximoDeAtendimento = 15;

    //Este metodo é responsável por recalcular o tempo do elemento do topo, atendo o mesmo e sutraindo o seu tempo de atendimento durante esse processo
    public void atender(double tempoParaAtendimento, float tempoDeProduto, float intervaloMaximo) {
        if (!this.cliente.isEmpty()) {
            if (this.tempoDeAtendimento == 0) {
                chamarCliente(this.cliente.get(0), tempoDeProduto);
            }
            for (int i = 1; i <= (int) tempoParaAtendimento; i++) {
                this.tempoDeAtendimento -= 1;
                if (this.tempoDeAtendimento == 0) {
                    this.clienteAtendidos++;
                    calcularTempoAtendimentoDosClientes(this.cliente.get(0), tempoDeProduto, intervaloMaximo);
                    tempoMedioCliente(this.cliente.get(0));
                    removerCliente();
                    if (!this.cliente.isEmpty()) {
                        chamarCliente(this.cliente.get(0), tempoDeProduto);
                    }
                }
            }
            this.tempoDeAtendimento -= (tempoParaAtendimento - (int) tempoParaAtendimento);
            if (this.tempoDeAtendimento <= 0 && !this.cliente.isEmpty()) {
                this.clienteAtendidos++;
                calcularTempoAtendimentoDosClientes(this.cliente.get(0), tempoDeProduto, intervaloMaximo);
                tempoMedioCliente(this.cliente.get(0));
                removerCliente();
                if (!this.cliente.isEmpty()) {
                    chamarCliente(this.cliente.get(0), tempoDeProduto);
                }
            }
            if(this.cliente.isEmpty() )
                this.tempoDeAtendimento=0;
        }
    }

    //Este método é responsável por adicionar clientes na fila
    public void adicionarCliente(Cliente novoCliente) {
        this.cliente.add(novoCliente);
    }

    //Este método é responsável por calcular o tempo do elemento no topo. 
    public void chamarCliente(Cliente cliente, float tempoDeProduto) {
        if(this.tempoDeAtendimento<0)
            this.tempoDeAtendimento += (cliente.getNumeroDeProduto() * tempoDeProduto);
        else
            this.tempoDeAtendimento = (cliente.getNumeroDeProduto() * tempoDeProduto);

    }

    //Este método é responsável por mostrar os id's dos clientes
    public void verCliente() {
        for (Cliente clientes : this.cliente) {
            System.out.print(" <-------------------   |   Cliente " + clientes.getId() + "   | ");
        }
        System.out.println("");
    }

    //Este método é responsável por mostrar o número de produtos dos clientes
    public void verProdutos() {
        for (Cliente clientes : this.cliente) {
            System.out.print("                         |  produto/s " + clientes.getNumeroDeProduto() + " |");
        }
        System.out.println("");

    }

    //Este método é responsável por remover o primeiro elemento da fila dos clientes
    private void removerCliente() {
        this.cliente.remove(0);
    }

    //Este método é responsável por calcular tempo atendimento total
    private void calcularTempoAtendimentoDosClientes(Cliente cliente, float tempoDeProduto, float intervaloMaximo) {
        
        this.tempoTotalDeAtendimento += intervaloMaximo + (tempoDeProduto * cliente.getNumeroDeProduto());
    }

    //Este método é responsável por calcular tempo atendimento médio por cliente
    private double tempoMedioCliente(Cliente cliente) {

        this.tempoMedioPorCliente = this.tempoTotalDeAtendimento / this.clienteAtendidos;
        return this.tempoMedioPorCliente;

    }

    //Este método é responsável por retornar tempo atendimento do cliente no top
    public double getTempoDeAtendimento() {
        return tempoDeAtendimento;
    }

    //Este método é responsável por retornar o id da caixa;
    public int getId() {
        return id;
    }

    //Este método é responsável por retornar o número de clientes atendidos
    public int getClienteAtendidos() {
        return clienteAtendidos;
    }

    //Este método é responsável por retornar tempo total de atendimento  
    public double getTempoTotalDeAtendimento() {
        return tempoTotalDeAtendimento;
    }

    //Este método é responsável por retornar tempo atendimento médio por cliente 
    public double getTempoMedioPorCliente() {
        return tempoMedioPorCliente;
    }

    //Este método é responsável por retornar tempo máximo de atendimento
    public int getTempoMaximoDeAtendimento() {
        return tempoMaximoDeAtendimento;
    }

//Este método é responsável por retornar um ArrayList do tipo Cliente
    public ArrayList<Cliente> getCliente() {
        return this.cliente;
    }

    //Este método é responsável por modificar o número de clientes atendidos
    public void setClienteAtendidos(int clienteAtendidos) {
        this.clienteAtendidos = clienteAtendidos;
    }

    //Este método é responsável por modificar o tempo total de atendimento
    public void setTempoTotalDeAtendimento(double tempoTotalDeAtendimento) {
        this.tempoTotalDeAtendimento = tempoTotalDeAtendimento;
    }

    //Este método é responsável por modificar o tempo médio por cliente
    public void setTempoMedioPorCliente(double tempoMedioPorCliente) {
        this.tempoMedioPorCliente = tempoMedioPorCliente;
    }

    //Este método é responsável por modificar o tempo atendimento do cliente no top 
    public void setTempoDeAtendimento(double tempoDeAtendimento) {
        this.tempoDeAtendimento = tempoDeAtendimento;
    }

    //Este método é responsável por modificar o id da caixa
    public void setId(int id) {
        this.id = id;
    }
}
