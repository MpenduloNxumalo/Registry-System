
	 
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
import android.os.Bundle;


import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registrysystem.R;

import utils.RegistryAdapter;

public class clockinlistscreen_activity extends Activity {

	private ImageView vector_ek1;


	private RecyclerView clockingListRecyclerview;
	private SearchView searchBar;
	private String[] Name;
	private String[] Surname;

		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.clockinlistscreen);
		Name = new String[]{"Mpendulo", "Jabulani", "Herman", "Thami", "Steve","Mpendulo","Themba","Tshego"};//getResources().getStringArray(R.array.Name);
		Surname = new String[]{"Nxumalo", "Maseko", "Maseko", "Buthelezi", "Sephiri","Sibeko","Molaudi","Mampane"};

		

		vector_ek1 = (ImageView) findViewById(R.id.vector_ek1);
		clockingListRecyclerview = findViewById(R.id.clocking_list_recyclerview);

		RegistryAdapter adapter = new RegistryAdapter(this,Name,Surname);
		clockingListRecyclerview.setAdapter(adapter);
		clockingListRecyclerview.setLayoutManager(new LinearLayoutManager(this));

	
		searchBar = findViewById(R.id.searchView);
		searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String s) {
				return false;
			}

			@Override
			public boolean onQueryTextChange(String s) {
				return false;
			}
		});
		//custom code goes here
	
	}
}
	
	