/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojava2;

/**
 *
 * @author nguye
 */
public class Person {

    private String name;
    private int age;
    private int gender;
    private String phone;

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person(String name, int age, int gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
    
    public Person(){
        
    }
    
    @Override
    public String toString() {
        return "Toi ten la " + this.name
                + " " + this.age
                + " tuoi"
                + " gioi tinh " + (this.gender == 0 ? "Nu" : this.gender == 1 ? "Nam" : "Khac")
                + " So dien thoai: " + this.phone;
    }
}
