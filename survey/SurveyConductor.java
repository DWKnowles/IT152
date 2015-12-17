/*
 * Course: IT152
 * Professor: Linnea Hall
 * Programmer: Dale Knowles
 */
package it152.survey;

import static it152.survey.Survey.scanLine;

/**
 *
 * @author Dale
 */
public class SurveyConductor {
   public static void main(String[] args){
      System.out.println("~Welcome User~"); //welcomes user to the survey
      Survey userSurvey = new Survey ();   //creates new object "userSurvey"
      userSurvey.enterQuestions(); //calls enterquestions method
      SurveyConductor dalesConductor = new SurveyConductor(userSurvey); // Creates
      // new conductor "dalesConductor" to use the new survey "userSurvey."
      dalesConductor.coduct(3); //assigning 3 new surveys to conduct
      userSurvey.displaySurveyResults(); // calls method to display results of 
      // survey
   }
     
   public SurveyConductor(Survey s){ // survey constructor "instructions" for the 
      //object      
      this.mySurvey = s; // assign variable to mySurvey method
   }
   
   //Create method to conduct survey and loop responses to the questions.
   public void coduct(int numRespondents){
      
      for(int respondent = 0; respondent < numRespondents; ++respondent){
         this.mySurvey.generateRespondentId();
            System.out.print("Enter Survey Title: ");
            this.mySurvey.questionArray[respondent] = scanLine.nextLine(); 
// want to add question # after user inputs title
            System.out.println("");
          
         for(int question = 1; question <= this.mySurvey.getNumQuestions(); ++question){
            this.mySurvey.presentQuestion(question);
         }
         respondent=respondent; // I tried to reset users input for survey title 
         System.out.println("Next Survey");//print to show when next survey starts
      }
   }
   
   private Survey mySurvey; // create new object mySurvey to use for setting 
   // unique methods for this survey.
}
