/*
 * Course: IT152
 * Professor: Linnea Hall
 * Programmer: Dale Knowles
 */
package it152.survey;

/**
 *
 * @author Dale
 */
public class SurveyConductor {
   public static void main(String[] args){
      System.out.println("~Welcome User~");
      Survey userSurvey = new Survey ();   
      userSurvey.enterQuestions();
      SurveyConductor dalesConductor = new SurveyConductor(userSurvey);
      dalesConductor.coduct(3);
      userSurvey.displaySurveyResults();
   }
   
   public SurveyConductor(Survey s){
      this.mySurvey = s;
   }
   
   public void coduct(int numRespondents){
      for(int respondent = 0; respondent < numRespondents; ++respondent){
         this.mySurvey.generateRespondentId();
         for(int question = 1; question <= this.mySurvey.getNumQuestions(); ++question){
            this.mySurvey.presentQuestion(question);
         }
         System.out.println("Next Survey");
      }
   }
   
   private Survey mySurvey;
}
