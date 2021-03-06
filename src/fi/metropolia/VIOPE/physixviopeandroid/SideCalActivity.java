package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.MathUtils;
import fi.metropolia.VIOPE.physixlib.RoundingRounding;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SideCalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_side_cal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.side_cal, menu);
		return true;
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("In geometry, an angle is the figure formed by "
				+ "two rays, called the sides of the angle, sharing"
				+ " a common endpoint, called the vertex of the angle."
				+ " Angle can be measure in degree or in radian. "
				+ "\nRadian describes the plane angle subtended by a "
				+ "circular arc as the length of the arc divided by the"
				+ " radius of the arc. One radian is the angle subtended"
				+ "  at the center of a circle by an arc that is equal in"
				+ "   length to the radius of the circle."
				+ "\nThe conversion between angle in degree and in radian:"
				+ "\n\tangle_in_degree =  angle_in_radian * 180(degree) / pi"
				+ "\nTake into account one corner in a right triangle with "
				+ "hypotenuse, opposite and adjacent sides"
				+ "\nHypotenuse is a longest side."
				+ "\nThe side next to the angle and not hypotenuse is adjacent side:"
				+ "\n\tAdj = Hypo * Cos"
				+ "\nThe side opposite to the angle is opposite side"
				+ "\n\tOpp = Hypo * Sin\n");
		dialog.show();
	}

	public void convertDegAndRad(View view) {
		float angle = 0;
		try {
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianSideCalculation);
			EditText editText = (EditText) findViewById(R.id.txtAngleSideCalculation);
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
			TextView txtView = (TextView) findViewById(R.id.lblOppositeSideCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblAdjacentSideCalculation);
			txtView.setText("");
		}
	}

	public void calculate(View view) {
		float angle = 0, hypo = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtAngleSideCalculation);
				angle = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtHypotenuseSideCalculation);
				hypo = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianSideCalculation);
			if (txtView.getText().toString().equalsIgnoreCase("degree")) {
				angle = MathUtils.Deg2Rad(angle);
			}
			txtView = (TextView) findViewById(R.id.lblAdjacentSideCalculation);
			txtView.setText(RoundingRounding.RRR(Float.toString(MathUtils.AdjacentSide(angle, hypo))));
			txtView = (TextView) findViewById(R.id.lblOppositeSideCalculation);
			txtView.setText(RoundingRounding.RRR(Float.toString(MathUtils.OppositeSide(angle, hypo))));
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAdjacentSideCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblOppositeSideCalculation);
			txtView.setText("");
		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAdjacentSideCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblOppositeSideCalculation);
			txtView.setText("");
		}
	}
}
