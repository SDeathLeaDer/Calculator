package model;

import android.util.Log;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wilder on 18/06/15.
 */
public class Calculator {

   private String sExpression;
   private String sRegularExpression = "[1-9]\\d*[+*/-][1-9]\\d*([+*/-][1-9]\\d*)*";

   public Calculator(){
       sExpression = " ";
   }

   public void addCharacter(char character){
       sExpression = sExpression + character;
   }

   public int evaluateExpression(){
       Pattern pattern = Pattern.compile(sRegularExpression);
       Matcher matcher = pattern.matcher(sExpression);
       if(matcher.find()){

           Evaluator evaluator = new Evaluator();
           try {

               Double result = Double.valueOf(evaluator.evaluate(sExpression));
               return result.intValue();
           } catch (EvaluationException ee) {
               Log.e("Error", ee.getMessage());
               return -1;

           }
       }else{
            return -1;
       }

   }

    public String getsExpression() {
        return sExpression;
    }

    public void setsExpression(String sExpression) {
        this.sExpression = sExpression;
    }
}
