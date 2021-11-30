/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author DELL
 */
public class View {
    Validation val=new Validation();
    Manager mana=new Manager();
    Scanner sc=new Scanner(System.in);
    
    public int showMenu(){
        System.out.println("==========WELCOME TO STUDENT MANAGEMENT==========");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please input your choice: ");
        int choice=val.inputMenu(5);
        return choice;
    }
    
    void create(){
        while(true){        
            System.out.println("==========Create==========");
            int count=mana.getList().size();
            if(count>=10){
                if(val.inputContCreate()==false)  break;
            }
            String id,studentName,semester,courseName;
            System.out.print("Enter the student's id: ");
            id=val.inputString();
            System.out.print("Enter the student's Name: ");
            studentName=val.inputString(); 
            if(mana.checkValidStudent(id, studentName)){
                System.out.print("Enter the student's Semester: ");
                semester=val.inputString();
                System.out.print("Enter the student's Course: ");
                courseName=val.inputCourse();
                Student b=new Student(id, studentName, semester, courseName);
                if(mana.checkDupStudent(b))    mana.create(b);
                else    System.err.println("Student already exists"); 
            } 
            else    System.err.println("Same ID but different name, try again");   
        }
        display(mana.getList());
    }
    
    void findSort(){
        System.out.println("==========Find and Sort==========");
        if(mana.getList().isEmpty())  System.out.println("Empty List");
        else{
            String name;
            System.out.print("Enter the student's Name: "); 
            name=sc.nextLine();
            ArrayList<Student> st=mana.getListFindAndSort(name);
            if(st.isEmpty())    System.err.println("This student does not exist");
            else    display(st);
        }
    }
    
    void updateDelete(){
        System.out.println("==========Update/Delete==========");
        if (mana.getList().isEmpty()) System.out.println("Empty list");
        else{
            String id;
            System.out.print("Enter the student's id: ");
            id = val.inputString();
            ArrayList<Student> idList = mana.getListStudentByID(id);
            if (idList.isEmpty())     System.err.println("This student does not exist");
            else {
                display(idList);
                String choice = val.inputUpAndDel();
                System.out.print("Chose a student that you want to change: ");
                int choi=val.inputMenu(idList.size());
                int index=mana.getIndexStudentForUD(id, choi);
                Student s = mana.getList().get(index);
                if(choice.equalsIgnoreCase("D"))    mana.delete(index);
                else{
                    while(true){
                        //System.out.print("Enter the student's id: ");
//                        String id1=val.inputString();
                        String id1=s.getId();
                        System.out.print("Enter the student's Name: ");
//                        String name=val.inputString();
                        String name=sc.nextLine();
                        if(name.equals(""))     name=s.getStudentName();
                        if(mana.checkValidUpdateSt(id1, name, index)){
                            System.out.print("Enter the student's Semester: ");
//                            String semester=val.inputString();
                            String semester=sc.nextLine();
                            if(semester.equals(""))     semester=s.getSemester();
                            System.out.print("Enter the student's Course: ");
                            String course=val.inputCourseForUD();
                            if(course.equals(""))   course=s.getCourseName();
                            Student b=new Student(id1, name, semester, course);
                            if(mana.checkDupStudentUD(b,index)){
                                mana.update(s,name, semester, course);
                                System.out.println("Successfully");
                                display(mana.getList());
                                break;
                            }
                            else{
                                System.err.println("Student already exists");
                            }        
                        }
                        else{
                            System.err.println("Same ID but different name, try again");
                        }
                    }                 
                }
            }
        }
    }   

    void report(){
        System.out.println("==========Report==========");
        if(mana.getList().isEmpty())  System.out.println("Empty list");
        else{
            displayReport(mana.getListReport());
        }
    }

    void display(ArrayList<Student> list){
        System.out.printf("%-10s%-10s%-20s%-20s%-20s\n","STT","ID", "Student", "Semester", "Course Name");
        for(int i=0;i<list.size();i++){
            System.out.printf("%-10d%-10s%-20s%-20s%-20s\n",
                    i+1,
                    list.get(i).getId(),
                    list.get(i).getStudentName(),
                    list.get(i).getSemester(),
                    list.get(i).getCourseName());
        }
    }
    
    void displayReport(ArrayList<Report> list){
        System.out.printf("%-30s%-30s%-30s\n", "Student Name", "Course", "Total Course");
        for(int i=0;i<list.size();i++){
            System.out.printf("%-30s%-30s%-30s\n",
                    list.get(i).getStudentName(),
                    list.get(i).getCourse(),
                    list.get(i).getTotalCourse());
        }
    }
    
    
}
