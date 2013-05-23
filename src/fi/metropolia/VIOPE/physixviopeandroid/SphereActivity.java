package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.RoundingRounding;
import fi.metropolia.VIOPE.physixlib.Sphere;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SphereActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sphere);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sphere, menu);
		return true;
	}

	public void calculate(View view) {
		float r = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtRadiusSphere);
				r = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please give input in the right form.");
			}
			Sphere sphere = new Sphere(r);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsSphere);
			txtView.setText(RoundingRounding.RRR(Float.toString(sphere.Area())));
			txtView = (TextView) findViewById(R.id.lblVolumeAnsSphere);
			txtView.setText(RoundingRounding.RRR(Float.toString(sphere.Volume())));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsSphere);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsSphere);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsSphere);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsSphere);
			txtView.setText("");

		}
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("A sphere is a perfectly round geometrical"
				+ " and circular object in three-dimensional space."
				+ "\nA sphere of radius r . "
				+ "\nThe surface area of the sphere " + "\n\ta = 4*pi*r^2."
				+ "\nThe volume of the sphere " + "\n\tv = 4*pi*r^3 /3.\n");
		dialog.show();
	}

}
