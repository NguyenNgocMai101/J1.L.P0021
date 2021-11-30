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
public class Manager {
    private ArrayList<Student> list=new ArrayList<>();
    
    public Manager(){
        list.add(new Student("1","A","Fall",".Net"));
        list.add(new Student("1","A","Summer","C/C++"));    
        list.add(new Student("2","B","Spring",".Net"));
        list.add(new Student("3","C","Fall","Java"));
        list.add(new Student("4","D","Spring","C/C++"));
        list.add(new Student("4","D","Summer","C/C++"));
        list.add(new Student("5","D","Spring","C/C++"));
        list.add(new Student("6","A","Spring",".Net"));
        list.add(new Student("7","E","Fall",".Net"));  
        list.add(new Student("8","F","Fall",".Net"));  
    }
    public void create(Student a){
        list.add(a);
    }
    public void sortStudent(ArrayList<Student> a){
        Collections.sort(a, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
            }
        });
    }
    
    public ArrayList<Student> getListFindAndSort(String name){
        ArrayList<Student> t=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getStudentName().toLowerCase().contains(name.toLowerCase())){
                t.add(list.get(i));
            }                
        }
        sortStudent(t);
        return t;
    }
    public void update(Student s,String name,String semester, String course){
        s.setSemester(semester);
        s.setCourseName(course);   
        s.setStudentName(name);  
    }
    
    public void delete(int i){
        list.remove(i);
    }
    
//list student by ID for user choose    
    public ArrayList getListStudentByID(String id){
        ArrayList<Student> idList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
                if(list.get(i).getId().equalsIgnoreCase(id))
                    idList.add(list.get(i));
        }
        return idList;
    }
    
//Get the index of student that user want to Update or Delete  
    public int getIndexStudentForUD(String id, int choice){
        int count=0;
        for(int i=0;i<list.size();i++){
             if(list.get(i).getId().equalsIgnoreCase(id)){
                count+=1;
                if(choice==count)   
                    return i;               
             }        
        }                   
        return choice;
    }
    
    public ArrayList<Report> getListReport(){
        ArrayList<Report> listReport=new ArrayList<>();
        int total;
        for(int i=0;i<list.size();i++){
            total=0;
            String id=list.get(i).getId();
            String course=list.get(i).getCourseName();
            for(Student k:list){
                if(list.get(i).getId().equalsIgnoreCase(k.getId())
                        &&course.equalsIgnoreCase(k.getCourseName()))  total+=1;
            }
            if(checkReport(listReport, id, course, total)){
                listReport.add(new Report(list.get(i).getStudentName(),course,id,total));
            }
        }
        return listReport;
    }
        
    public boolean checkReport(ArrayList<Report> a, String id, String course, int total){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getId().equalsIgnoreCase(id)
                    &&a.get(i).getCourse().equalsIgnoreCase(course)
                    &&a.get(i).getTotalCourse()==total)    
                return false;
        }
        return true;
    }
    public ArrayList<Student> getList(){
        return list;
    }
    
    public boolean checkDupStudent(Student b){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equalsIgnoreCase(b.getId())
                    &&list.get(i).getCourseName().equalsIgnoreCase(b.getCourseName())
                    &&list.get(i).getSemester().equalsIgnoreCase(b.getSemester())
                    &&list.get(i).getStudentName().equalsIgnoreCase(b.getStudentName())){ 
                return false;              
            }
        }
        return true;
    }
    
    public boolean checkValidStudent(String id, String name){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equalsIgnoreCase(id)
                    &&!list.get(i).getStudentName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkValidUpdateSt(String id, String name, int index){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId().equalsIgnoreCase(id)
                    &&!list.get(i).getStudentName().equalsIgnoreCase(name)
                    &&i!=index){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkDupStudentUD(Student b,int index){
        for(int i=0;i<list.size();i++){
            if(index!=i&&list.get(i).getId().equalsIgnoreCase(b.getId())
                    &&list.get(i).getCourseName().equalsIgnoreCase(b.getCourseName())
                    &&list.get(i).getSemester().equalsIgnoreCase(b.getSemester())
                    &&list.get(i).getStudentName().equalsIgnoreCase(b.getStudentName())){ 
                return false;              
            }
        }
        return true;
    }
}

