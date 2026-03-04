package Hospital_Management_System;


// id , Name, specialization, Added new Doctor in Hospital

public class Doctor {
     private int id;
     private String name;
     private int age;
     private  String specialization;

    public Doctor(int id, String specialization, int age, String name) {
        this.id = id;
        this.specialization = specialization;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
