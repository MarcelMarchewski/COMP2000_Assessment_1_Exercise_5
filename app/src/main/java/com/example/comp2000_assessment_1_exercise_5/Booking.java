package com.example.comp2000_assessment_1_exercise_5;

public class Booking
{
    private String roomName;
    private String date;
    private String time;

    public Booking(String roomName, String date, String time)
    {
        this.roomName = roomName;
        this.date = date;
        this.time = time;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }
}
