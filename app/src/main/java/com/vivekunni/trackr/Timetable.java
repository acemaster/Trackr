package com.vivekunni.trackr;

/**
 * Created by acemaster on 11/06/17.
 */

public class Timetable {
    int id;
    String name;
    float pass_percent;

    //Constructor
    public Timetable()
    {

    }
    public Timetable(String name,float pass_percent)
    {
        this.name = name;
        this.pass_percent = pass_percent;
    }

    //Setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPass_percent(float pass_percent) {
        this.pass_percent = pass_percent;
    }

    //Getters

    public long getId()
    {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public float getPass_percent() {
        return pass_percent;
    }

}
