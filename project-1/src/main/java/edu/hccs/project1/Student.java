package edu.hccs.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Student {
    private int id;
    private String firstName;
    private String email;
    private String gender;
    @Autowired
    private CourseList courseList;

    public Student(int id, String firstName, String email, String gender, CourseList courseList) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.gender = gender;
        this.courseList = courseList;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CourseList getCourseList() {
        return courseList;
    }

    public void setCourseList(CourseList courseList) {
        this.courseList = courseList;
    }

    public int getPoint(String grade){
        int point = 0;
        for(Course course : courseList.getCourseList())
        {
            if(grade.trim().compareTo("A") == 0)
            {
                point = 4;
            }
            else if(grade.trim().compareTo("B") == 0)
            {
                point = 3;
            }
            else if(grade.trim().compareTo("C") == 0)
            {
                point = 2;
            }
            else if(grade.trim().compareTo("D") == 0)
            {
                point = 1;
            }
            else if(grade.trim().compareTo("F") == 0)
            {
                point = 0;
            }
        }
        return point;
    }

    public double calculateGPA(){
        int totalCreditHours = 0;
        int totalPoint = 0;
        double gpa = 0;
        if(courseList.getCourseList().isEmpty())
            return gpa =0 ;
        for(Course course : courseList.getCourseList())
        {
            totalCreditHours += course.getCreditHours();
            int point = getPoint(course.getGrade())*course.getCreditHours();
            totalPoint += point;
        }
        gpa = (double) totalPoint/totalCreditHours;
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", courseList=" + courseList +
                '}' +"\n";
    }
}
