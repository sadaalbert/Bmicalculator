 package com.example.bmicaluclator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

 public class MainActivity extends AppCompatActivity {
// class variable also called 'fields'.
    private TextView resulText;

     private Button calculateButton;
     private RadioButton woman;
     private RadioButton man;
     private EditText yourage;
     private EditText yourfeet;
     private EditText yourinches;
     private EditText yourweight;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

// this is a local variable : which stay in this memeory only in this block of code (problem : if we take to it in findviews then this is out of scope
        //to solve this problem we use class variable which is avaliable to every method of the class.
   //     Button calulatetotal = findViewById(R.id.button_calculate);


         setterbuttonclicklistner();

         TextView resulthai=findViewById(R.id.text_view_result);




    }

     private void findViews(){
         resulText = findViewById(R.id.text_view_result);
         woman = findViewById(R.id.radio_button_female);
         man = findViewById(R.id.radio_button_male);
         yourage = findViewById(R.id.edit_text_age);
         yourfeet = findViewById(R.id.edit_text_feet);
         yourinches = findViewById(R.id.edit_text_inches);
         yourweight = findViewById(R.id.edit_text_weight);
         calculateButton = findViewById(R.id.button_calculate);

     }
     private void setterbuttonclicklistner() {
         calculateButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                // Toast.makeText(MainActivity.this,"we can react to button",Toast.LENGTH_LONG).show();
                 double bmiresult = calculatebmi();


                 String agetext = yourage.getText().toString();
                 int age = Integer.parseInt(agetext);

                 if(age >= 18){
                     displayresult(bmiresult);
                 }
                 else{
                     displayGuiedance(bmiresult);
                 }
             }
         });
     }



     private double calculatebmi() {
         String ageText = yourage.getText().toString();
         String feetText = yourfeet.getText().toString();
         String inchesText = yourinches.getText().toString();
         String weightText = yourweight.getText().toString();

         // resulText.setText("Age"+ageText+","+"feet:"+feetText+","+"inches"+inchesText+","+"weight:"+weightText);
         //convert string to integer variables
        // int age = Integer.parseInt(ageText);
         int feet = Integer.parseInt(feetText);
         int inches = Integer.parseInt(inchesText);
         int weight = Integer.parseInt(weightText);

         int totalInches = (feet * 12) + inches;
         //height in meters is the inches multiplied by 0.0254.
         double heightinmeters = totalInches * 0.0254;
         //bmi formula = weight in kg divieded by height in meters squared.
         return weight / (heightinmeters * heightinmeters);

     }

     private void displayresult(double bmi){
         // we must convert the decimal /double into a string for our textview
        // String bmires = String.valueOf(bmi);

         DecimalFormat mydecimalFormatter = new DecimalFormat("0.00");
         String bmitextresult=mydecimalFormatter.format(bmi);

         String fullResultstring;

         if(bmi<18.5)
         { // display underweigth
             fullResultstring = bmitextresult+"u are UNDERWEIGHT!!";

         }
         else if(bmi>25)
         {
             //display overweight
             fullResultstring = bmitextresult+"u are OVERWEIGHT!!"
         }
         else
         {
             fullResultstring = bmitextresult+"you are healthy";

         }

        // resulText.setText(bmires);
        // resulText.setText(bmitextresult);
         resulText.setText(fullResultstring);

     }
     private void displayGuiedance(double bmi){
         DecimalFormat mydecimalFormatter = new DecimalFormat("0.00");
         String bmitextresult=mydecimalFormatter.format(bmi);
         String fullresultstring;
         if(man.isChecked())
         {
       // dispaly boy guiedence
          fullresultstring = bmitextresult+"- as u are under 18,please consult to doctor for healthy body for boys";
         }
         else if(woman.isChecked())
         {//display girl guiedence
             fullresultstring = bmitextresult+"- as u are under 18,please consult to doctor for healthy body for girls";

         }
         else{
             fullresultstring = bmitextresult+"- as u are under 18,please consult to doctor for healthy bmi range";
         }
         resulText.setText(fullresultstring);
     }
 }
















 //layout  and xml files :
/*
layout file : is a just set of instructions some data for what goes where.it is an architecutral blueprint that is read and processed when the screen first loads.
-xml = extensible(-> extendable)markup language .it is used to describe data . intended to be human readable.it is used in android for various resources such as layout ,
storing words,dimensions,colours.
-file location - app->main->res(resource folder)->layout->file
-reformat code.
-android layout elements that contain other views(such as LinearLayout ,ConstraintLayout).etc are called "viewGroups",or you can think of them as "Container".

-meaining of this line : xmlns:android="http://schemas.android.com/apk/res/android"
In an Android application, XML namespace declarations are used to define the structure and format of XML elements and attributes that are specific to the Android platform.
 The "android" namespace contains a set of predefined XML attributes that can be used to define various properties of Android application components, such as activities,
 services, and broadcast receivers.By declaring the "android" namespace in the manifest file, developers can use the predefined Android-specific attributes in their
 application components and ensure that their app is compatible with the Android platform.

 -meaining of this line  setContentView(R.layout.activity_main); : telling android to take the layout file and read it and set it to show a view on the
 mobile.

  String alertText = "this is my variable text";

-Toast.makeText(this,alertText/*,"hello users this is my first app developed by me - aniket"*//*,Toast.LENGTH_LONG).show();
some popup message will come in the app

-after making varibale of type textview we can assign a text and it  will run through this code by this command:resultText.setText("corgi is the best beautiful dog ");



*/

