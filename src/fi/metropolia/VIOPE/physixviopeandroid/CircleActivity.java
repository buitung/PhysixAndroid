package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.Circle;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CircleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.circle, menu);
		return true;
	}

	public void calculate(View view) {
		float r = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtRadiusCircle);
				r = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException("Please give input in the right form.");
			}
			Circle circle= new Circle(r);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsCircle);
			txtView.setText(Float.toString(circle.Area()));
			txtView = (TextView) findViewById(R.id.lblCircumferenceAnsCircle);
			txtView.setText(Float.toString(circle.Circumference()));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsCircle);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblCircumferenceAnsCircle);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsCircle);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblCircumferenceAnsCircle);
			txtView.setText("");

		}
	}

}
