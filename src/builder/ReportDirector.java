package builder;

public class ReportDirector {

    public void constructReport(IReportBuilder builder) {
        builder.setHeader("Заголовок");
        builder.setContent("Основной текст");
        builder.setFooter("Подвал");
    }
}
