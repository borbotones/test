/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User1
 */
public class Dinosaurio extends Actor implements Runnable {

    Thread hilo = null;

    public Dinosaurio() {

    }

    public void animar() {
        hilo = new Thread(this);
        hilo.start();
    }

    ImageIcon image[];
    int n;

    public void setImagen(String dire, String prefi, int an) {
        n = an;
        image = new ImageIcon[n];
        for (int i = 1; i <= n; i++) {
            image[i - 1] = new ImageIcon(getClass().getResource(dire + prefi + i + ".png"));

        }
        setIcon(image[0]);
        setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
        yi = getY();
    }

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < n - 1; i++) {

                caminar(true);
                setIcon(image[i]);
                int ancho = getParent().getWidth();
                if (getX() >= ancho) {

                    setLocation(0, getY());
                }

                if (salta) {
                    transtadar(0, -increY);
                    if (conta == 6) {
                        increY = -increY;
                    }
                    conta++;
                    if (getY() > yi) {
                        salta = false;
                        setLocation(getX(), yi);
                    }

                }
                if(getObstaculo()!=null&& choque(getObstaculo()))
                {
                    malos++;
                    if(getEtiqueta()!=null)
                        getEtiqueta().setText("Puntos Malos"+malos);
                    setIcon(image[5]);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dinosaurio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    int increY, conta, yi;
    boolean salta = false;
    int malos=0;

    public void saltar(int altu) {
        increY = altu / 5;
        salta = true;
        conta = 0;
       
    }
    
    public boolean choque(Actor otro){
        
        Rectangle dino= getBounds();
        Rectangle arbo=otro.getBounds();
        return dino.intersects(arbo);
    }
    
    private Actor obstaculo = null;

    /**
     * Get the value of obstaculo
     *
     * @return the value of obstaculo
     */
    public Actor getObstaculo() {
        return obstaculo;
    }

    /**
     * Set the value of obstaculo
     *
     * @param obstaculo new value of obstaculo
     */
    public void setObstaculo(Actor obstaculo) {
        this.obstaculo = obstaculo;
    }

    private JLabel etiqueta = null;

    /**
     * Get the value of etiqueta
     *
     * @return the value of etiqueta
     */
    public JLabel getEtiqueta() {
        return etiqueta;
    }

    /**
     * Set the value of etiqueta
     *
     * @param etiqueta new value of etiqueta
     */
    public void setEtiqueta(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

}
