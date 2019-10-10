/**
 * CSCI1130 Assignment 2 Future Value
 * Aim: To implement future value calculation for growing asset by writing a Java console application
 *      To practise the use of variables/expression, looping/branching statements and basic Math
 *
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of university policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 *
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name  : Cheng Ka Pui
 * Student ID    : 1155125534
 * Date          : 06/10/2019
 */
package exercise;

import java.util.Scanner;

/**
 *
 * @author Cheng Ka Pui
 */
public class FutureValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int m = 0; //compounding frequency per year
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Principle [$10000.00 - $109700.00]: ");
        double P = scan.nextDouble();
        while ( P<10000.00 ||P >109700.00 ){
            System.out.println("Invaild Principle, please enter again.");
            System.out.print("Input Principle [$10000.00 - $109700.00]: ");
            P = scan.nextDouble();
        }
        System.out.print("Annual Interest Rate [1.0% - 10.0%]: ");
        double rate = scan.nextDouble();
        while ( rate< 1 || rate >10 ){
            System.out.println("Invaild Rate, please enter again.");
            System.out.print("Annual Interest Rate [1.0% - 10.0%]: ");
            rate = scan.nextDouble();
        }
        System.out.print("Input Timespan [2 - 10 years]: ");
        int time = scan.nextInt();
        while ( time< 2 || time >10 ){
            System.out.println("Invaild Timespan ,please enter again.");
            System.out.print("Input Timespan [2 - 10 years]: ");
            time = scan.nextInt();
        }
        
        System.out.print("Input Compounding Period [1, 6 or 12 months]: ");
        int compoundperiod = scan.nextInt();
        boolean flag = true;
        while (flag){
        switch(compoundperiod){
        case 1:
        m=12;
        flag=false;
        break;
        case 6:
        m =2;
        flag=false;
        break; 
        case 12:
        m= 1;
        flag=false;
        break;
        default:
        System.out.println("Invalid Compounding Period, please enter again.");
        System.out.print("Input Compounding Period [1, 6 or 12 months]: ");
        compoundperiod = scan.nextInt();
        }
        }
        //input      
        int totalcompundingtime=12*time/compoundperiod;
        
        for (int i = 1; i<=totalcompundingtime  ; i++) {
            P = P*(1+((rate/100)/m));
             
            if (i == totalcompundingtime ){
                System.out.printf("Future Value at the end: %.2f\n",P);
            }else
                if ((i==1)||(i==2)){
            System.out.printf("Future Value after %d months is: %.2f\n",compoundperiod*i,P);
            }else 
                if(i==3){
                    System.out.println("...");
                }
                      
        }
        //
        double numofyear;
        numofyear= (Math.log(2))/(m*Math.log(1+(rate/100)/m));
        System.out.printf("Time to obtain asset x2: %.2f years\n",numofyear);
        numofyear= (Math.log(3))/(m*Math.log(1+(rate/100)/m));
        System.out.printf("Time to obtain asset x3: %.2f years\n",numofyear);
        numofyear= (Math.log(4))/(m*Math.log(1+(rate/100)/m));
        System.out.printf("Time to obtain asset x4: %.2f years\n",numofyear);
    }
    
}
