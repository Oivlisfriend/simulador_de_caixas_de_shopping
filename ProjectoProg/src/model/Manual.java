/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Oivlis
 */
public class Manual extends Modo {
    
    //Este método é responsável por criar um menu para usuário;
    public void menu() {
        int opcao;
        float t;
        preencherParametrosIniciais();
        do {

            Scanner leia = new Scanner(System.in);
            System.out.println(
                    "1- Mostrar as filas das caixas\n"
                    + "2- Criar cliente\n"
                    + "3- Adicionar Caixa\n"
                    + "4- Retirar Caixa de atendimento\n"
                    + "5- Atender T tempo");
            opcao = leia.nextInt();
            switch (opcao) {
                case 1:
                    this.mostrarFilaDaCaixa();
                    break;
                case 2:
                    this.inserirClienteNoCaixa();
                    break;
                case 3:
                    this.adicionarCaixa();
                    break;
                case 4:
                    this.removerCaixa();
                    break;
                case 5:
                    if (!this.caixaVazio()) {
                        
                        System.out.print("Digite o tempo T: ");
                        t = leia.nextFloat();
                        this.atenderTTempo(t, true);
                    } else {
                        System.out.println("\nNão existe caixa, por este motivo não é possível fazer o atendimento em T tempo!\n");
                    }
                    break;

            }

        } while (opcao<= 5);
        
        this.gravarDadosDaSimulacao();
    }
    
    //Este método é responsável por saber se os parametros iniciais serão digitados ou iremos usar os por omissão ;
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
        }
       
        this.preecherViaFicheiro(LerFicheiro.actualizarCaixasPeloFicheiro());
    }

}
