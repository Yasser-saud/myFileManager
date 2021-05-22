import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽");
        System.out.println("\tWelcome to My File Manager");
        System.out.println("\t\tDeveloped by Yasser");
        System.out.println("◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽◽");
        System.out.println("👉 Please enter the number left of the corresponding option you want");
        homeScreen();
    }

    public static void homeScreen() {
        String[] options = {"\n1- List my current files in the current directory", "2- More options", "3- Exit"};
        for (String option : options) {
            System.out.println(option);
        }

        Scanner sc = new Scanner(System.in);
        FileHandler f = new FileHandler();
        Options op = new Options();

        try {
            int input = sc.nextInt();
            switch (input) {
                case 1: {
                    File files[] = f.showFiles();
                    for (File file : files) {
                        System.out.println("\t" + file.getName());
                    }
                    homeScreen();
                    break;
                }
                case 2: {
                    op.options();
                    homeScreen();
                    break;
                }
                case 3: {
                    System.out.println("🚩 Thank you for using My File Manager\n \tExiting...");
                    break;
                }
                default: {
                    System.err.println("unknown option");
                    homeScreen();
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("invalid value, please try again");
            homeScreen();
        }


    }
}