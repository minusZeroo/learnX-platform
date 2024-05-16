package com.example.learnxplatform.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TutorialRequestRequest {

    private Long tutorId;
    private Long studentId;
    private String subject;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public Long getTutorId() {
        return tutorId;
    }
    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
