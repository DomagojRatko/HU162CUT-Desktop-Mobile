import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Developer Domagoj Ratko
// This code is private and you are not allowed to use or copy it.

public class Main {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main obj = new Main();
        obj.menu();
    }
    private void menu(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("===========================");
        System.out.println("       HU162 CUTING     ");
        System.out.println("===========================");
        System.out.println("\nPick key type:");
        System.out.println("1). 8 CUT \n2). 9 CUT \n3). 10 CUT");
        try {
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("\nEnter wafers reading.");
                    arySize(8);
                    break;
                case 2:
                    System.out.println("\nEnter wafers reading.");
                    arySize(9);
                    break;
                case 3:
                    System.out.println("\nEnter wafers reading.");
                    arySize(10);
                    break;
                default:
                    System.out.println("Wrong! Enter one of the number to select in menu 1, 2 or 3.\n");
                    TimeUnit.SECONDS.sleep(2);
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Wrong! Please use numbers to enter into program.\n");
            pressAnyKeyToContinue();
        }
    }
    private int[] arySize(int pinCount){
        int[] ary = new int[pinCount];
        cutInput(pinCount, ary);
        return ary;
    }
    private void cutInput(int pinCount, int[] ary){
        for (int i = 0; i < pinCount; i++) {
            System.out.print("Wafer " + (i + 1) + ". : ");
            ary[i] = sc.nextInt();
            if(ary[i] > 10)
                ary[i] = ary[i] - 10;
            if(ary[i] > 5) {
                errorCutInput(pinCount);
                break;
            }
            if(pinCount == 9){
                if(ary[0] > 4 || ary[1] > 4 || ary[2] > 4) {
                    errorCutInput(pinCount);
                    break;
                }
            } else if  (pinCount == 10){
                if(ary[0] > 4 || ary[1] > 4 || ary[2] > 4 || ary[3] > 4){
                    errorCutInput(pinCount);
                    break;
                }
            }
        }
        switch (pinCount) {
            case 8:
                cut8Math(ary);
                break;
            case 9:
                cut9Math(ary);
                break;
            case 10:
                cut10Math(ary);
                break;
        }
    }
    private void errorCutInput(int pinCount){
        System.out.println("\nWrong size of wafer!");
        switch (pinCount) {
            case 8:
                System.out.println("Enter Wafer between 1 and 5 or 11 and 15");
                break;
            case 9:
                System.out.println("Enter first three wafer between 1 and 4 or 11 and 14 for the rest 1 and 5 or 11 and 15");
                break;
            case 10:
                System.out.println("Enter first four wafer between 1 and 4 or 11 and 14 for the rest 1 and 5 or 11 and 15");
                break;
        }
        cutInput(pinCount, arySize(pinCount));
    }
    private void cut8Math(int[] ary){
        int[] rule = {0,1,0,1,1,0,1,0};
        for (int i = 0; i < ary.length; i++) {
            convert(ary,rule,i);
        }
        printAry(ary);
    }
    private void cut9Math(int[] ary){
        int[] rule = {0,1,0,1,0,0,1,0,1};
        convertLow(ary,rule,1);
        for (int i = 3; i < ary.length; i++) {
            convert(ary,rule,i);
        }
        printAry(ary);
    }
    private void cut10Math(int[] ary){
        int[] rule = {0,1,0,1,0,1,0,1,1,0};
        convertLow(ary,rule,1);
        convertLow(ary,rule,3);
        for (int i = 4; i < ary.length; i++) {
            convert(ary,rule,i);
        }
        printAry(ary);
    }
    private void convertLow(int[] ary, int[] rule, int i){
        if(rule[i] == 1 ){
            switch (ary[i]){
                case 1:
                    ary[i] = 4;
                    break;
                case 2:
                    ary[i] = 3;
                    break;
                case 3:
                    ary[i] = 2;
                    break;
                case 4:
                    ary[i] = 1;
                    break;
            }
        }
    }
    private void convert(int[] ary, int[] rule, int i){
        if(rule[i] == 1 ){
            switch (ary[i]){
                case 1:
                    ary[i] = 5;
                    break;
                case 2:
                    ary[i] = 4;
                    break;
                case 3:
                    ary[i] = 3;
                    break;
                case 4:
                    ary[i] = 2;
                    break;
                case 5:
                    ary[i] = 1;
                    break;
            }
        }
    }
    private void printAry(int[] ary){
        System.out.println("\nCut key:\n" + Arrays.toString(ary));
        if(ary.length == 9){
            System.out.println("Side cut key:\n" + "[" + ary[0] + ", " + ary[1] + ", " + ary[2] + "]");
        } else if (ary.length == 10){
            System.out.println("Side cut key:\n" + "[" + ary[0] + ", " + ary[1] + ", " + ary[2] + ", " + ary[3] + "]");
        }
        pressAnyKeyToContinue();
        System.exit(0);
    }
    private void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to exit...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
