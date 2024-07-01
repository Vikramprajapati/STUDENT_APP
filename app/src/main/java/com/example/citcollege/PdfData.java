package com.example.citcollege;

public class PdfData {

    String pdfTitle,pdfUrl;

    public PdfData() {
    }

    public PdfData(String pdfTitle, String pdfUrl) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getpdfTitle() {
        return pdfTitle;
    }

    public void setpdfTitle(String title) {
        this.pdfTitle = title;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
