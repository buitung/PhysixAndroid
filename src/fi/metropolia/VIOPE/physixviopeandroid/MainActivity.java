package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToGeoPage(View view){
		Intent intent = new Intent(this,GeometryActivity.class);
		startActivity(intent);
	}
	public void goToVecPage(View view){
		Intent intent = new Intent(this,VectorActivity.class);
		startActivity(intent);
	}
	public void goToTrigonometryPage(View view){
		Intent intent = new Intent(this,TrigonometryActivity.class);
		startActivity(intent);
	}
	public void goToProjectilePage(View view){
		Intent intent = new Intent(this,ProjActivity.class);
		startActivity(intent);
	}
}
