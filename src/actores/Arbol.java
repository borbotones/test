/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User1
 */
public class Arbol extends Actor implements Runnable {

    Thread hilo = null;
    private String Imagen = null;

    public Arbol() {
        hilo = new Thread(this);
        hilo.start();
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
        setIcon(new ImageIcon(getClass().getResource(Imagen)));
        setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
    }

    @Override
    public void run() {
        while (true) {
            caminar(false);
            if(getX()<0)
            {
                int ancho=getParent().getWidth();
                setLocation(ancho, getY());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
