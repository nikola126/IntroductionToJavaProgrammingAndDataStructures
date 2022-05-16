package com.programming.java.IntroductionToJavaNakov.ch14_Classes.school;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolTest {
    private School school;
    private SchoolClass schoolClass;
    private List<Teacher> teacherList;

    public SchoolTest() {
        Student student1 = new Student("Nikola", 1L);
        Student student2 = new Student("Yordan", 2L);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        Discipline discipline1 = new Discipline("Math", 10, 10);
        Discipline discipline2 = new Discipline("Physics", 8, 8);

        List<Discipline> disciplineList = new ArrayList<>();
        disciplineList.add(discipline1);
        disciplineList.add(discipline2);

        Teacher teacher1 = new Teacher("Atanas", disciplineList);
        Teacher teacher2 = new Teacher("Boris", disciplineList);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        SchoolClass schoolClass = new SchoolClass(teacherList, 1);

        School school = new School(disciplineList, studentList);

        System.out.println("School");
        System.out.println(school);

        System.out.println("School class");
        System.out.println(schoolClass);

        System.out.println("Teachers");
        System.out.println(teacherList);

        this.school = school;
        this.schoolClass = schoolClass;
        this.teacherList = teacherList;
    }
}
