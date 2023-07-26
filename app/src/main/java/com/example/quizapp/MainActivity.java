package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.R;
import com.example.quizapp.*;

public class MainActivity extends AppCompatActivity {

    private  ActivityMainBinding binding;
    

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivity.inflate(getLayoutInflater());
       // View viewRoot = binding.getRoot();
        setContentView(binding);
    }

    private void setContentView(ActivityMainBinding binding) {
    }

    private static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return null;
    }


    public boolean firstQuestionVerify(RadioButton radioButton) {

        boolean firstResult;

        // Check which radio button was clicke
        firstResult = radioButton.isChecked();
        return firstResult;
    }


    public boolean secondQuestionVerify(RadioButton radioButton) {

        boolean secondResult;

        // Check which radio button was clicked
        secondResult = radioButton.isChecked();
        return secondResult;
    }


    public boolean thirdQuestionVerify(EditText userInput) {

        boolean thirdResult;

        // Check if the input answer is correct
        String userInputAnswer = userInput.getText().toString();
        thirdResult = userInputAnswer.contains("radiogroup") ||
                userInputAnswer.contains("Radiogroup") ||
                userInputAnswer.contains("Radio Group") ||
                userInputAnswer.contains("Radiogroup");
        return thirdResult;
    }


    public boolean fourthQuestionVerify() {

        boolean fourthResult = false;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (binding.fourthCheckbox1.isChecked() &&
                    binding.fourthCheckbox2.isChecked() &&
                    binding.fourthCheckbox3.isChecked() &&
                    binding.fourthCheckbox4.isChecked() &&
                    binding.fourthCheckbox5.isChecked()) {
                fourthResult = false;
            } else if (binding.fourthCheckbox1.isChecked() &&
                    binding.fourthCheckbox2.isChecked() &&
                    binding.fourthCheckbox4.isChecked() &&
                    binding.fourthCheckbox5.isChecked()) {
                fourthResult = true;
                //true;
            } else {
                fourthResult = false;
            }
        }
        return fourthResult;
    }


    public void submitAnswer(View view) {

        int correctCount = 0;
        String toastMessageHeader = getString(R.string.Toast_message_header);
        String toastMessageTail = getString(R.string.toastMessageTail);

        if (firstQuestionVerify(binding.radioButton)) {
            correctCount += 1;
        }
        if (secondQuestionVerify(binding.secondRadioButton4)) {
            correctCount += 1;
        }
        if (thirdQuestionVerify(binding.thirdQuestionUserInput)) {
            correctCount += 1;
        }
        if (fourthQuestionVerify()) {
            correctCount += 1;
        }

        Toast.makeText(this, toastMessageHeader + correctCount + toastMessageTail, Toast.LENGTH_SHORT).show();
    }
}