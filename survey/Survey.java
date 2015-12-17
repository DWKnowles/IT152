/*
 * Course: IT152
 * Professor: Linnea Hall
 * Programmer: Dale Knowles
 */
package it152.survey;

import java.util.Scanner;

/**
 *
 * @author Dale
 */
// Week 1
public class Survey {
    
  // Declaration of variables
  private static int respondentId; // static makes variable class specific
  private String surveyTitle;
   
  static Scanner scanLine = new Scanner(System.in); //for use with nextLine
  static Scanner scan = new Scanner(System.in); //Scans a single number
   
  //Setting the array varaiables so we can change the value with less hassel
  private int numQ = 3; // the number of questions set to 10 
  private int numR = 0;  // set to 0 for default number of rows/respondentIDs
  private int maxR = 3; //sets max number of rows to 10
   
  // creating a parallel array to have the questions numbered to match the  
  // multidimensional answer array.
  String questionArray[]= new String[numQ]; 
  private int answerArray[][]= new int[maxR][numQ];
   
  // survey constructor
  Survey(){
    // Setting "this" to "Customer Survey" so I do not have to copy the code 
    // and I can pass the "this" data to other variables.
    this("Customer Survey");
  }
   
  // survey constructor
  Survey(String surveyTitle){
    this.respondentId = 0; // passing respondentId and setting it to 0. 
    this.surveyTitle = surveyTitle; // setting this.surveyTitle to the new
                                    // constructor surveyTitle.
    
    // prints  
    System.out.println("Survey title = \"" + surveyTitle + "\"");
    
    // print label of Respondent ID then the respodentId variable
    System.out.println("Respondent ID = " + respondentId);
  }
  // Here are getters so if the next user needs to find what the values of numQ and numR.
  // create getNumQuestions variable to allow future users to find out how many questions 
  int 
  getNumQuestions(){
    return this.numQ;
  }
  
// create getNumRespondents variable to allow future users to find out how many respondents.
  int
  getNumRespondents(){
    return this.numR;
  }
  
  // We want the first number in respondentId to start at 1 so no IDs are 0.
  int generateRespondentId(){
    
    ++this.numR; // pull numR with "this" and increment so numR matches the 
                 // number of respondentIds.
    this.respondentId = this.numR;
    return this.numR; // return and increment passed respondentId so
    // respondentId starts at 1 as desired.
  }
  // week 2
  // prints out the name of the survey then displays results in a grid.
  void displaySurveyResults(){
    
    System.out.println(this.surveyTitle + " Survey Results: "); // pull survey
                 // title with "this" and add test to make the results title.
    System.out.println(""); // print space so there is a blank line after title. 

    //loop that starts on row 0 and prints each column.
    System.out.print("RespondentID "); // add "repsondentID" to label column.
    for(int col = 0; col < this.numQ; ++col){
      System.out.format("%4s", "Q" + new Integer(col+1).toString() );
      /* print out formated line with a max of 4 spaces in a string. Then I 
      * converted the col variable to a string so I could add the "Q" to the
      * column number */
    }
    System.out.println(""); // print a blank line so it is less bunched up.
     
    for(int row = 0; row < this.numR; ++row){
      // format row so it has a max of 10 integers with spaces between rows.
      System.out.format("%10d    ", row + 1);  
      for( int column = 0; column < this.numQ; ++column){
        // format pulled array so it has a max of 3 integers of space between 
        // the rows and column.
        System.out.format("%3d ", this.answerArray[row][column] );
      }  
      System.out.println(""); //Adds a blank line so it prints the inner loop on 
                              //a new line to make a table format.
    }
    System.out.println(""); //Adds a blank line to add space after loop results
  }
  // creature displayQuestionStats method with questNum parameter for use in test.
   void displayQuestionStats(int questNum){
      // print title of results with updating question numbers. 
      System.out.println(this.surveyTitle + " Question " + questNum + " Results ");
      System.out.println(""); // add blank space after title prints
       
      //Prints out the questions of the first column
      for(int respondent = 1; respondent <= this.numR; ++respondent){
        /*print questNum-1 because each question is actually 1 less because the 
         *program starts at 0 and goes to 9 to make a total of 10 questions. So if 
         *you want answer 10, you have to pull number 9 which is the last answer.*/
         System.out.println("Respondent " + respondent + ": " + this.answerArray[respondent-1][questNum-1] + " ");
      }
    System.out.println(""); //Adds a blank line to add space after loop results
  }
   
