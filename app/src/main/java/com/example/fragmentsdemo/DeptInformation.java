package com.example.fragmentsdemo;

public class DeptInformation {

    String[] info=new String[]{
            "The undergraduate program in Computer Science at Virginia Tech is both challenging and rewarding. The objectives of the program are to provide majors with a balanced breadth and depth of knowledge in computer science that allows them the choice between continuing their education in graduate school and beginning their professional career, and to excel in either environment. ",
            "The ECE Department continues to grow at a steady pace. In 2015 and 2016, the number of undergraduates entering either the electrical engineering or computer engineering degree program doubled to about 450 per year, consistently representing 20 percent of the College of Engineering’s new majors."
    };
    public String getInfo(int index){
        switch (index){
            case 0:
                return  info[0];
            case 1:
                return info[1];
            default:
                return "Department Information";
        }
    }
}
