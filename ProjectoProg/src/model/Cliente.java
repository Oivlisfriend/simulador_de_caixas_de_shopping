/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oivlis
 */
public class Cliente {
    private int id;
    private int numeroDeProduto;
    //Este método é responsável por retornar o id do cliente;
    public int getId() {
        return id;
    }
    
    //Este método é responsável por retornar o número de produto do cliente;
    public int getNumeroDeProduto() {
        return numeroDeProduto;
    }
    
    //Este método é responsável por modificar o id do cliente;
    public void setId(int id) {
        this.id = id;
    }
    
    //Este método é responsável por modificar o número de produto do cliente;
    public void setNumeroDeProduto(int numeroDeProduto) {
        this.numeroDeProduto = numeroDeProduto;
    }
}
