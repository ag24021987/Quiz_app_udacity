package com.example.agupt23.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int userFinalScore = 0;
    CheckBox delhiCheckBox;
    CheckBox washingtonCheckBox;
    CheckBox mumbaiCheckBox;
    CheckBox phuketCheckBox;
    CheckBox narayanMurthyCheckBox;
    CheckBox nilekaniCheckBox;
    CheckBox ranbirCheckBox;
    CheckBox binnyCheckBox;
    RadioGroup ques1RadioGroup;
    RadioGroup ques2RadioGroup;
    RadioGroup ques7RadioGroup;
    RadioGroup ques9RadioGroup;
    RadioGroup question10RadioGroup;
    EditText facebookCeoEditText;
    Spinner question5Spinner;
    Spinner question6Spinner;
    CharSequence textToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delhiCheckBox = (CheckBox) findViewById(R.id.delhi_checkbox);
        washingtonCheckBox = (CheckBox) findViewById(R.id.washington_checkbox);
        mumbaiCheckBox = (CheckBox) findViewById(R.id.mumbai_checkbox);
        phuketCheckBox = (CheckBox) findViewById(R.id.phuket_checkbox);
        narayanMurthyCheckBox = (CheckBox) findViewById(R.id.murthy_checkbox);
        nilekaniCheckBox = (CheckBox) findViewById(R.id.nandan_nilekani_checkbox);
        ranbirCheckBox = (CheckBox) findViewById(R.id.ranbir_kapoor_checkbox);
        binnyCheckBox = (CheckBox) findViewById(R.id.binny_bansal_checkbox);
        ques1RadioGroup = (RadioGroup) findViewById(R.id.question_1_radio_group);
        ques2RadioGroup = (RadioGroup) findViewById(R.id.question_2_radio_group);
        ques7RadioGroup = (RadioGroup) findViewById(R.id.question_7_radio_group);
        ques9RadioGroup = (RadioGroup) findViewById(R.id.question_9_radio_group);
        question10RadioGroup = (RadioGroup) findViewById(R.id.question_10_radio_group);
        facebookCeoEditText = (EditText) findViewById(R.id.facebook_ceo_answer);

        //Add content to the two spinners
        question5Spinner = (Spinner) findViewById(R.id.microsoft_founder);
        question6Spinner = (Spinner) findViewById(R.id.apple_founder);
        ArrayAdapter<String> adapter;
        List<String> list = new ArrayList<String>();
        list.add(getResources().getString(R.string.spinner_default_selection));
        list.add(getResources().getString(R.string.steve_jobs));
        list.add(getResources().getString(R.string.larry_page));
        list.add(getResources().getString(R.string.bill_gates));
        list.add(getResources().getString(R.string.mark_zuckerberg));
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        question5Spinner.setAdapter(adapter);
        question6Spinner.setAdapter(adapter);
    }

    //Calcute the result of the answers selected by the users
    public void calculateResult(View v) {
        userFinalScore = 0;

        //Check Answer of Question 1
        int ques1SelectedRadioButton = ques1RadioGroup.getCheckedRadioButtonId();
        if (ques1SelectedRadioButton != -1) {
            RadioButton ques1SelectedAnswer = (RadioButton) findViewById(ques1SelectedRadioButton);
            if (ques1SelectedAnswer.getId() == R.id.trump_radio_button) {
                userFinalScore++;
            }
        }

        //Check Answer of Question 2
        int ques2SelectedRadioButton = ques2RadioGroup.getCheckedRadioButtonId();
        if (ques2SelectedRadioButton != -1) {
            RadioButton ques2SelectedAnswer = (RadioButton) findViewById(ques2SelectedRadioButton);
            if (ques2SelectedAnswer.getId() == R.id.modi_radio_button) {
                userFinalScore++;
            }
        }

        //Check Answer of Question 3
        String userAnswerQuestion3 = facebookCeoEditText.getText().toString();
        if(userAnswerQuestion3.toLowerCase().contains("mark zuckerberg")) {
            userFinalScore++;
        }

        //Check Answer of Question 4
        boolean isDelhiChecked = delhiCheckBox.isChecked();
        boolean isWashingtonChecked = washingtonCheckBox.isChecked();
        boolean isMumbaiChecked = mumbaiCheckBox.isChecked();
        boolean isPhuketChecked = phuketCheckBox.isChecked();

        if (isDelhiChecked && isWashingtonChecked && !isMumbaiChecked && !isPhuketChecked) {
            userFinalScore++;
        }

        //Check Answer of question 5
        String question5Answer = question5Spinner.getSelectedItem().toString();
        if (question5Answer.toLowerCase().equals("bill gates")) {
            userFinalScore++;
        }

        //Check Answer of question 6
        String question6Answer = question6Spinner.getSelectedItem().toString();
        if (question6Answer.toLowerCase().equals("steve jobs")) {
            userFinalScore++;
        }

        //Check Answer of question 7
        int ques7SelectedRadioButton = ques7RadioGroup.getCheckedRadioButtonId();
        if (ques7SelectedRadioButton != -1) {
            RadioButton ques7SelectedAnswer = (RadioButton) findViewById(ques7SelectedRadioButton);
            if (ques7SelectedAnswer.getId() == R.id.theresa_may_radio_button) {
                userFinalScore++;
            }
        }

        //Check Answer of question 8
        boolean isNarayanMurthyChecked = narayanMurthyCheckBox.isChecked();
        boolean isNilekaniChecked = nilekaniCheckBox.isChecked();
        boolean isRanbirChecked = ranbirCheckBox.isChecked();
        boolean isBinnyChecked = binnyCheckBox.isChecked();

        if (isNarayanMurthyChecked && isNilekaniChecked && !isRanbirChecked && !isBinnyChecked) {
            userFinalScore++;
        }

        //Check Answer of question 9
        int ques9SelectedRadioButton = ques9RadioGroup.getCheckedRadioButtonId();
        if (ques9SelectedRadioButton != -1) {
            RadioButton ques9SelectedAnswer = (RadioButton) findViewById(ques9SelectedRadioButton);
            if (ques9SelectedAnswer.getId() == R.id.riodejaneiro_radio_button) {
                userFinalScore++;
            }
        }

        //Check Answer of question 10
        int ques10SelectedRadioButton = question10RadioGroup.getCheckedRadioButtonId();
        if (ques10SelectedRadioButton != -1) {
            RadioButton ques10SelectedAnswer = (RadioButton) findViewById(ques10SelectedRadioButton);
            if (ques10SelectedAnswer.getId() == R.id.colombo_radio_button) {
                userFinalScore++;
            }
        }

        Context context = getApplicationContext();
        if (userFinalScore >= 7) {
            textToDisplay = "Wow! Your score is " + userFinalScore + " out of 10";
        } else if(userFinalScore >=4 && userFinalScore <7) {
            textToDisplay = "Average! Your score is " + userFinalScore + " out of 10";
        } else {
            textToDisplay = "Too Bad! Your score is " + userFinalScore + " out of 10";
        }
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, textToDisplay, duration);
        toast.show();
    }

    //Reset all the answers selected by the users
    public void resetAnswers(View v) {
        ques1RadioGroup.clearCheck();
        ques2RadioGroup.clearCheck();
        facebookCeoEditText.setText("");
        CheckBox[] checkboxes = {delhiCheckBox,washingtonCheckBox,mumbaiCheckBox,phuketCheckBox,narayanMurthyCheckBox,nilekaniCheckBox,ranbirCheckBox,binnyCheckBox};
        for (CheckBox thisCheckBox : checkboxes) {
            thisCheckBox.setChecked(false);
        }
        question5Spinner.setSelection(0);
        question6Spinner.setSelection(0);
        ques7RadioGroup.clearCheck();
        ques9RadioGroup.clearCheck();
        question10RadioGroup.clearCheck();

    }
}
