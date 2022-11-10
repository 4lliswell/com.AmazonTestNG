package j99_Team10.Calisma03_MailSifreOlusturma;

import java.util.Random;
import java.util.Scanner;

public class MailSifre {

    Scanner scan = new Scanner(System.in);

    //fields
    String firstName;
    String lastName;
    String passWord;
    String department;
    String email;
    String emailSuffix = "clarusway.com";
    int mailBoxCapasity = 1000;
    int defaultpassWordLenght = 12;

    public MailSifre(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String setDemartment() {

        System.out.println("Departmaninizi seciniz:\n" +
                "testautomation      -> 1\n" +
                "fullstackdeveloper  -> 2\n" +
                "salesforce          -> 3\n" +
                "Departmaniniz Yoksa -> 4");

        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                department = "testautomation";
                break;
            case 2:
                department = "fullstackdeveloper";
                break;
            case 3:
                department = "salesforce";
                break;
            case 4:
                department = null;
                break;
            default:
                System.out.println("Hatali giris yaptiniz Tekrar Deneyiniz.");
                setDemartment();
        }
        email=firstName+lastName+department+"@"+emailSuffix;
        // yunusciftcisalesforse@clarusway.com
        return email;
    }

    public String setRandomPassWord(){

        String sifreHavuz="ABCDEFGHIJKLMNOPRSTUVYZabcdefghıjklmanoprstuvyi1234567890?*!'+";

        Random rdm= new Random();
        StringBuilder sifre= new StringBuilder(defaultpassWordLenght); // 12 capsiteli alan isgal eder.

        for (int i = 0; i < defaultpassWordLenght; i++) { //12
            int rasgeleIndex= rdm.nextInt(sifreHavuz.length());
            sifre.append(sifreHavuz.charAt(rasgeleIndex));
        }
        passWord= sifre.toString();

        return passWord;
    }

    /*@Override
    public String toString() {
        return  "\nfirstName= " + firstName +
                "\nlastName= " + lastName +
                "\npassWord= " + passWord +
                "\ndepartment= " + department +
                "\nemail= " + email;
    }*/

    public String showInfo() {

        return  "\nfirstName= " + firstName + "\nlastName= " + lastName + "\npassWord= " + setRandomPassWord() + "\nemail= " + setDemartment();
    }
}











