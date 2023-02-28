/*1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Automatico;
import model.Manual;
import java.util.Scanner;

/**
 *
 * @author Oivlis
 */
public class ProjectoProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner(System.in);
   
        int opcao = 0;
        while (opcao != 1 && opcao != 2) {
            System.out.println("1-Manual ou 2-Automático");
            opcao = leia.nextInt();
        }
        if (opcao == 1) {
           Manual modo = new Manual() ;
            modo.menu();
        } else {
           Automatico modo = new Automatico();
           modo.executarModoAutomatico();
        }
   
    }

}