   void enterQuestions(){
       //ask user to enter survey questions until it reaches the index # of numQ.
       //Use the scanner to take the input from the user for each question. 
       System.out.println("Enter Survey Questions: ");
       
         for(int question = 0; question < numQ; ++question){
            // add 1 so questions start at #1 instead of 0.
            // Put the question + 1 in () so it reads 1 instead of 01
            System.out.println("Enter your Question for #" + (question + 1));
            questionArray[question] = scanLine.nextLine(); //scanline used to get everything on the line
         }
      System.out.println("");   
   }
   
   //Pass the row, column, and response variables to the answerArray
   void logResponse(int row, int column, int response){
       answerArray[row][column] = response;
   }
//week 3
   int topRatedQuestion(){
      // Declare variables needed   
      int tempTotal = 0;
      int hiTotal = Integer.MIN_VALUE;
      int questNum = 10;
   
      for (int column = 0; column < numQ; ++column){
         for (int row = 0; row < numR; ++row){ //this may be maxR
      
            // tempTotal is 0 then set that equal to itself so it translates into
            // tempTotal = 0 + the values input into the answerArray.
            tempTotal = tempTotal + this.answerArray[row][column]; // Reminder:
                               // to ALWAYS keey array values in original order.
         }      
      
         if (tempTotal >= hiTotal){ /* This checks to see if tempTotal is greater 
                                  * then hiTotal, if it is true then hiTotal is 
                                  * set to tempTotal and questNum is set to colum
                                  * minus 1 to account for the column starting at 
                                  * zero */
         
            hiTotal = tempTotal;
            questNum = column; 
      
         }
      
         tempTotal=0;  // Used to reset the loop after inner "for" loop reaches the  
                       // end condition.
      }
       
      return questNum +1; // return column/questNum. 
   
   }  

   int lowRatedQuestion(){
      //declare variables
      int tempTotal = 0;
      int lowTotal = Integer.MAX_VALUE; /* set to a number that all results must
                                         * less than or equal to 
                                         */
      int questIndex = this.numQ;       /* set to a number outside the range 
                                         * of question indices 
                                         */
   
      for (int column = 0; column < numQ; ++column){
         for (int row = 0; row < numR; ++row){
         
            // tempTotal is 0 then set that equal to itself so it translates into
            // tempTotal = 0 + the values input into the answerArray.
            tempTotal = tempTotal + this.answerArray[row][column]; 
         }
      
         if (tempTotal <= lowTotal){ /* This checks to see if tempTotal is greater 
                                 * then hiTotal, if it is true then hiTotal is 
                                 * set to tempTotal and questIndex is set to colum
                                 * minus 1 to account for the column starting at 
                                 * zero */
         
            lowTotal = tempTotal;
            questIndex = column;
   
         }
      
         tempTotal=0; // Used to reset the loop after inner "for" loop reaches the  
                   // end condition.
      }
   
      return questIndex + 1; // return the question number +1 because it starts at zero.
   }
   void presentQuestion(int questNum){
      System.out.println(this.questionArray[questNum - 1]);
      int response;
      while(true){
         response = scan.nextInt();
         if ((response > 0) && (response < 6)){
            break;
         }
         System.out.println("Response needs to be between 1-5.");
      }
      this.logResponse( respondentId - 1, questNum - 1, response);
   }

   void presentQuestion(int questNum, int respondentID){
      System.out.print("Respondent " + respondentID + ", please respond to the following survey question: ");
      this.respondentId = respondentID;
      this.presentQuestion(questNum);
   
   }

}