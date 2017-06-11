package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();

    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        for (int i = 0; i < students.size(); i++)
        {
            Student student = students.get(i);
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {

        Student resultedStudent = null;
        double maxAverageGrade = 0;
        for (int i = 0; i < students.size(); i++)
        {
            Student student = students.get(i);
            if (maxAverageGrade < student.getAverageGrade())
            {
                maxAverageGrade = student.getAverageGrade();
                resultedStudent = student;
            }
        }
        return resultedStudent;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student resultedStudent = null;
        double minAverageGrade = students.get(0).getAverageGrade();
        for (int i = 0; i < students.size(); i++)
        {
            Student student = students.get(i);
            if (student.getAverageGrade() < minAverageGrade)
            {
                minAverageGrade = student.getAverageGrade();
                resultedStudent = student;
            }
        }
        return resultedStudent;
    }

    public void expel(Student student)
    {
        if (student != null)
        {
            if (students.contains(student))
                students.remove(student);
        }
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
