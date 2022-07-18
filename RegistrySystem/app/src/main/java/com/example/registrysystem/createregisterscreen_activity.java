
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		homescreen
	 *	@date 		Sunday 17th of July 2022 09:16:15 AM
	 *	@title 		Client Screens
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.registrysystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class createregisterscreen_activity extends Activity {

	private ImageView logo;
	private Spinner gradeSpinner;
	private Spinner classLetterSpinner;
	private ArrayAdapter<CharSequence>gradesAdapter;
	private ArrayAdapter<CharSequence>classLetterAdapter;
	public Button createRegister;
	public String Grade;
	public String ClassLetter;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.createregisterscreen);
		gradeSpinner = findViewById(R.id.grade_spinner);
		classLetterSpinner = findViewById(R.id.class_letter_spinner);
		logo = (ImageView) findViewById(R.id.vector_ek6);


		gradesAdapter = ArrayAdapter.createFromResource(this, R.array.grades, android.R.layout.simple_spinner_item);
		gradesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		gradeSpinner.setAdapter(gradesAdapter);


		classLetterAdapter = ArrayAdapter.createFromResource(this, R.array.class_letter, android.R.layout.simple_spinner_item);
		classLetterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		classLetterSpinner.setAdapter(classLetterAdapter);






		createRegister = findViewById(R.id.createregister);
		createRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Grade = gradeSpinner.getSelectedItem().toString();
				ClassLetter = classLetterSpinner.getSelectedItem().toString();
				Intent intent = new Intent(getApplicationContext(),createregister2screen_activity.class);
				intent.putExtra("grade",Grade);
				intent.putExtra("class",ClassLetter);
				startActivity(intent);
			}
		});



		
		//custom code goes here
	
	}
}
	
	