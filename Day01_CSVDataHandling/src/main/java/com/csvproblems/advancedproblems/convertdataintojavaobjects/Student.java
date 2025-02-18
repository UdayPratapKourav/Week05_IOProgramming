package com.csvproblems.advancedproblems.convertdataintojavaobjects;

class Student {
    private int id;
    private String name;
    private String department;
    private double marks;

    // Constructor
    public Student(int id, String name, String department, double marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    // Override toString() for better printing
    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Department: " + department + ", Marks: " + marks + " }";
    }
}