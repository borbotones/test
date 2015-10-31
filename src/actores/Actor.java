/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

import javax.swing.JLabel;

/**
 *
 * @author User1
 */
class Actor extends JLabel{
    public void transtadar(int tx, int ty){
        setLocation(getX()+tx,getY()+ ty);
    
    }
    
    public  void caminar(int tx){
        transtadar(tx, 0);
    }
    // true= derecha  false=izquierda
    public void caminar(boolean dire){
    if (dire)
        caminar(5);
    else 
        caminar(-5);
    }
    
}
