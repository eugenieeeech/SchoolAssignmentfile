/**
 * CSCI1130 Assignment 3 Pie Sharing
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
 * Date          : 21/10/2019
 */
package exercise;

/**
 *
 * @author Cheng Ka Pui
 */
public class PieSharing {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        PanelDisplay score = new PanelDisplay();            //panel object
        
        PieQuestion trail1 = new PieQuestion("Trail 1",1,4,'+',1,2); //trail 1
        if(trail1.checkAnswer(trail1.getUserInputAnswer())){    //chek answer
        }else{ 
            score.updateHints(1,4,'+',1,2); // give hints if wrong
            trail1.getUserInputAnswer(); 
            score.updateHints(0, 1, ' ', 0, 1);                         //clean the hints
        }
        PieQuestion trail2 = new PieQuestion("Trail 2",2,5,'-',1,6); //trail 2
        if(trail2.checkAnswer(trail2.getUserInputAnswer())){ //check answer
        }else{ 
            score.updateHints(2,5,'-',1,6); //give hints if wrong
            trail2.getUserInputAnswer();
            score.updateHints(0, 1, ' ', 0, 1); //clean the hints
        }
      
        PieQuestion trail3 = new PieQuestion("Trail 3",1,7,'-',1,8); //trail 3
        if(trail3.checkAnswer(trail3.getUserInputAnswer())){ //check answer
        }else{ 
            score.updateHints(1,7,'-',1,8); //give hints if wrong
            trail3.getUserInputAnswer();
            score.updateHints(0, 1, ' ', 0, 1); // clean the hints
        }
        
        for(int i=1;i<=10;i++){     
        PieQuestion question = new PieQuestion("Q."+ i);    //prompting 10 random question        
        String user = question.getUserInputAnswer();       
        if (question.checkAnswer(user)){
            score.setScore(score.getScore()+1);         //correct then add score
            }else{
            score.updateHints(question.a,question.b,question.op,question.c,question.d); //give hints if wrong
            if(question.checkAnswer(question.getUserInputAnswer())){
                score.setScore(score.getScore()+1);//add score
                score.updateHints(0, 1, ' ', 0, 1);  //clean the hints
                }else{score.updateHints(0, 1, ' ', 0, 1);} //clean the hints
            }
        }        
        }
    }

    
