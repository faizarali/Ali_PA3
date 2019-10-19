import java.util.Scanner;
import java.security.SecureRandom;

public class p1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int level = Difficulty ();

        int type = Arithmetic();

        Question(level, type);
    }

    static void Question (int x, int y) {
        int flag = 0;
        int count = 0;
        int num_correct = 0;
        int num_wrong = 0;
        double digit = 0;
        SecureRandom rand = new SecureRandom();

        int rand_1 = 0;
        int rand_2 = 0;
        int rand_comb = 0;

        Scanner input = new Scanner(System.in);

        while (flag == 0) {

            if(x == 1) {
                rand_1 = Random_Gen(1);
                rand_2 = Random_Gen(1);
            }

            if(x == 2) {
                rand_1 = Random_Gen(2);
                rand_2 = Random_Gen(2);
            }

            if(x == 3) {
                rand_1 = Random_Gen(3);
                rand_2 = Random_Gen(3);
            }

            if(x == 4) {
                rand_1 = Random_Gen(4);
                rand_2 = Random_Gen(4);
            }

            if(y == 1) {
                System.out.println("How much is " + rand_1 + " plus " + rand_2 +"?");
                rand_comb = rand_1 + rand_2;
            }

            if(y == 2) {
                System.out.println("How much is " + rand_1 + " times " + rand_2 +"?");
                rand_comb = rand_1 * rand_2;
            }

            if(y == 3) {
                System.out.println("How much is " + rand_1 + " minus " + rand_2 +"?");
                rand_comb = rand_1 - rand_2;
            }

            if(y == 4) {
                System.out.println("How much is " + rand_1 + " divided by " + rand_2 +"?");
                rand_comb = rand_1 / rand_2;
            }

            if(y == 5) {
                int mixer = 1 + rand.nextInt(4);

                if(mixer == 1) {
                    System.out.println("How much is " + rand_1 + " plus " + rand_2 +"?");
                    rand_comb = rand_1 + rand_2;
                }

                if(mixer == 2) {
                    System.out.println("How much is " + rand_1 + " times " + rand_2 +"?");
                    rand_comb = rand_1 * rand_2;
                }

                if(mixer == 3) {
                    System.out.println("How much is " + rand_1 + " minus " + rand_2 +"?");
                    rand_comb = rand_1 - rand_2;
                }

                if(mixer == 4) {
                    System.out.println("How much is " + rand_1 + " divided by " + rand_2 +"?");
                    rand_comb = rand_1 / rand_2;
                }
            }

            digit = input.nextDouble();

            if(Math.abs(digit - rand_comb) <= 0.000000001) {
                Correct();
                count++;
                num_correct++;
            }
            else {
                Incorrect();
                count++;
                num_wrong++;
            }

            if(count == 10) {
                System.out.println("");
                System.out.println("You got " + num_correct + " Questions Correct");
                System.out.println("You got " + num_wrong + " Questions Wrong");
                System.out.printf("The Percentage you got correct is: %d" + "%%\n", (num_correct * 100) / 10);

                if (((num_correct * 100) / 10) >= 75) {
                    System.out.println("Congratulations, you are ready to go to the next level!");
                }
                else {
                    System.out.println("Please ask your teacher for extra help.");
                }

                System.out.println("Would you like to do another sessions? (Press 1 for yes or 2 for no)");
                int new_num = input.nextInt();

                if(new_num == 1) {
                    count = 0;
                    num_correct = 0;
                    num_wrong = 0;

                    x = Difficulty ();

                    y = Arithmetic();
                }
                else
                    flag = 1;
            }
        }
    }

    static int Difficulty () {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a difficulty level (Choose from 1 to 4): ");
        int level = input.nextInt();

        return level;
    }

    static int Arithmetic () {
        Scanner input = new Scanner(System.in);

        System.out.println("Pick an arithmetic type (Choose from 1 to 5): ");
        System.out.println("(1) Addition");
        System.out.println("(2) Multiplication");
        System.out.println("(3) Subtraction");
        System.out.println("(4) Division");
        System.out.println("(5) Random Mixture of all these types");
        int type = input.nextInt();

        return type;

    }

    static int Random_Gen (int x) {
        SecureRandom rand = new SecureRandom();

        if(x == 1)
            return 1 + rand.nextInt(9);
        if(x == 2)
            return 1 + rand.nextInt(99);
        if(x == 3)
            return 1 + rand.nextInt(999);
        if(x == 4)
            return 1 + rand.nextInt(9999);
        else
            return 0;
    }

    static void Correct () {
        SecureRandom rand = new SecureRandom();

        int rand_correct = 1 + rand.nextInt(4);

        switch (rand_correct) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
            default:
                System.out.println("Very good!");
                break;
        }
    }

    static void Incorrect () {
        SecureRandom rand = new SecureRandom();

        int rand_incorrect = 1 + rand.nextInt(4);

        switch (rand_incorrect) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don’t give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
            default:
                System.out.println("No. Please try again.");
                break;
        }
    }
}