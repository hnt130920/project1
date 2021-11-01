package edu.hccs.project1;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CourseList {

    private ArrayList<Course> courseList =  new ArrayList<>();

    public CourseList() {
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courseList=" + courseList +
                '}';
    }
}
