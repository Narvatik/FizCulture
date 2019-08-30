package com.example.fizculture;

public class Student {
    private String name;
    private String standard;
    private boolean visit_first;
    private boolean visit_second;

    public Student(String name, String company,boolean visit_first,boolean visit_second){

        this.name=name;
        this.standard = company;
        this.visit_first=visit_first;
        this.visit_second=visit_second;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public boolean isVisit_second() {
        return visit_second;
    }

    public void setVisit_second(boolean visit_second) {
        this.visit_second = visit_second;
    }

    public boolean isVisit_first() {
        return visit_first;
    }

    public void setVisit_first(boolean visit_first) {
        this.visit_first = visit_first;
    }
}
