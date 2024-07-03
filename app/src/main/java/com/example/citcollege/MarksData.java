package com.example.citcollege;

public class MarksData {
    String MarksTitle,MarksYear,MarksBranch,MarksSem,imageUrl;;
    public MarksData(String title, String year, String branch, String sem, String imageUrl) {
        this.MarksTitle = title;
        this.MarksYear = year;
        this.MarksBranch = branch;
        this.MarksSem = sem;
        this.imageUrl = imageUrl;
    }

    public String getMarksYear() {
        return MarksYear;
    }

    public String getMarksTitle() {
        return MarksTitle;
    }

    public String getMarksBranch() {
        return MarksBranch;
    }

    public String getMarksSem() {
        return MarksSem;
    }
    public String getImageUrl() {

        return imageUrl;
    }

}
