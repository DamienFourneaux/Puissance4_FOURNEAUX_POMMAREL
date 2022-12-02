/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_fourneaux_pommarel;

import java.util.Random;

/**
 *
 * @author quent
 */
public class partie  {
    private joueur [] listeJoueurs;
    private joueur joueurCourant;
    private plateaudejeu plateau;
    public void partie (joueur j1,joueur j2){
        listeJoueurs[0]=j1;
        listeJoueurs[1]=j2;
    }
   public void attribuerCouleurAuxJoueurs(){
       Random n =new Random();
       int var=n.nextInt(2);
       if (var==0){
               listeJoueurs[0].affecterCouleur("jaune");
               listeJoueurs[1].affecterCouleur("rouge");
       }else{
               listeJoueurs[0].affecterCouleur("rouge");
               listeJoueurs[1].affecterCouleur("jaune");
       }
   }
public void créeretaffecterJeton(joueur j1){
    if("rouge"==j1.getCouleur()){
    for(int i=0;i<31;i++){
        Jeton stockjeton=new Jeton("rouge");
        j1.ajouterJeton(stockjeton);
    }
}
      if("jaune"==j1.getCouleur()){
    for(int i=0;i<31;i++){
        Jeton stockjeton=new Jeton("jaune");
        j1.ajouterJeton(stockjeton);
    }
}
}
}
