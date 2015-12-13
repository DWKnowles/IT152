/*
 * Course: IT152
 * Professor: Linnea Hall
 * Programmer: Dale Knowles
 */
package it152.survey;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dale
 */
public class Test {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Comment Code heavily by explaining each method(more then just name)!!!
    
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    
    Survey oSurvey = new Survey ("Dale's"); // Creating new instance of 
           // the Survey class and setting the survey title to "Dale's Survey."

    oSurvey.enterQuestions(); // call enterQuestions from oSurvey which is a
                              // new instance of the Survey class.
   
    int myId = oSurvey.generateRespondentId();
    for(int i = 0; i < oSurvey.getNumQuestions()/2; ++i){
       oSurvey.presentQuestion(i + 1);
    }
    {
       for(int i = oSurvey.getNumQuestions()/2; 
               i < oSurvey.getNumQuestions(); 
               ++i){
          oSurvey.presentQuestion(i+1, myId);
       }
    }
    
    int totalRespondents = 3;
    for(int row = 1; row < totalRespondents; ++row){
      oSurvey.generateRespondentId();
      oSurvey.logResponse(row, 0, Integer.MIN_VALUE/3);
      oSurvey.logResponse(row, 1, rand.nextInt(5) + 1);
      oSurvey.logResponse(row, 2, Integer.MAX_VALUE/3);
    }

    // the (1) indicates we will be testing indexes 0,1
    // and 2 because rowQ and colQ are set to 3
    oSurvey.displaySurveyResults();
    oSurvey.displayQuestionStats(rand.nextInt(3) + 1);
    
    //Print top and low rated question column #
    System.out.println("Hi rated index = Q" + oSurvey.topRatedQuestion());
    if ( oSurvey.topRatedQuestion() == 3 ){System.out.println("Correct!");}
    System.out.println("Low rated index = Q" + oSurvey.lowRatedQuestion());
    if ( oSurvey.lowRatedQuestion() == 1 ){System.out.println("Correct!");}
  }
}
