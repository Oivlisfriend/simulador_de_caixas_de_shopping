/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Oivlis
 */
public class EscreverFicheiro {
    
    //Este método é responsável por gravar os dados da simulação no ficheiero Historico.txt;
    private static void gravarTexto(String coordenadasPalavras, boolean estaVazio) {

        PrintWriter escreverMensagemTexto;


        File fich = new File("Historico.txt");
        try {
            escreverMensagemTexto = new PrintWriter(new FileWriter(fich, estaVazio));
            escreverMensagemTexto.print(coordenadasPalavras);
            escreverMensagemTexto.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    //Este método é responsável por juntar toda informação de um determinado caixa e guardar;
    public static void manipulacaoDosDados(Caixa[] caixa) {
        String manipularPalavras;
        gravarTexto("",false);
        for (Caixa caixas : caixa) {
            manipularPalavras = "Caixa " + caixas.getId() + " Clientes_na_fila: " + caixas.getCliente().size() + " Tempo_restante_para_atender_cliente_topo: " + caixas.getTempoDeAtendimento() + " Clientes_atendidos: " + caixas.getClienteAtendidos() + " Tempo_total_atendimento: " + caixas.getTempoTotalDeAtendimento() + " Tempo_medio_de_atendimento: " + caixas.getTempoMedioPorCliente();
            for (Cliente cliente : caixas.getCliente()) {
                manipularPalavras += " Cliente: " + cliente.getId() + " Produto: " + cliente.getNumeroDeProduto();
            }
            gravarTexto(manipularPalavras+"\r\n",true);
            manipularPalavras=" ";
            System.out.println(manipularPalavras);
        }

    }
}
