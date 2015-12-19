/*
 * Course: IT152
 * Professor: Linnea Hall
 * Programmer: Dale Knowles
 */

/**
 *
 * @author Dale
 */
package it152.survey;
public class SurveyConductor {
  public static void main(String[] args){
    System.out.println("~Welcome User~"); //welcomes user to the survey
    Survey userSurvey;   //declare new object "userSurvey"
    java.util.Scanner mainScan = new java.util.Scanner(System.in);
    System.out.println("Would like to specify a title? ( [y]es/[n]o )");
    while (true) {
      String response = mainScan.nextLine();
      System.out.println("");
      response = response.trim().toLowerCase();
      if ( (response.equals("yes")) || (response.equals("y")) ) {
        System.out.println("What survey title would you prefer?");
        userSurvey = new Survey(mainScan.nextLine());
        System.out.println("");
        break;
      } else if ( ( response.equals("no")) || (response.equals("n")) ){
        userSurvey = new Survey();
        break;
      }
      System.out.println("Invalid response. Please specify 'yes' or 'no'.");
    };
    userSurvey.enterQuestions(); //calls enterquestions method

    SurveyConductor dalesConductor = new SurveyConductor(userSurvey);
    // Creates new conductor "dalesConductor" to use the new survey "userSurvey."
    
    dalesConductor.coduct(3); //assigning 3 new surveys to conduct
    userSurvey.displaySurveyResults(); // calls method to display results of 
    // survey
    System.out.println("Top Rated Question: " + userSurvey.topRatedQuestion());
    System.out.println("Low Rated Question: " + userSurvey.lowRatedQuestion());
      
  }
     
  public SurveyConductor(Survey s){ // survey constructor "instructions" for the 
    //object      
    this.mySurvey = s; // assign variable to mySurvey method
  }
   
  //Create method to conduct survey and loop responses to the questions.
  public void coduct(int numRespondents){
      
    for(int respondent = 0; respondent < numRespondents; ++respondent){
      if(respondent > 0) {
        System.out.println("Next Survey"); //print to show when next survey starts)
      } 
      this.mySurvey.generateRespondentId();
      for(int question = 1; question <= this.mySurvey.getNumQuestions(); ++question){
        this.mySurvey.presentQuestion(question);
      }
      System.out.println("");
    }
  }
   
  private Survey mySurvey; // create new object mySurvey to use for setting 
  // unique methods for this survey.
}
