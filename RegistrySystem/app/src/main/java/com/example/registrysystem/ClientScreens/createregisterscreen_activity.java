
	 
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
	

package com.example.registrysystem.ClientScreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.registrysystem.ClientScreens.createregister2screen_activity;
import com.example.registrysystem.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class createregisterscreen_activity extends Activity {

	private ImageView logo;
	private final OkHttpClient client = new OkHttpClient();
	private Spinner gradeSpinner;
	private Spinner classLetterSpinner;
	private ArrayAdapter<CharSequence>gradesAdapter;
	private ArrayAdapter<CharSequence>classLetterAdapter;
	public Button createRegister;
	public String Grade;
	public String ClassLetter;
	String URL = "http://127.0.0.1:5000/createregister";
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
				try {
					run();
					Intent intent = new Intent(getApplicationContext(), createregister2screen_activity.class);
					intent.putExtra("grade",Grade);
					intent.putExtra("class",ClassLetter);
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void run() throws Exception {
			Request request = new Request.Builder()
					.url(URL)
					.build();

			client.newCall(request).enqueue(new Callback() {
				@Override public void onFailure(Call call, IOException e) {
					e.printStackTrace();
				}

				@Override public void onResponse(Call call, Response response) throws IOException {
					Toast.makeText(createregisterscreen_activity.this, ""+response, Toast.LENGTH_SHORT).show();;
					try (ResponseBody responseBody = response.body()) {
						
					}
				}
			});
		}
}
	
	