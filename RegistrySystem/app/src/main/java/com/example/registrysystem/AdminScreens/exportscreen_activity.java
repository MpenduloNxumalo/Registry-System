
	 
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
	

package com.example.registrysystem.AdminScreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.registrysystem.R;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

	public class exportscreen_activity extends Activity {

	
	private View _bg__exportscreen_ek2;
	private ImageView vector_ek8;
	private View rectangle_3_ek3;
	private TextView export_report;
	private View rectangle_7_ek1;
	private ImageView f6188_school_attendance_register_inside_form_rbe_1;



	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.exportscreen);


		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);


		
		//custom code goes here
	
	}

		private static void readExcelFile(Context context, String filename) {

			if (!isExternalStorageAvailable() || isExternalStorageReadOnly())
			{
				Log.w("FileUtils", "Storage not available or read only");
				return;
			}

			try{
				// Creating Input Stream
				File file = new File(context.getExternalFilesDir(null), filename);
				FileInputStream myInput = new FileInputStream(file);

				// Create a POIFSFileSystem object
				POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

				// Create a workbook using the File System
				HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

				// Get the first sheet from workbook
				HSSFSheet mySheet = myWorkBook.getSheetAt(0);

				/** We now need something to iterate through the cells.**/
				Iterator<Row> rowIter = mySheet.rowIterator();

				while(rowIter.hasNext()){
					HSSFRow myRow = (HSSFRow) rowIter.next();
					Iterator<Cell> cellIter = myRow.cellIterator();
					while(cellIter.hasNext()){
						HSSFCell myCell = (HSSFCell) cellIter.next();
						Log.w("FileUtils", "Cell Value: " +  myCell.toString());
						Toast.makeText(context, "cell Value: " + myCell.toString(), Toast.LENGTH_SHORT).show();
					}
				}
			}catch (Exception e){e.printStackTrace(); }

			return;
		}

		public static boolean isExternalStorageReadOnly() {
			String extStorageState = Environment.getExternalStorageState();
			if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
				return true;
			}
			return false;
		}

		public static boolean isExternalStorageAvailable() {
			String extStorageState = Environment.getExternalStorageState();
			if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
				return true;
			}
			return false;
		}
	}
	
	