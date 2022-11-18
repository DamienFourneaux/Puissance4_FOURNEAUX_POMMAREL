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
    
    
    public presencejeton (){
        if (jetonCourant!=null){
            
            return false;
        }
                    else {          
            return true;
        }
    }

    }
    

