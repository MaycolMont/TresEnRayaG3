/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tresenrayag3;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author maycmont
 */
public abstract class Publisher {
    private List<Suscriber> suscribers = new ArrayList<>();
    
    public void addSuscriber(Suscriber suscriber){
        suscribers.add(suscriber);
    }
    
    public void removeSuscriber(Suscriber suscriber) {
        if (!suscribers.contains(suscriber)) return;
        suscribers.remove(suscriber);
    }
    
    public void notifySuscribers() {
        for (Suscriber suscriber : suscribers) {
            suscriber.onNotify();
        }
    }
}
