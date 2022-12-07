/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_fourneaux_pommarel;

import superpuissance4_fourneaux_pommarel.Jeton;

/**
 *
 * @author quent
 */
public class Cellulegrille {
    private Jeton jetonCourant= null;
    private boolean avoirtrounoir=false; //Les variables sont en private pour être utilisées uniquement dans cette classe 
    private boolean avoirdesintegrateur=false;
    boolean jetonpresent=false;
    
    /**
     * Permet de savoir si un jeton est présent sur la case ou pas
     * @return true or false
     */
    public boolean presencejeton (){ 
        boolean Presencejeton = false;
        if (jetonCourant!=null){
             Presencejeton=true;
        }
            return Presencejeton;

    }

    public Jeton getJetonCourant() {
        return jetonCourant;
    }
    
    /**
     * Permet de savoir si il y a un jeton dans une case 
     * et si il y en a un dis la couleur de celui-ci
     * @return rouge or jaune
     */
public String lirecouleurjeton(){
    if (presencejeton() == true){
        return jetonCourant.lireCouleur();
    }else{
        return "vide";
    }
}

    /**
     * Permet de placer un trou noir sur une case
     */
    public void placertrounoir(){
    avoirtrounoir=true;

}

public void ajouterjeton(Jeton jt){
    jetonCourant = jt;
}
public void supprimertrounoir(){
    avoirtrounoir=false;
    
}
/**
 * Permet de verifier la presence d'un trou noir en renvoyant un boolean
 * @return boolean 
 */
public boolean presencetrounoir(){
    return avoirtrounoir;
    }
/**
 * Permet de recuperer un jeton en atttribuant la valeur null
 * a jetoncourant et de renvoyer l'ancienne valeur de jetoncourant
 * @return 
 */
public Jeton recupererjeton(){
    Jeton stockjetcourant;
    stockjetcourant=jetonCourant;
    jetonCourant=null;
        
    return stockjetcourant;
}
public void supprimerjeton(){
    jetonCourant=null;
}
public boolean presencedesintegrateur(){
    return avoirdesintegrateur;
}
public void placerdesintegrateur(){
    avoirdesintegrateur=true;
}
public void supprimerdesintegrateur(){
    avoirdesintegrateur=false;
}

    /**
     *Active le trou noir, supprime le jeton sur la case du trou noir
     */
    public void activertrounoir(){
    supprimerjeton();
    supprimertrounoir();
          
}
}
    
    

