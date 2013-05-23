package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.RoundingRounding;
import fi.metropolia.VIOPE.physixlib.Vector;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VectorInformationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_information);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_information, menu);
		return true;
	}

	public void calculate(View view) throws ParsingException {
		float x1 = 0, y1 = 0, z1 = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.lblVectorXVectorInformation1);
				x1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.lblVectorYVectorInformation1);
				y1 = Float.parseFloat(editText.getText().toString());

			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			EditText editText = (EditText) findViewById(R.id.lblVectorZVectorInformation1);
			if (editText.getText().toString().trim().length() == 0)
				z1 = 0;
			else {
				try {
					z1 = Float.parseFloat(editText.getText().toString());
				} catch (Exception e) {
					throw new ParsingException(
							"Please enter inputs in the right form");
				}
			}

			Vector vector1 = new Vector(x1, y1, z1);
			TextView txtView = (TextView) findViewById(R.id.lblMagnitudeVectorInformation);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.Magnitude())));
			vector1.Normalize();
			txtView = (TextView) findViewById(R.id.lblNormalizedXVectorInformation);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getX())));
			txtView = (TextView) findViewById(R.id.lblNormalizedYVectorInformation);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getY())));
			txtView = (TextView) findViewById(R.id.lblNormalizedZVectorInformation);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getZ())));

		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblMagnitudeVectorInformation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblNormalizedXVectorInformation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblNormalizedYVectorInformation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblNormalizedZVectorInformation);
			txtView.setText("");

		}
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("Vector is a geometric object that has magnitude "
				+ "(or length) and direction and can be added to other "
				+ "vectors according to vector algebra; it is frequently "
				+ "represented by a line segment with a definite direction, "
				+ "or graphically as an arrow, connecting an initial point A "
				+ "with a terminal point B."
				+ "\nAssume now that a is a vector"
				+ "\n\ta = a1.i + a2.j + a3.k" + "\nMagnitude of vector a is: "
				+ "\n\tMag_a = SqrRoot( a1^2 + a2^2 + a3^2 )"
				+ "\nNormalized vector of a is:"
				+ "\n\tNorm_a = (a1/Mag_a)i + (a2/Mag_a)j + (a3/Mag_a)k");
		dialog.show();
	}

}
