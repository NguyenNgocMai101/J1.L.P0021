/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;
import java.util.*;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
        View view=new View();
        int choice;
        while(true){
            choice=view.showMenu();
            switch(choice){
                case 1:
                    view.create();
                    break;
                case 2:
                    view.findSort();
                    break;
                case 3:
                    view.updateDelete();
                    break;
                case 4:
                    view.report();
                    break;
                case 5: 
                    return;
            }
        }
    }
    
}
