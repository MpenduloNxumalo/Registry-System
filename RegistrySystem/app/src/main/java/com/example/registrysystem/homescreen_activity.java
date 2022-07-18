
	 
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

	public class homescreen_activity extends Activity {

	private Button createNewRegister,clocking_list;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
		createNewRegister = findViewById(R.id.createregister);
		clocking_list = findViewById(R.id.clockinglist);

		createNewRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getApplicationContext(),createregisterscreen_activity.class);
				startActivity(intent);
			}
		});

		


	
		
		//custom code goes here
	
	}
}
	
	