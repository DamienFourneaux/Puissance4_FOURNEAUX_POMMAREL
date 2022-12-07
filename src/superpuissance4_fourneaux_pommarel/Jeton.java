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

    /**
     *Accesseur lecture
     * @return couleur (R ou J)
     */
    public String lireCouleur() { 
        return couleur;
    }

    /**
     * Méthode toString qui permet de renvoyer un texte formaté.
     * @return
     */
    @Override
    public String toString() {
        return "Jeton{" + "couleur=" + couleur + '}';
    }
    
    
}
