package sample;

public class AttendanceSearchModule {
    String attendances_id, week1, week2, week3, week4, payment;

    public AttendanceSearchModule(String attendances_id, String week1, String week2, String week3, String week4, String payment) {
        this.attendances_id = attendances_id;
        this.week1 = week1;
        this.week2 = week2;
        this.week3 = week3;
        this.week4 = week4;
        this.payment = payment;
    }

    public String getAttendances_id() {
        return attendances_id;
    }

    public String getWeek1() {
        return week1;
    }

    public String getWeek2() {
        return week2;
    }

    public String getWeek3() {
        return week3;
    }

    public String getWeek4() {
        return week4;
    }

    public String getPayment() {
        return payment;
    }


    public void setAttendances_id(String attendances_id) {
        this.attendances_id = attendances_id;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public void setWeek2(String week2) {
        this.week2 = week2;
    }

    public void setWeek3(String week3) {
        this.week3 = week3;
    }

    public void setWeek4(String week4) {
        this.week4 = week4;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}