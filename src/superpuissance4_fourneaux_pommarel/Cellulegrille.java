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
    private boolean avoirtrounoir=false;
    private boolean avoirdesintegrateur=false;
    boolean jetonpresent=false;
    
    
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
     * @return 
     */
public String lirecouleurjeton(){
    String motcle="jaune";
    if (jetonCourant==null){
        motcle="vide";
    }
    return motcle;
}
public void placertrounoir(){
    avoirtrounoir=true;

}
public void supprimertrounoir(){
    avoirtrounoir=false;
    
}
/**
 * Permet de verifier la presence d'un trou noir en renvoyant un boolean
 * @return 
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
public void activertrounoir(){
    supprimerjeton();
    supprimertrounoir();
          
}
}
    
    

