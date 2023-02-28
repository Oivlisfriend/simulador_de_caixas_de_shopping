/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oivlis
 */
public class Automatico extends Modo {

    private float numeroAleatorio;
    private Scanner leia = new Scanner(System.in);
    
    //Este método é responsável por executar o modo automático;
    public void executarModoAutomatico() {
        int opcao = 0;
        preencherParametrosIniciais();
        do {        
            this.mostrarFilaDaCaixa();
            this.inserirClienteNoCaixa();
            gerarNumeroAleatorio();
             if (!this.caixaVazio()) {
                        this.atenderTTempo(numeroAleatorio, true);
                                     System.out.println(""+numeroAleatorio);

                    } else {
                        System.out.println("\nNão existe caixa, por este motivo não é possível fazer o atendimento em T tempo!\n");
                    }
            System.out.println("Se pretende para digite 1, caso não digite outro valor");
            opcao = leia.nextInt();
        } while (opcao != 1);
        this.gravarDadosDaSimulacao();

    }

    //Este método é responsável por gerar um numero aleatorio;
    public void gerarNumeroAleatorio() {
        Random round = new Random();
        this.numeroAleatorio = round.nextInt((int) (this.getIntervaloMaximo() - 1))+1;

    }

    private void preencherParametrosIniciais() {
        int resposta = 0;
        Scanner leia = new Scanner(System.in);
        while (resposta != 1 && resposta != 2) {
            System.out.println("Vai digitar os parametros iniciais?\n1-Sim ou 2-Não");
            System.out.print("R: ");
            resposta = leia.nextInt();
        }
        if (resposta == 1) {
            setTempoDeProduto(InserirTempoDeProduto());
            setNumeroDeCaixa(InserirNumeroDeCaixa());
            setIntervaloMaximo(InserirIntervaloMaximo());
        }

        this.preecherViaFicheiro(LerFicheiro.actualizarCaixasPeloFicheiro());
    }

    private float InserirIntervaloMaximo() {
        float tempo;
        do {
            System.out.println("Digite o intervalo de tempo máximo entre clientes: ");
            tempo = leia.nextFloat();
            if (tempo <= 0) {
                return 15;
            }
        } while (tempo < 0);
        return tempo;

    }

}
