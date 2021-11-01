package edu.hccs.project1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class StudentList {
    private ArrayList<Student> listStudents = new ArrayList();

    public StudentList() {
    }

    public void addStudent(Student st){
        listStudents.add(st);
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public ArrayList<Student> searchName(String name){
        ArrayList <Student> listSearch = new ArrayList<>();
        for(int i = 0; i < listStudents.size(); i++)
        {
            if(name.trim().equalsIgnoreCase(listStudents.get(i).getFirstName()))
            {
                listSearch.add(listStudents.get(i));
            }
        }
        return listSearch;
    }

    public ArrayList<Student> searchCourseNo(String courseNo){
        ArrayList <Student> listSearch = new ArrayList<>();
        for(int i = 0; i < listStudents.size(); i++)
        {
            for(int j = 0; j < listStudents.get(i).getCourseList().getCourseList().size(); j++)
            {
                if(courseNo.trim().equalsIgnoreCase(listStudents.get(i).getCourseList().getCourseList().get(j).getCourseNo()))
                {
                    listSearch.add(listStudents.get(i));
                }
            }

        }
        return listSearch;
    }
}

