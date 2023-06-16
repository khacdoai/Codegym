package ass1.baitap;

import java.util.Scanner;

public class number_to_words {
    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number is: ");
        number = scanner.nextInt();
        if (number < 0 || number > 999) {
            System.out.println("Number out of range");
        } else if (number < 10 ) {
            readSingleDigit(number);
        } else if (number < 20 ) {
            readTwoDigitsLessThanTwenty(number);
        } else if (number < 100 ) {
            dozensWords(number);
        } else if (number >=100 && number <=999) {
            readThreeDigits(number);
        } else {
            System.out.println("out of ability");
        }

    }

    public static void readSingleDigit( int ones){
        switch (ones) {
            case 0:
                System.out.print("zero");
                break;
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            case 4:
                System.out.print("four");
                break;
            case 5:
                System.out.print("five");
                break;
            case 6:
                System.out.print("six");
                break;
            case 7:
                System.out.print("seven");
                break;
            case 8:
                System.out.print("eight");
                break;
            case 9:
                System.out.print("nine");
                break;
            default:
                System.out.println("Number out of ability");
                break;
        }
    }
    public static void readTwoDigitsLessThanTwenty( int word){
        switch (word) {
            case 10:
                System.out.println("ten");
                break;
            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
                break;
            case 13:
                System.out.println("thirteen");
                break;
            case 14:
                System.out.println("fourteen");
                break;
            case 15:
                System.out.println("fifteen");
                break;
            case 16:
                System.out.println("sixteen");
                break;
            case 17:
                System.out.println("seventeen");
                break;
            case 18:
                System.out.println("eighteen");
                break;
            case 19:
                System.out.println("nineteen");
                break;
            default:
                System.out.println("Number out of ability");
                break;
        }
    }
    public static void dozensWords( int dozens) {
        int tens = dozens/10;
        int ones = dozens % 10;
        String tensWord;
        switch (tens) {
            case 2:
                tensWord = "twenty";
                break;
            case 3:
                tensWord = "thirty";
                break;
            case 4:
                tensWord = "forty";
                break;
            case 5:
                tensWord = "fifty";
                break;
            case 6:
                tensWord = "sixty";
                break;
            case 7:
                tensWord = "seventy";
                break;
            case 8:
                tensWord = "eighty";
                break;
            case 9:
                tensWord = "ninety";
                break;
            default:
                System.out.println("Number out of ability");
                return;
        }

        if (ones != 0) {
            System.out.println(tensWord + " " + readSingleDigitString(ones));
        } else {
            System.out.println(tensWord);
        }
    }
    public static void readThreeDigits(int number){
        int hundreds = number /100;
        int donzenworks = number % 100;
        System.out.print(readSingleDigitString(hundreds) + " hundred");

        if (donzenworks != 0) {
            System.out.print(" and ");
            if (donzenworks < 10) {
                readSingleDigit(donzenworks);
            } else if (donzenworks < 20) {
                readTwoDigitsLessThanTwenty(donzenworks);
            } else {
                dozensWords(donzenworks);
            }
        }
        System.out.println();
    }
    public static String readSingleDigitString(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
}
