package com.example.fergu.calculator_ferguson;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button clear;
    Button clearEntry;
    Button divide;
    Button multiply;
    Button seven;
    Button eight;
    Button nine;
    Button minus;
    Button four;
    Button five;
    Button six;
    Button one;
    Button two;
    Button three;
    Button plusminus;
    Button zero;
    Button point;
    Button equal;
    Button plus;
    TextView display;
    Boolean firstPress = true;
    String firstOperand= "";
    String secondOperand= "";
    String operation = "";
    boolean pressedNewThing = false;
    boolean pressedEquals = false;
    String storedVar = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear = findViewById(R.id.clear);
        clearEntry = findViewById(R.id.clear_entry);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        minus = findViewById(R.id.minus);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        plus = findViewById(R.id.plus);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        plusminus = findViewById(R.id.plusminus);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);//make all the buttons
        display = findViewById(R.id.display);
        if(savedInstanceState != null){
            display.setText(savedInstanceState.getCharSequence("display"));
            pressedNewThing = savedInstanceState.getBoolean("new");
            pressedEquals= savedInstanceState.getBoolean("equals");
            firstPress= savedInstanceState.getBoolean("first");
            operation= savedInstanceState.getString("operation");
            firstOperand = savedInstanceState.getString("firstOp");
            secondOperand = savedInstanceState.getString("secondOp");
            storedVar = savedInstanceState.getString("stored");
        }

        one.setOnClickListener(click);
        two.setOnClickListener(click);
        three.setOnClickListener(click);
        four.setOnClickListener(click);
        five.setOnClickListener(click);
        six.setOnClickListener(click);
        seven.setOnClickListener(click);
        eight.setOnClickListener(click);
        nine.setOnClickListener(click);
        zero.setOnClickListener(click);
        minus.setOnClickListener(click);
        plus.setOnClickListener(click);
        divide.setOnClickListener(click);
        multiply.setOnClickListener(click);
        clear.setOnClickListener(click);
        clearEntry.setOnClickListener(click);
        plusminus.setOnClickListener(click);
        point.setOnClickListener(click);
        equal.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                //FOR NUMBER BLOCK PUT TEXT AS APPLICABLE
                //EITHER APPEND OR REPLACE ZERO DEPENDING ON WHETHER ITS THE FIRST CHANGE
                case R.id.one:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.one));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.one);
                        firstPress = false;

                    }
                    break;
                case R.id.two:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.two));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.two);
                        firstPress = false;
                    }
                    break;
                case R.id.three:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.three));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.three);
                        firstPress = false;
                    }
                    break;
                case R.id.four:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.four));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.four);
                        firstPress = false;
                    }
                    break;
                case R.id.five:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.five));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.five);
                        firstPress = false;
                    }
                    break;
                case R.id.six:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.six));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.six);
                        firstPress = false;
                    }
                    break;
                case R.id.seven:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.seven));
                    if(firstPress) {
                        plus.setEnabled(true);
                        display.setText(R.string.seven);
                    }
                    break;
                case R.id.eight:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.eight));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.eight);
                        firstPress = false;
                    }
                    break;
                case R.id.nine:
                    pressedNewThing = true;
                    if(!firstPress)
                        display.append(getString(R.string.nine));
                    if(firstPress) {
                        allowButtons();
                        display.setText(R.string.nine);
                        firstPress = false;
                    }
                    break;
                case R.id.zero:
                    pressedNewThing = true;
                    if(!firstPress) {
                        display.append(getString(R.string.zero));
                    }
                    break;
                //FOR PLUS MINUS
                //IF THERE ARE ONLY ZEROES IN THE STRING ex: 0.0000 DONT PREPEND
                //IF THERE IS A '-' REMOVE IT
                case R.id.plusminus:
                    //get temp string
                    String temp = display.getText().toString();
                    boolean justZeros = true;
                    for (char ch : temp.toCharArray()) {
                        if (ch != '0' && ch != '.') {
                            justZeros = false;
                        }
                    }
                    //if the first thing isn't a - and it's not all zeroes prepend a minus
                    if (temp.length() > 0 && temp.charAt(0) != '-' && !justZeros) {
                        temp = (getString(R.string.minus) + temp);
                        display.setText((CharSequence) temp);
                    }
                    // if it is a - get rid of it
                    else if (temp.length() > 0 && temp.charAt(0) == '-' && !justZeros) {
                        temp = temp.substring(1);
                        display.setText((CharSequence) temp);
                    }
                    break;
                //IF THERE'S A DECIMAL DONT PUT ONE!!!!!!
                case R.id.point:
                    int numDots = 0;
                    for (char ch : display.getText().toString().toCharArray()) {
                        if(ch == '.'){
                            numDots++;
                        }
                    }
                    if(numDots ==0) {
                        display.append(getString(R.string.dot));
                        firstPress = false;
                        allowButtons();
                    }
                    break;

                //THESE CLEAR THE TEXT AND clear CLEARS NOT ONLY TEXT BUT OPERATIONS
                case R.id.clear:
                    display.setText(R.string.zero);
                    firstPress = true;
                    firstOperand = "";
                    secondOperand = "";
                    operation = "";
                    allowButtons();
                    pressedEquals = false;
                    break;
                case R.id.clear_entry:
                    display.setText(R.string.zero);
                    firstPress = true;
                    break;

                //SET THE OPERATION AND THE OPERAND AND IF THEY PRESS EQUAL TAKE THEM AND CALCULATE
                //TODO: IF AN OPERATION HAS BEEN TOUCH ALREADY, CALL CALCULATE AND MAKE IT THE FIRST OPERAND
                case R.id.multiply:
                    //if there's a calculation waiting
                    if(!firstOperand.equals("") && pressedNewThing &&pressedEquals){
                        secondOperand = display.getText().toString();
                        calculate();
                    }
                    //just the basic things
                    multiply.setEnabled(false);
                    pressedNewThing = false;
                    operation = "multiplication";
                    firstOperand = display.getText().toString();
                    firstPress = true;
                    pressedEquals = false;
                    break;
                case R.id.divide:
                    if(!firstOperand.equals("") && pressedNewThing && !pressedEquals){
                        secondOperand = display.getText().toString();
                        calculate();
                    }
                    //just the basic things
                    divide.setEnabled(false);
                    pressedNewThing = false;
                    operation = "division";
                    firstOperand = display.getText().toString();
                    firstPress = true;
                    pressedEquals = false;
                    break;
                case R.id.plus:
                    if(!firstOperand.equals("") && pressedNewThing && !pressedEquals){
                        secondOperand = display.getText().toString();
                        calculate();
                    }
                    //just the basic things
                    plus.setEnabled(false);
                    pressedNewThing = false;
                    operation = "addition";
                    firstOperand = display.getText().toString();
                    firstPress = true;
                    pressedEquals  = false;
                    break;
                case R.id.minus:
                    if(!firstOperand.equals("") && pressedNewThing &&!pressedEquals){
                        secondOperand = display.getText().toString();
                        calculate();
                    }
                    //just the basic things
                    minus.setEnabled(false);
                    pressedNewThing = false;
                    operation = "subtraction";
                    firstOperand = display.getText().toString();
                    firstPress = true;
                    pressedEquals = false;
                    break;

                case R.id.equal:
                    if(operation.equals("")){
                        break;
                    }
                    if(!pressedEquals){
                        storedVar = firstOperand;
                        secondOperand = display.getText().toString();
                        calculate();
                        pressedEquals = true;
                        break;
                    }
                    if(pressedEquals){
                        //take the stored var
                        firstOperand = display.getText().toString();
                        calculate();
                        firstPress = true;
                    }
                    System.out.println(firstOperand + " " + secondOperand + " " + operation);
                    break;
            }
        }
    };

    public void calculate(){
        double ans = 0.0;
        System.out.println(operation+ " "+ firstOperand + " " + secondOperand);

        switch (operation) {
            case "multiplication":
                ans = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
                break;
            case "addition":
                ans = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
                break;
            case "division":
                ans = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
                break;
            case "subtraction":
                ans = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
                break;
        }
        String answer = Double.toString(ans);
        display.setText((CharSequence)answer);
        firstOperand = answer;

    }
    public void allowButtons(){
        plus.setEnabled(true);
        minus.setEnabled(true);
        divide.setEnabled(true);
        multiply.setEnabled(true);
    }
    public boolean aButtonDisabled(){
        return !(plus.isEnabled() && minus.isEnabled() && divide.isEnabled() && multiply.isEnabled());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence("display", display.getText());
        outState.putBoolean("equals", pressedEquals);
        outState.putBoolean("new", pressedNewThing);
        outState.putBoolean("first",firstPress);
        outState.putString("stored", storedVar);
        outState.putString("operation", operation);
        outState.putString("firstOp", firstOperand);
        outState.putString("secondOp", secondOperand);

    }
}