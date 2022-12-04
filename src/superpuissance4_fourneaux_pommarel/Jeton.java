package superpuissance4_fourneaux_pommarel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quent
 */
public class Jeton {
    private String couleur;
    
   public Jeton(String Couleur){
       couleur=Couleur;
       
   }
    public String lireCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Jeton{" + "couleur=" + couleur + '}';
    }
    
    
}
