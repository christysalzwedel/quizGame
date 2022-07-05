package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizQuestion {
   private String questionAndAnswers;
   private String question;
   private String answerOne;
   private String answerTwo;
   private String answerThree;
   private String answerFour;
   private String correctAnswer;

   private String answerToCheck;

   //I think I may have too many getters and setters. That part still confuses me

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerToCheck() {
        return answerToCheck;
    }

    public void setAnswerToCheck(String answerToCheck) {
        this.answerToCheck = answerToCheck;
    }
    // I want to modify this class to include options for category and difficulty
    // Then I can ad an option for the user to choose a difficulty and/or a category
    public QuizQuestion (String questionAndAnswers){
        String[] splitParts = questionAndAnswers.split("\\|");

       this.question = String.valueOf(splitParts[0]);
       this.answerOne = String.valueOf(splitParts[1]).replace("*", "");
       this.answerTwo = String.valueOf(splitParts[2]).replace("*","");
       this.answerThree =String.valueOf(splitParts[3]).replace("*", "");
       this.answerFour = String.valueOf(splitParts[4]).replace("*", "");

       for(int i = 0; i < splitParts.length; i++) {
           if (splitParts[i].contains("*")) {
               this.correctAnswer = String.valueOf(splitParts[i].replace("*", ""));
               if (i == 1) {
                   answerToCheck = ("a");
               } else if (i == 2) {
                   answerToCheck = ("b");
               } else if (i == 3) {
                   answerToCheck = "c";
           } else if (i == 4) {
                   answerToCheck = "d";
               }
           }
       }
       }
/* I was today years old when I found out that putting a sout in the constructor
does work if you want to output the construction process to the console. which
isn't what I was going for, but might be useful in future */
       /* System.out.println(question);
        System.out.println("is it A: " + answerOne);
        System.out.println("is it B: " + answerTwo);
        System.out.println("is it C: " + answerThree);
        System.out.println("or is it D: " + answerFour);*/
    public QuizQuestion(){

    }
}

