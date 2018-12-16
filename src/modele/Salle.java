/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Rabelais
 */
public class Salle {
    String refSalle;
    float surface;
    String typeRevetement;

    public Salle(String refSalle, float surface, String typeRevetement) {
        this.refSalle = refSalle;
        this.surface = surface;
        this.typeRevetement = typeRevetement;
    }

    public String getRefSalle() {
        return refSalle;
    }

    public float getSurface() {
        return surface;
    }

    public String getTypeRevetement() {
        return typeRevetement;
    }

    @Override
    public String toString() {
        return refSalle;
    }
    
    
    
}
