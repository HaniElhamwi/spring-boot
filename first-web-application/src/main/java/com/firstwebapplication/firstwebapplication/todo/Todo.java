package com.firstwebapplication.firstwebapplication.todo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String user;

    @Column
    private String desc;

    @Column
    private boolean isDone;

    @Column
    private LocalDate targetDate;


    @Column
    private boolean done;

    public Todo(int id, String user, String desc, boolean isDone, LocalDate targetDate, boolean done) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.isDone = isDone;
        this.targetDate = targetDate;
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                ", isDone=" + isDone +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isDone() {
        return isDone;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }


}
