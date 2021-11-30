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
public class Validation {
    Scanner sc=new Scanner(System.in);
    
    int inputMenu(int index){
        int a=10;
        while(a!=5){
            try {
                a=sc.nextInt();
                if(a>index||a<=0)    throw new Exception();
                sc.nextLine();
                return a;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.err.println("Enter a number");
            }
            catch(Exception e){
                sc.nextLine();
                System.err.println("Enter a number in range [1-"+index+"]");
            }
        }
        return a;
    }
    
    boolean inputContCreate(){
        System.out.print("Do you want to continue (Y/N): ");
        while(true){
        String a=sc.nextLine();
            if(a.equalsIgnoreCase("Y")) return true;
            else if(a.equalsIgnoreCase("N"))    return false;
            else    System.err.print("Please Try again: ");
        }
    }
    
    String inputCourse(){
        String course="";
        while(true){
            course=sc.nextLine();
            if(course.equalsIgnoreCase("Java")
                    ||course.equalsIgnoreCase(".Net")
                    ||course.equalsIgnoreCase("C/C++"))   return course;
            else{
                System.err.println("This course doesn't exit");
                System.err.println("There are only three course: Java, .Net, C/C++");
                System.err.println("Enter again");
            }
        }
    }
    String inputCourseForUD(){
        String course="";
        while(true){
            course=sc.nextLine();
            if(course.equalsIgnoreCase("Java")
                    ||course.equalsIgnoreCase(".Net")
                    ||course.equalsIgnoreCase("C/C++")
                    ||course.equals(""))   return course;
            else{
                System.err.println("This course doesn't exit");
                System.err.println("There are only three course: Java, .Net, C/C++");
                System.err.println("Enter again");
            }
        }
    }
    String inputString(){
        String a=" ";
        while(true){
            a=sc.nextLine().trim();
            if(a.equals(""))    System.err.println("Please try again");
            else  return a;
        }
    }

    
    String inputUpAndDel(){
        System.out.println("Do you want to update (U) or delete (D) student?");
        while(true){
        String a=sc.nextLine();
            if(a.equalsIgnoreCase("U")||a.equalsIgnoreCase("D")) return a; 
            else    System.err.println("Please Try again");
        }        
    }


}
