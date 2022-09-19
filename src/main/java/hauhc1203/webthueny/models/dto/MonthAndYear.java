package hauhc1203.webthueny.models.dto;

public class MonthAndYear {
    private int month;
    private int year;

    public MonthAndYear() {
    }

    public MonthAndYear(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
