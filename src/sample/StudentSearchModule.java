package sample;

public class StudentSearchModule {

    String student_id,full_name,date_of_birth,gender,address,tp_no,class_id;

    public StudentSearchModule(String student_id, String full_name, String date_of_birth, String gender, String address, String tp_no, String class_id) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.tp_no = tp_no;
        this.class_id = class_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getTp_no() {
        return tp_no;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTp_no(String tp_no) {
        this.tp_no = tp_no;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}