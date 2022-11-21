package Team10Work.Calisma05_Student;

public class LessonClass {

    // fields
    String lessonName;
    int lessonCredit;

    public LessonClass(String lessonName, int lessonCredit) {
        this.lessonName = lessonName;
        this.lessonCredit = lessonCredit;
    }

    public LessonClass() {
    }

    @Override
    public String toString() {
        return  "lessonName: " + lessonName +
                ", lessonCredit: " + lessonCredit;
    }
}
