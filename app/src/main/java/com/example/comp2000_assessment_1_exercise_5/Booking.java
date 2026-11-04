package com.example.comp2000_assessment_1_exercise_5;

public class Booking
{
    private String roomName;
    private String date;
    private String time;
    private String description;
    private String status;

    public Booking(String roomName, String date, String time, String description, String status)
    {
        this.roomName = roomName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.status = status;
    }

    public String getRoomName() { return roomName; }
    public String getDate()
    {
        return date;
    }
    public String getTime()
    {
        return time;
    }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
}
