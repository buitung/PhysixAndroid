package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.physixlib.Brick;
import fi.metropolia.VIOPE.physixlib.Triangle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_triangle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.triangle, menu);
		return true;
	}
	public void calculate(View view){
		float a = 0,b = 0,c = 0;
		try{
			EditText editText = (EditText)findViewById(R.id.txtaTriangle);
			a = Float.parseFloat(editText.getText().toString());
			editText = (EditText)findViewById(R.id.txtbTriangle);
			b = Float.parseFloat(editText.getText().toString());
			editText = (EditText)findViewById(R.id.txtcTriangle);
			c= Float.parseFloat(editText.getText().toString());
		} catch (Exception e){
			Context context = getApplicationContext();
			CharSequence text = "Please enter three sides of triangle in the right form";
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView)findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText("");
			txtView = (TextView)findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText("");
		}
		try{
			Triangle triangle = new Triangle(a, b, c);
			TextView txtView = (TextView)findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText(Float.toString(triangle.Area()));
			txtView = (TextView)findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText(Float.toString((triangle.Perimeter())));
		} catch (IllegalArgumentException e){
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView)findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText("");
			txtView = (TextView)findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText("");
			
		}
	}
}
