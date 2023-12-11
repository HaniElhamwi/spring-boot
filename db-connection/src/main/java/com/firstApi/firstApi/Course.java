package com.firstApi.firstApi;

public class Course {
    private long id;
    private String name;
    private String authorName;

    public Course(long id, String name, String authorName) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
    }


    @Override
    public String toString() {
    	return "Course [id=" + id + ", name=" + name + ", authorName="  + "]";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName2() {
        return authorName;
    }
}
