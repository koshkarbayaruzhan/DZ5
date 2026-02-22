package main;

import builder.*;

public class BuilderMain {

    public static void main(String[] args) {

        ReportDirector director = new ReportDirector();

        IReportBuilder textBuilder = new TextReportBuilder();
        director.constructReport(textBuilder);
        System.out.println(textBuilder.getReport());

        System.out.println("----------------");

        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder);
        System.out.println(htmlBuilder.getReport());
    }
}
