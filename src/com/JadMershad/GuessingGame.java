package com.JadMershad;

import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 0;
        int hintNumber = 0;
        boolean hintMarker = false;

        while (userAnswer != computerNumber && count<10)
        {
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100\nHints will appear after the 3rd and the 6th guess\nYou can try 10 times", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            switch (count){
                case 3:
                case 6:
                    hintMarker = true;
                    hintNumber++;
                    break;
                default:
                    break;
            }
            if(hintMarker) {
                JOptionPane.showMessageDialog(null,""+hint(hintNumber,computerNumber,count));
                hintMarker = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));
            }
            count++;
        }
    }

    public static String hint(int hintNumber,int computerNumber,int count){
        count++;
        switch (hintNumber){
            case 1:
                if(computerNumber%2==0) return "The number is a multiple of 2.\nTry Number: " + count;
                if(computerNumber%3==0) return "The number is a multiple of 3.\nTry Number: " + count;
                if(computerNumber%5==0) return "The number is a multiple of 5.\nTry Number: " + count;
                if(computerNumber%7==0) return "The number is a multiple of 7.\nTry Number: " + count;
            case 2:
                if(computerNumber>=0&&computerNumber<=10) return "The number is below 10(inclusive)\nTry Number: " + count;
                if(computerNumber>=10&&computerNumber<=20) return "The number between 10 and 20(inclusive)\nTry Number: " + count;
                if(computerNumber>=20&&computerNumber<=30) return "The number between 20 and 30(inclusive)\nTry Number: " + count;
                if(computerNumber>=30&&computerNumber<=40) return "The number between 30 and 40(inclusive)\nTry Number: " + count;
                if(computerNumber>=40&&computerNumber<=50) return "The number between 40 and 50(inclusive)\nTry Number: " + count;
                if(computerNumber>=50&&computerNumber<=60) return "The number between 50 and 60(inclusive)\nTry Number: " + count;
                if(computerNumber>=60&&computerNumber<=70) return "The number between 60 and 70(inclusive)\nTry Number: " + count;
                if(computerNumber>=70&&computerNumber<=80) return "The number between 70 and 80(inclusive)\nTry Number: " + count;
                if(computerNumber>=80&&computerNumber<=90) return "The number between 80 and 90(inclusive)\nTry Number: " + count;
                if(computerNumber>=90&&computerNumber<=100) return "The number between 90 and 100(inclusive)\nTry Number: " + count;
            default:
                return "";
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count){
        count++;
        if(count==10){
            return "Your guesses are done.\nThe number was: "+computerNumber+".\nTry Number: " + count;
        }
        else if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else{
            return "";
        }
    }
}
