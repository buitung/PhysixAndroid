package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.Pyramid;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PyramidActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pyramid);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pyramid, menu);
		return true;
	}

	public void calculate(View view) throws NegativeException, ParsingException {
		float a = 0, b = 0, c = 0,h =0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtaPyramid);
				a = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtbPyramid);
				b = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtcPyramid);
				c = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txthPyramid);
				h = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			Pyramid pyramid= new Pyramid(a, b, c,h);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsPyramid);
			txtView.setText(Float.toString(pyramid.Area()));
			txtView = (TextView) findViewById(R.id.lblVolumeAnsPyramid);
			txtView.setText(Float.toString((pyramid.Volume())));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsPyramid);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsPyramid);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsPyramid);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsPyramid);
			txtView.setText("");

		} catch (IllegalArgumentException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsPyramid);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsPyramid);
			txtView.setText("");

		}
	}

}
