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

public class VectorSubtractActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_subtract);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_subtract, menu);
		return true;
	}

	public void calculate(View view) throws ParsingException {
		float x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtVectorXVectorSubtract1);
				x1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorYVectorSubtract1);
				y1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorXVectorSubtract2);
				x2 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorYVectorSubtract2);
				y2 = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			EditText editText = (EditText) findViewById(R.id.txtVectorZVectorSubtract1);
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
			editText = (EditText) findViewById(R.id.txtVectorZVectorSubtract2);
			if (editText.getText().toString().trim().length() == 0)
				z2 = 0;
			else {
				try {
					z2 = Float.parseFloat(editText.getText().toString());
				} catch (Exception e) {
					throw new ParsingException(
							"Please enter inputs in the right form");
				}
			}

			Vector vector1 = new Vector(x1, y1, z1);
			Vector vector2 = new Vector(x2, y2, z2);
			vector1.SubVec(vector2);
			TextView txtView = (TextView) findViewById(R.id.lblSubtractXVectorSubtract);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getX())));
			txtView = (TextView) findViewById(R.id.lblSubtractYVectorSubtract);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getY())));
			txtView = (TextView) findViewById(R.id.lblSubtractZVectorSubtract);
			txtView.setText(RoundingRounding.RRR(Float.toString(vector1.getZ())));

		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblSubtractXVectorSubtract);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblSubtractYVectorSubtract);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblSubtractZVectorSubtract);
			txtView.setText("");
		}
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("Vector is a geometric object that has magnitude "
				+ "(or length) and direction and can be added to "
				+ "other vectors according to vector algebra; it is "
				+ "frequently represented by a line segment with a "
				+ "definite direction, or graphically as an arrow, "
				+ "connecting an initial point A with a terminal point B."
				+ "\nAssume now that a and b are not necessarily equal vectors, "
				+ "but that they may have different magnitudes and directions."
				+ "\n\ta = a1.i + a2.j + a3.k" + "\n\tb = b1.i + b2.j + b3.k"
				+ "\nThe subtraction of a and b is"
				+ " \n\ta - b = (a1-b1)i + (a2-b2)j  + (a3-b3)k\n");
		dialog.show();
	}
}
