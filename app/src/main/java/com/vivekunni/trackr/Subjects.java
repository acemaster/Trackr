package com.vivekunni.trackr;

/**
 * Created by acemaster on 11/06/17.
 */

public class Subjects {
    int id;
    String name;
    int timetable_id;
    int no_of_classes;

    //Constructors
    public Subjects()
    {

    }

    public Subjects(int id,String name,int timetable_id,int no_of_classes)
    {
        this.id = id;
        this.name = name;
        this.timetable_id = timetable_id;
        this.no_of_classes = no_of_classes;
    }

    //Setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimetable_id(int timetable_id) {
        this.timetable_id = timetable_id;
    }

    public void setNo_of_classes(int no_of_classes) {
        this.no_of_classes = no_of_classes;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNo_of_classes() {
        return no_of_classes;
    }

    public int getTimetable_id() {
        return timetable_id;
    }

}
