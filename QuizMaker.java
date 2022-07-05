package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class QuizMaker {

	public static void main(String[] args) {
		QuizQuestion question = new QuizQuestion();
		List<QuizQuestion> questionList = new ArrayList<>();
		double questionCounter = 0;
		double correctAnswerCount = 0;
		double totalScore = 0;
		boolean isInputValid = true;

		Scanner userInput = new Scanner(System.in);
		System.out.println("What quiz file would you like to use? (please enter full file path)");
		String quizLocation = userInput.nextLine();
		System.out.println("What would you like me to call you?"); //my personal addition
		String userName = userInput.nextLine();
		System.out.println("okay, " + userName + "! Here's your first question:");


		File quizFile = new File(quizLocation);

// this block reads each line and uses it to make a QuizQuestion object
		//this I would like to modify to incorporate randomization and the sorting options for
		//category and list. it would generate a new list containing the selected kinds of questions
		//but then add them in a random order so they would be fed to the user randomized
		try(Scanner quizContent = new Scanner(quizFile)) {
			int index = 0;
			while (quizContent.hasNextLine()) {
				String questionAndAnswers = quizContent.nextLine();
				question = new QuizQuestion(questionAndAnswers);
				questionList.add(question);
				index = index + 1;


			}


			for (int i = 0; i < questionList.size(); i++) {
				if (i != questionList.size() - 1) {
					//this part really needs to be a class since the else is the same code and its smelly
					//I also want to add an else-if that outputs "are you ready for the next question?" on all but the 1st and last
					System.out.println(questionList.get(i).getQuestion());
					System.out.println("is it A: " + questionList.get(i).getAnswerOne());
					System.out.println("is it B: " + questionList.get(i).getAnswerTwo());
					System.out.println("is it C: " + questionList.get(i).getAnswerThree());
					System.out.println("or is it D: " + questionList.get(i).getAnswerFour());
					System.out.println(userName + " what is your answer? (please enter A, B, C, or D)");
					String userAnswer = userInput.nextLine();


					//this should correct for invalid inputs
					while (userAnswer != "") {
						if (userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b") || userAnswer.equalsIgnoreCase("c") || userAnswer.equalsIgnoreCase("d")) {

							if (userAnswer.equalsIgnoreCase(questionList.get(i).getAnswerToCheck())) {
								System.out.println("That's correct! Well done!");
								questionCounter++;
								correctAnswerCount++;
								break;
							} else {
								System.out.println("That's completely... WRONG! The correct answer was " + questionList.get(i).getCorrectAnswer() + ". Better luck next time!");
								questionCounter++;
								break;
							}
						} else {
							System.out.println("I'm sorry, " + userName + ". You'll need to answer with A, B, C, or D. Try again.");
							userAnswer = userInput.nextLine();

						}
					}

				} else {
					System.out.println("okay, " + userName + ". This is the last question. The pressure is on...");
					System.out.println(questionList.get(i).getQuestion());
					System.out.println("is it A: " + questionList.get(i).getAnswerOne());
					System.out.println("is it B: " + questionList.get(i).getAnswerTwo());
					System.out.println("is it C: " + questionList.get(i).getAnswerThree());
					System.out.println("or is it D: " + questionList.get(i).getAnswerFour());
					System.out.println(userName + " what is your answer? (please enter A, B, C, or D)");
					String userAnswer = userInput.nextLine().toLowerCase();

					while (userAnswer != "") {
						if (userAnswer.equalsIgnoreCase("a") || userAnswer.equalsIgnoreCase("b") || userAnswer.equalsIgnoreCase("c") || userAnswer.equalsIgnoreCase("d")) {

							if (userAnswer.equalsIgnoreCase(questionList.get(i).getAnswerToCheck())) {
								System.out.println("That's correct! Well done!");
								questionCounter++;
								correctAnswerCount++;
								break;
							} else {
								System.out.println("That's completely... WRONG! The correct answer was " + questionList.get(i).getCorrectAnswer() + ". Better luck next time!");
								questionCounter++;
								break;
							}
						} else {
							System.out.println("I'm sorry, " + userName + ". You'll need to answer with A, B, C, or D. Try again.");
							userAnswer = userInput.nextLine();

						}
					}
				}
			}
					System.out.println("okay, " + userName + ". That's all the questions I have today.");
					if (correctAnswerCount > 0) {
						totalScore = (correctAnswerCount / questionCounter) * 100;
					}

					if (totalScore == 0) {
						System.out.println("Wow, " + userName + " you didn't get ANY answers right! You're a certified idiot! Come back when you find a brain cell.");
					} else if (totalScore == 100) {
						System.out.println("WOW! That's a perfect score! Let it be known that " + userName + " is an actual genius!");
					} else if (totalScore < 50) {
						System.out.println("Well, " + userName + " you got " + totalScore + " percent right. You kinda suck at this, but there's hope for you if you study.");
					} else if (totalScore == 50) {
						System.out.println(userName + " you got EXACTLY half. You are the most mediocre player I've ever met! I guess I should congratulate you...");
					} else if (totalScore > 50) {
						System.out.println("Not bad, " + userName + ". You got " + totalScore + " percent!");
					}
				}


		catch (FileNotFoundException e){
			System.out.println("Quiz file not found");

		}


		}

}
