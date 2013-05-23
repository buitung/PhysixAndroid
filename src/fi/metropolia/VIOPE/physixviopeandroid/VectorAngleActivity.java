package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.MathUtils;
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

public class VectorAngleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_angle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_angle, menu);
		return true;
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("Vector is a geometric object that has magnitude (or length) "
				+ "and direction and can be added to other vectors according to "
				+ "vector algebra; it is frequently represented by a line segment "
				+ "with a definite direction, or graphically as an arrow, connecting "
				+ "an initial point A with a terminal point B.\nAssume now that a and "
				+ "b are not necessarily equal vectors, but that they may have different "
				+ "magnitudes and directions. \nAngle \"alpha\" between two vector can be "
				+ "decided as\n\tcos(\"alpha\") = (a.b) / (|a|.|b|)");
		dialog.show();
	}

	public void calculate(View view) throws NegativeException {
		float x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtX1VectorAngle);
				x1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtY1VectorAngle);
				y1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtX2VectorAngle);
				x2 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtY2VectorAngle);
				y2 = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			EditText editText = (EditText) findViewById(R.id.txtZ1VectorAngle);
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
			editText = (EditText) findViewById(R.id.txtZ2VectorAngle);
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
			float angle = vector1.AngleVec(vector2);
			TextView txtView = (TextView) findViewById(R.id.lblAngleAnswerVectorAngle);
			TextView txtView2 = (TextView) findViewById(R.id.lblDegreeRadVectorAngle);
			if (txtView2.getText().toString().equalsIgnoreCase("degree")) {
				angle = MathUtils.Rag2Deg(angle);
			}
			txtView.setText(RoundingRounding.RRR(Float.toString(angle)));

		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAngleAnswerVectorAngle);
			txtView.setText("");
		}
	}

	public void convertDegAndRad(View view) {
		float angle = 0;
		try {
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadVectorAngle);
			TextView editText = (TextView) findViewById(R.id.lblAngleAnswerVectorAngle);
			if (editText.getText().toString().trim().length() == 0) {
				if (txtView.getText().toString().equalsIgnoreCase("degree")) {
					txtView.setText("Radian");
				} else {
					txtView.setText("Degree");
				}
			} else {
				try {
					angle = Float.parseFloat(editText.getText().toString());
					if (txtView.getText().toString().equalsIgnoreCase("degree")) {
						txtView.setText("Radian");
						editText.setText(RoundingRounding.RRR(Float.toString(MathUtils
								.Deg2Rad(angle))));
					} else {
						txtView.setText("Degree");
						editText.setText(RoundingRounding.RRR(Float.toString(MathUtils
								.Rag2Deg(angle))));
					}
				} catch (Exception e) {
					throw new ParsingException(
							"Please enter inputs in the right form");
				}
			}
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAngleAnswerVectorAngle);
			txtView.setText("");
		}
	}

}
