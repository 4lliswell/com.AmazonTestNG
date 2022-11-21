package Team10Work.Calisma05_Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Adinizi girin: ");

        StudentClass student1 = new StudentClass(sc.nextLine());

        List<LessonClass> generalList= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Dersin adini girin: ");
            String dersAdi= sc.nextLine();
            System.out.print("Kredisini girin: ");
            int dersKredi= sc.nextInt();
            LessonClass lesson1 =new LessonClass(dersAdi,dersKredi);
            generalList.add(lesson1);

        }
        // 2. YOL:
        //LessonClass l1 =new LessonClass(sc.nextLine(),5);
        //LessonClass l2 =new LessonClass("Matematik",sc.nextInt());
        //generalList.add(l1);
        //generalList.add(l2);

        for (LessonClass ch : generalList) {
            if (student1.toplamKredi()+ ch.lessonCredit<= student1.maxCredit){

            }
        }



    }

}
