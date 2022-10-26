package sample;

public class ClassSearchModule {
    String class_id,subject,room_no,time;

    public ClassSearchModule(String class_id, String subject, String room_no, String time) {
        this.class_id = class_id;
        this.subject = subject;
        this.room_no = room_no;
        this.time = time;
    }


    public String getClass_id() {
        return class_id;
    }

    public String getSubject() {
        return subject;
    }

    public String getRoom_no() {
        return room_no;
    }

    public String getTime() {
        return time;
    }


    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
