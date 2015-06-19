package com.aqpup.calculator;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.Calculator;


public class CalculatorActivity extends ActionBarActivity {

    private class CalculateListener implements View.OnClickListener{

        private char data;

        public CalculateListener(char data){
            this.data = data;
        }

        @Override
        public void onClick(View v) {

            switch (data){
                case '=':
                    int result = calculator.evaluateExpression();

                    if(result == -1){
                        tvInput.setText("Error");
                        calculator.setsExpression("");
                    }else{
                        tvInput.setText(result+"");
                        calculator.setsExpression(result+"");
                    }
                    break;
                case 'c':
                    tvInput.setText("");
                    calculator.setsExpression("");
                    break;
                default:

                    if(tvInput.getText().equals("Error")){
                        tvInput.setText("");
                    }
                    tvInput.setText(tvInput.getText().toString() + data);
                    calculator.addCharacter(data);
                    break;

            }
            Toast.makeText(context, "Haciendo click en el "+data ,Toast.LENGTH_LONG).show();
        }
    }

    Context context;
    Calculator calculator;
    TextView tvInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        context = this;
        calculator = new Calculator();

        Button bZero = (Button)findViewById(R.id.bZero);
        Button bOne = (Button)findViewById(R.id.bOne);
        Button bTwo = (Button)findViewById(R.id.bTwo);
        Button bThree = (Button)findViewById(R.id.bThree);
        Button bFour = (Button)findViewById(R.id.bFour);
        Button bFive = (Button)findViewById(R.id.bFive);
        Button bSix = (Button)findViewById(R.id.bSix);
        Button bSeven = (Button)findViewById(R.id.bSeven);
        Button bEight = (Button)findViewById(R.id.bEight);
        Button bNine = (Button)findViewById(R.id.bNine);

        Button bSum = (Button)findViewById(R.id.bSum);
        Button bRest = (Button)findViewById(R.id.bRest);
        Button bMulti = (Button)findViewById(R.id.bMulti);
        Button bDiv = (Button)findViewById(R.id.bDiv);
        Button bEqual = (Button)findViewById(R.id.bEqual);

        Button bClear = (Button)findViewById(R.id.bClear);

        tvInput = (TextView) findViewById(R.id.tvInput);

        //Create a object of the anonymous class that implements View.OnClickListener
        /*
        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Haciendo click en el 1",Toast.LENGTH_SHORT).show();
            }
        });
        */

        //Create a object of the CalculateListener class that implements View.OnClickListener
        bZero.setOnClickListener(new CalculateListener('0'));
        bOne.setOnClickListener(new CalculateListener('1'));
        bTwo.setOnClickListener(new CalculateListener('2'));
        bThree.setOnClickListener(new CalculateListener('3'));
        bFour.setOnClickListener(new CalculateListener('4'));
        bFive.setOnClickListener(new CalculateListener('5'));
        bSix.setOnClickListener(new CalculateListener('6'));
        bSeven.setOnClickListener(new CalculateListener('7'));
        bEight.setOnClickListener(new CalculateListener('8'));
        bNine.setOnClickListener(new CalculateListener('9'));

        bSum.setOnClickListener(new CalculateListener('+'));
        bRest.setOnClickListener(new CalculateListener('-'));
        bMulti.setOnClickListener(new CalculateListener('*'));
        bDiv.setOnClickListener(new CalculateListener('/'));

        bEqual.setOnClickListener(new CalculateListener('='));

        bClear.setOnClickListener(new CalculateListener('c'));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
