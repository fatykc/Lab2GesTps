package com.example.fatiha.lab2gestps;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.*;

import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

            TextView textDate,textTime,affichage ;
            ImageButton btFermer,btDate,btTime;
            private int annee = 0;
            private int anSelected=0,Aheure=0;

            DatePickerDialog datePickerDialog;
            TimePickerDialog timePickerDialog;
            StringBuffer resul = new StringBuffer();


            public void showDate() {

                resul.delete(0, resul.length());

                GregorianCalendar cal3= (GregorianCalendar) GregorianCalendar.getInstance();
                int an=cal3.get(GregorianCalendar.YEAR);
                int mois = cal3.get(GregorianCalendar.MONTH);
                int jour = cal3.get(GregorianCalendar.DAY_OF_MONTH);
                annee=an;






                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                textDate.setText(padding_str(dayOfMonth)+ "/"+ padding_str(month+1)+ "/"+ year);
                                anSelected=view.getYear();

                                annee=anSelected;
                                affichageInfos(annee);
                            }
                        },an,mois,jour);
                datePickerDialog.show();



            }

            public void showTime() {



                Calendar cal1 =Calendar.getInstance();
                int heure =cal1.get(Calendar.HOUR);
                int minutes = cal1.get(Calendar.MINUTE);
                final StringBuffer aHeure = new StringBuffer();



                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Aheure=hourOfDay;
                                if (Aheure>=12 && Aheure<18){

                                     aHeure.append("Après Midi");
                                }
                                if (Aheure>=18 && Aheure <=24){

                                    aHeure.append("soir");
                                }
                                if (Aheure>=0 && Aheure<6){

                                    aHeure.append("La nuit");
                                }
                                if (Aheure>=6 && Aheure<12){

                                    aHeure.append("Avant Midi");
                                }


                                textTime.setText(padding_str(hourOfDay)+ ":"+minute);
                                affichage.setText(resul.toString()+ aHeure.toString());

                                                            }
                        },heure,minutes,true);

                timePickerDialog.show();



            }
            public void affichageInfos (int annee){



                GregorianCalendar cal3= (GregorianCalendar) GregorianCalendar.getInstance();
                boolean anBissextile =cal3.isLeapYear(annee);

                if (anBissextile==true) {

                   // affichage.setText("Année Bissextile\n");
                    resul.append("Année Bissextile\n");

                }
                else {

                   // affichage.setText("Année non bissextile");
                    resul.append("Année non bissextile\n");


                }

                affichage.setText(resul.toString());

            }

            private static String padding_str(int c)
            {
                if(c>=10)
                return String.valueOf(c);

                else
                    return "0"+String.valueOf(c);
            }



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                textDate = findViewById(R.id.textView1);
                textTime = findViewById(R.id.textView2);
                affichage = findViewById(R.id.textView3);

                btFermer = findViewById(R.id.imageButton1);
                btDate = findViewById(R.id.imageButton2);
                btTime = findViewById(R.id.imageButton3);

                btFermer.setOnClickListener(this);
                btDate.setOnClickListener(this);
                btTime.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {



                 switch  (v.getId()) {

                    case R.id.imageButton1:

                        finish();
                        break;

                    case R.id.imageButton2 :
                        showDate();

                        break;

                     case R.id.imageButton3 :

                         showTime();
                         break;



                }


            }
}
