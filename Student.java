package main.java.service.utility;

public class Student implements Comparable {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        if (marks != s.marks) {
            return marks - s.marks;
        }
        if (id != s.id) {
            return id - s.id;
        }
        return name.compareTo(s.name);
    }
}
