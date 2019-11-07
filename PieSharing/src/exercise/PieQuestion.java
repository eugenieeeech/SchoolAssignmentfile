/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.Math;

/**
 *
 * @author Cheng Ka Pui
 */
public class PieQuestion {
    int a,b,c,d,ans,den,factor;
    String title,input;
    char op;
    
    public PieQuestion(String title,int a,int b,char op,int c, int d){ //constructor1
    boolean check = true; //flag
    
    if (!((a >= 1) && (a <= 7))) {
         check = false;
        }
    if(!(( c>= 1) && (c <= 7))){
         check = false;        
        }
    if(!(( b >= 2) && (b <= 8))){
        check = false;
        }
    if(!((d>= 2) && (d <= 8))){   
        check = false;
        }
    if ((op != '+')&&(op != '-')){
        check = false;
        }
    if(!(b>a)){
        check = false;
    }
    if(!(d>c)){
        check = false;
    }
    if (op == '-'){
        if(b>d){
            check = false;
            }
        }
    
    if (PieQuestion.gcd(a,b)>1){    //fraction reduction
            factor = PieQuestion.gcd(a,b);
            a=a/factor;
            b=b/factor;}            
    if (PieQuestion.gcd(c,d)>1){    //fraction rreduction
            factor = PieQuestion.gcd(c,d);
            c=c/factor;
            d=d/factor;}
    den = b*d;
    if (op=='+'){
     ans= a*d+b*c;
    }else if (op=='-'){
     ans= a*d-b*c;
     if (ans <= 0){
     check=false;}
    }
    if (PieQuestion.gcd(ans,den)>1){    //fraction reducton
        factor = PieQuestion.gcd(ans,den);
        ans=ans/factor;
        den=den/factor;}
    
    if (ans>=den){
        check = false;
    }                                   //finish checking
    
    if (!check){                //if anything wrong
     a=1;
     b=4; 
     op ='+'; 
     c=1; 
     d=2;
     ans= 3;
     den= 4;
    }  
    this.a=a;
    this.b =b;
    this.c=c;
    this.d= d;
    this.op = op;
    this.title = title;
    }
    
    public PieQuestion(String title){ //constructor2
    
     a = (int)(Math.random() * 7 + 1); //for a,c
     c = (int)(Math.random() * 7 + 1); //for a,c
     b = (int)(Math.random() * 7 + 2);//for b,d
     d = (int)(Math.random() * 7 + 2);
    
    Random rngObj= new Random();
    double condition = rngObj.nextDouble();
     if(condition > 0.5){
        op = '+';
    }else{op = '-';}
     
    int check = 1;
    while (check != 0){
    check = 0;
    while (!((a >= 1) && (a <= 7))) {
         a = (int)(Math.random() * 7 + 1);
        }
    while(!(( c>= 1) && (c <= 7))){
         c = (int)(Math.random() * 7 + 1);
        }
    while(!(( b>= 2) && (b <= 8))){
        b = (int)(Math.random() * 7 + 2);
        }
    while(!((d>= 2) && (d <= 8))){
        d = (int)(Math.random() * 7 + 2);
        }
    while ((op != '+')&&(op != '-')){
     condition = rngObj.nextDouble();
     if(condition > 0.5){
        op = '+';
    }else{op = '-';}
        }                                                //first check,checking generated numb in range
    while(!(b>a)){
        b = (int)(Math.random() * 7 + 2);
    }
    while(!(d>c)){
        d = (int)(Math.random() * 7 + 2);
    }
     if (op == '-'){                                    
        while(!(b>=d)){
            b = (int)(Math.random() * 7 + 2);
        }
        }
    if (PieQuestion.gcd(a,b)>1){
        factor = PieQuestion.gcd(a,b); //fraction reduction
        a=a/factor;
        b=b/factor;}
            
    if (PieQuestion.gcd(c,d)>1){    //fraction reduction
        factor = PieQuestion.gcd(c,d);
        c=c/factor;
        d=d/factor;}
    den = b*d; //calculate the answer
    if (op=='+'){
     ans= a*d+b*c;
    }else if (op=='-'){
     ans= a*d-b*c;
     if (ans <= 0){
     check=1;}
    }
    
    if (PieQuestion.gcd(ans,den)>1){ //fraction reduction
    factor = PieQuestion.gcd(ans,den);
    ans=ans/factor;
    den=den/factor;}
    
    if (ans>=den){
        check = 1;      
    }                                   //finish checking
    if (check==1){
     a = (int)(Math.random() * 7 + 1); //for a,c
     c = (int)(Math.random() * 7 + 1); //for a,c
     b = (int)(Math.random() * 7 + 2);//for b,d
     d = (int)(Math.random() * 7 + 2);
    condition = rngObj.nextDouble();
     if(condition > 0.5){
        op = '+';
    }else{op = '-';}
    }
        }
    this.title = title; 
    }
    public String getUserInputAnswer(){
        String input = null;
        input =JOptionPane.showInputDialog(title + ": " + a + "/" + b +" " + op + " " + c + "/"+ d +" = ?/" + den,"<type answer here>");
        while (input == null){
            input =JOptionPane.showInputDialog(title + ": " + a + "/" + b +" " + op + " " + c + "/"+ d +" = ?/" + den,"<type answer here>");
        }      
        return input;
    }
    public boolean checkAnswer(String user_answer){
        //return a boolean value after checking answer
        boolean flag = false;
        int user_answer_int = Integer.parseInt(user_answer);
        if (ans == user_answer_int){
            flag= true;
        }        
        return flag;
    }
    public static int gcd(int upper_num, int lower_num){ //find the G.D.C
        int i, hcf;
        hcf=1;
        for(i=1;(i<=upper_num)||(i<=lower_num) ;i++){
            if(upper_num%i == 0 &&lower_num%i ==0){
            hcf=i;}
        }
        return hcf;
    }    
}


