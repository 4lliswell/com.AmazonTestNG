package Team10Work.Calisma05_Student;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {

    // fields
    String studentName;
    int maxCredit=10;
    List <LessonClass> lessonList= new ArrayList<>();

    public StudentClass(String studentName) {

        this.studentName = studentName;
    }

    public StudentClass() {
    }

    public int toplamKredi (){

        int toplam=0;
        for (LessonClass w : lessonList) {
            toplam += w.lessonCredit;
        }

        return toplam;
    }

    @Override
    public String toString() {
        return  "studentName: " + studentName +
                ", lessonList: " + lessonList;
    }
}
