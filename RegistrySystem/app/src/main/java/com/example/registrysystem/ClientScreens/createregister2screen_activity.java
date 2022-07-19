
	 
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

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;


import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registrysystem.AdminScreens.exportscreen_activity;
import com.example.registrysystem.R;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(date);

		String d = strDate +" "+grade+Class+".xls";






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
				Toast.makeText(getApplicationContext(),"Generating report",Toast.LENGTH_SHORT).show();


				@SuppressLint("HandlerLeak") Handler handler = new Handler(){

					@Override
					public void handleMessage(@NonNull Message msg) {
						super.handleMessage(msg);
						Toast.makeText(getApplicationContext(),"Report Generated",Toast.LENGTH_LONG).show();
						Intent intent1 = new Intent(getApplicationContext(), donescreen_activity.class);
						startActivity(intent1);


					}
				};

				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						writeExcel(view);
						handler.sendEmptyMessage(0);
					}
				};

				Thread thread = new Thread(runnable);
				thread.start();
			}
		});

		//custom code goes here
	}


	public void writeExcel(View view){
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet =  workbook.createSheet();
			HSSFRow r = sheet.createRow(0);
			HSSFCell c_1 = r.createCell(0);
			HSSFCell c_2 = r.createCell(1);
			c_1.setCellValue("Name");
			c_2.setCellValue("Surname");

			for(int i = 1;i <= Name.length;i++){
				HSSFRow row = sheet.createRow(i);

				for(int j = 0;j < 2;j++){

					HSSFCell cell = row.createCell(j);
					if(j == 0){
						cell.setCellValue(Name[i-1]);
					}
					else{
						cell.setCellValue(Surname[i-1]);
					}

				}
			}




			try{
				if(!filePath.exists()){
					filePath.createNewFile();

					//Toast.makeText(getApplicationContext(),"file",Toast.LENGTH_SHORT).show();
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

	
	