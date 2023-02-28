/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oivlis
 */
public class LerFicheiro {
    //Este método é responsável por guardar os dados guardado no ficheiro em arraylist e retornar um vector;
    private static Caixa [] lerFicheiroPalavras() {
        Scanner ficheiro;
        int quantidadeCliente;
        String palavras;
        Caixa caixas = new Caixa();
        
        Cliente novoCliente = new Cliente();
        ArrayList<Caixa> caixa = new ArrayList();
        try {
            ficheiro = new Scanner(new File("Historico.txt"));
            while (ficheiro.hasNext()) {
                ficheiro.next();
                caixas.setId(Integer.parseInt(ficheiro.next()));
                ficheiro.next();
                quantidadeCliente=Integer.parseInt(ficheiro.next());
                ficheiro.next();
                caixas.setTempoDeAtendimento(Float.parseFloat(ficheiro.next()));
                ficheiro.next();
                caixas.setClienteAtendidos(Integer.parseInt(ficheiro.next()));
                ficheiro.next();
                caixas.setTempoTotalDeAtendimento(Float.parseFloat(ficheiro.next()));
                ficheiro.next();
                caixas.setTempoMedioPorCliente(Float.parseFloat(ficheiro.next()));
                for(int i=0;i<quantidadeCliente;i++){                                        
                    ficheiro.next();
                    novoCliente.setId(Integer.parseInt(ficheiro.next()));
                    ficheiro.next();
                    novoCliente.setNumeroDeProduto(Integer.parseInt(ficheiro.next()));
                    caixas.adicionarCliente(novoCliente);
                }
                caixa.add(caixas);
                caixas=new Caixa();
            }
            ficheiro.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return (Caixa[]) caixa.toArray(new Caixa[caixa.size()]);
    }
     //Este método é auxiliar do lerFicheiroPalavras() é responsável por retornar vector;
    public static Caixa [ ]actualizarCaixasPeloFicheiro(){
        return lerFicheiroPalavras();
    }
}
