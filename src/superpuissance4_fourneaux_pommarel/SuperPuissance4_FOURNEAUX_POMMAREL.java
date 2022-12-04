/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superpuissance4_fourneaux_pommarel;

/**
 *
 * @author Damien
 */
public class SuperPuissance4_FOURNEAUX_POMMAREL {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        
        joueur j1 = new joueur("quentin");
        joueur j2 = new joueur("damien");
        
        partie Partie = new partie(j1, j2);

        Partie.initialiserPartie();
        Partie.lancerPartie();
        
    }
    
}
