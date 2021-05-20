import java.util.InputMismatchException;
import java.util.Scanner;

public class Options {

    public void Options() {
        FileHandler f = new FileHandler();
        String[] options = {"1- Search for a particular file", "2- Go back to home screen"};
        Scanner sc = new Scanner(System.in);
        for (String o : options)
            System.out.println(o);

        try {
            int input = sc.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("Please enter the name of the file, 'Case Sensitive'");
                    String file = sc.next();
                    System.out.println(f.findFile(file));
                    break;
                }
                case 2: {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("invalid option");
        }
    }
}