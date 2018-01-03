package com.example.android.thequiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int usersScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void radioGroupChecker(int radioGroupId, int correctRadioButtonId) {
        RadioGroup radioGroup;
        radioGroup = (RadioGroup) findViewById(radioGroupId);
        int answerRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (answerRadioButtonId == correctRadioButtonId) {
            usersScore++;
        }
    }

    public void submitAnswers(View view) {

        //Check user's answer to question A - RadioButton type
        radioGroupChecker(R.id.radioGroupA, R.id.a2);

        //Check user's answer to question B - RadioButton type
        radioGroupChecker(R.id.radioGroupB, R.id.b4);

        //Check user's answer to question C - CheckBox type
        //The correct answers to question C are [true,false,true,false]
        //Here I check the checkboxes one by one and if they are all correct the users score is increased by one
        CheckBox answerCheckBox1 = (CheckBox) findViewById(R.id.c1);
        boolean usersCheckBoxAnswer1 = answerCheckBox1.isChecked();
        CheckBox answerCheckBox2 = (CheckBox) findViewById(R.id.c2);
        boolean usersCheckBoxAnswer2 = answerCheckBox2.isChecked();
        CheckBox answerCheckBox3 = (CheckBox) findViewById(R.id.c3);
        boolean usersCheckBoxAnswer3 = answerCheckBox3.isChecked();
        CheckBox answerCheckBox4 = (CheckBox) findViewById(R.id.c4);
        boolean usersCheckBoxAnswer4 = answerCheckBox4.isChecked();
        if ((usersCheckBoxAnswer1) && (!usersCheckBoxAnswer2) && (usersCheckBoxAnswer3) && (!usersCheckBoxAnswer4))
            usersScore++;

        // Get user's answer to question D - EditText type
        EditText capitalCity = (EditText) findViewById(R.id.d1);
        Editable capitalCityEditable = capitalCity.getText();
        String answerToCapitalCity = capitalCityEditable.toString();
        String correctCapitalCity = new String("Athens");
        if (answerToCapitalCity.equals(correctCapitalCity)) {
            usersScore++;
        }

        //Check user's answer to question E - CheckBox type
        //The correct answers to question C are [true,false,false,true]
        //Here I check the checkboxes one by one and if they are all correct the users score is increased by one
        answerCheckBox1 = (CheckBox) findViewById(R.id.e1);
        usersCheckBoxAnswer1 = answerCheckBox1.isChecked();
        answerCheckBox2 = (CheckBox) findViewById(R.id.e2);
        usersCheckBoxAnswer2 = answerCheckBox2.isChecked();
        answerCheckBox3 = (CheckBox) findViewById(R.id.e3);
        usersCheckBoxAnswer3 = answerCheckBox3.isChecked();
        answerCheckBox4 = (CheckBox) findViewById(R.id.e4);
        usersCheckBoxAnswer4 = answerCheckBox4.isChecked();
        if ((usersCheckBoxAnswer1) && (!usersCheckBoxAnswer2) && (!usersCheckBoxAnswer3) && (usersCheckBoxAnswer4))
            usersScore++;

        //Check user's answer to question F - RadioButton type
        radioGroupChecker(R.id.radioGroupF, R.id.f4);

        //User's results are shown in a toast message here
        Context context = getApplicationContext();
        CharSequence text = "Your score is " + usersScore + "/6 !";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //After the submit button is clicked, it becomes invisible so that the user
        // has to restart the app to play the quiz again.
        Button submitButton = (Button) view;
        submitButton.setVisibility(View.GONE);
    }
}
