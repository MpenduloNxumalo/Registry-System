
	 
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

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

import utils.RegistryAdapter;

	public class createregister2screen_activity extends Activity {


	private ImageView vector_ek7;
	public String grade;
	public String Class;

	public TextView classRegisterName;
	String Name[], Surname[];
	Button generateReport, clockingList;

	RecyclerView registerRecyclerView;

	String s = Environment.getExternalStorageDirectory() + "/A.xls";

	private File filePath = new File(s);


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.createregister2screen);

		ActivityCompat.requestPermissions(this,
				new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.READ_EXTERNAL_STORAGE},
				PackageManager.PERMISSION_GRANTED);
		Intent intent = getIntent();

		grade = intent.getStringExtra("grade");
		Class = intent.getStringExtra("class");

		classRegisterName = findViewById(R.id.register_name);

		String name = "Grade "+grade+" "+Class+" register";
		classRegisterName.setText(name);


		Name = new String[]{"Mpendulo", "Jabulani", "Herman", "Thami", "Steve"};//getResources().getStringArray(R.array.Name);
		Surname = new String[]{"Nxumalo", "Maseko", "Maseko", "Buthelezi", "Sephiri"};

		registerRecyclerView = findViewById(R.id.register_recyclerview);
		RegistryAdapter adapter = new RegistryAdapter(this,Name,Surname);
		registerRecyclerView.setAdapter(adapter);
		registerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		generateReport = findViewById(R.id.generate_report);

		generateReport.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
				buttonCreateExcel(view);
				Toast.makeText(getApplicationContext(),"Report Generated",Toast.LENGTH_LONG).show();
			}
		});







	
		
		//custom code goes here
	
	}

	public void buttonCreateExcel(View view){
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet =  workbook.createSheet();

		for(int i = 0;i < 2;i++){
			for(int j = 0;j < Name.length;j++){
				HSSFRow row = sheet.createRow(i);
				HSSFCell cell = row.createCell(j);


				if(i == 0){
					cell.setCellValue(Name[j]);
				}
				else{
					cell.setCellValue(Surname[j]);
				}

			}
		}




		try{
			if(!filePath.exists()){
				filePath.createNewFile();
				Toast.makeText(getApplicationContext(),"file",Toast.LENGTH_SHORT).show();
			}

			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			workbook.write(fileOutputStream);

			if(fileOutputStream!=null){
				fileOutputStream.flush();
				fileOutputStream.close();
			}

		}
		catch (Exception e){
			e.printStackTrace();
		}




	}
}
	
	