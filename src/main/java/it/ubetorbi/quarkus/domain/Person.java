package it.ubetorbi.quarkus.domain;

import org.bson.codecs.pojo.annotations.BsonId;

public class Person {


    @BsonId
    String id;
    String fullName;
    String birthDate;
    int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", bithDate='" + birthDate + '\'' +
                ", age=" + age +
                '}';
    }
}
