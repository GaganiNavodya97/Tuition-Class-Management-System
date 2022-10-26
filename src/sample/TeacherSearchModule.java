package sample;

public class TeacherSearchModule {


    Integer teacher_id;
    String teacher_name,teacher_gender, teacher_address,teacher_tp,email,teacher_subject;

    public TeacherSearchModule(Integer teacher_id, String teacher_name, String teacher_gender, String teacher_address, String teacher_tp, String email, String teacher_subject) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_gender = teacher_gender;
        this.teacher_address = teacher_address;
        this.teacher_tp = teacher_tp;
        this.email = email;
        this.teacher_subject = teacher_subject;
    }

    public Integer getTeacher_id() {

        return teacher_id;
    }

    public String getTeacher_name() {

        return teacher_name;
    }

    public String getTeacher_gender() {

        return teacher_gender;
    }

    public String getTeacher_address() {

        return teacher_address;
    }

    public String getTeacher_tp() {

        return teacher_tp;
    }

    public String getEmail() {

        return email;
    }

    public String getTeacher_subject() {

        return teacher_subject;
    }


    public void setTeacher_id(Integer teacher_id) {

        this.teacher_id = teacher_id;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setTeacher_gender(String teacher_gender) {
        this.teacher_gender = teacher_gender;
    }

    public void setTeacher_address(String teacher_address) {
        this.teacher_address = teacher_address;
    }

    public void setTeacher_tp(String teacher_tp) {
        this.teacher_tp = teacher_tp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeacher_subject(String teacher_subject) {
        this.teacher_subject = teacher_subject;
    }

}
