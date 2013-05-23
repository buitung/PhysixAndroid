package fi.metropolia.VIOPE.physixviopeandroid;

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

public class AngleCalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_angle_cal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.angle_cal, menu);
		return true;
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("In geometry, an angle is the figure formed by two rays, "
				+ "called the sides of the angle, sharing a common endpoint, called"
				+ " the vertex of the angle.Angle can be measure in degree or in radian. "
				+ "Radian describes the plane angle subtended by a circular arc as the length"
				+ " of the arc divided by the radius of the arc. One radian is the angle "
				+ "subtended at the center of a circle by an arc that is equal in length"
				+ " to the radius of the circle."
				+ "\nThe conversion between angle in degree and in radian:"
				+ "\n\tangle_in_degree =  angle_in_radian * 180(degree) / pi"
				+ "\nTake into account one corner in a right triangle with hypotenuse,"
				+ " opposite and adjacent sides, "
				+ "Sine, Cosine and Tangent of one angle are trigonometric functions, "
				+ "putting in the above context:" + "\n\tSin = Opp/Hypo"
				+ "\n\tCos = Adj/Hypo" + "\n\tTan = Opp/ Adj = Sin/Cos\n");
		dialog.show();
	}

	public void convertDegAndRad(View view) {
		float angle=0;
		try {
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianAngleCal);
			EditText editText = (EditText) findViewById(R.id.txtAngleAngleCalculation);
			if (editText.getText().toString().trim().length()==0){
				if (txtView.getText().toString().equalsIgnoreCase("degree")) {
					txtView.setText("Radian");
				} else{
					txtView.setText("Degree");
				}				
			} else{
				try{
					angle = Float.parseFloat(editText.getText().toString());
					if (txtView.getText().toString().equalsIgnoreCase("degree")) {
						txtView.setText("Radian");
						editText.setText(RoundingRounding.RRR(Float.toString(MathUtils.Deg2Rad(angle))));
					} else{
						txtView.setText("Degree");
						editText.setText(RoundingRounding.RRR(Float.toString(MathUtils.Rag2Deg(angle))));
					}
				} catch (Exception e){
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
			TextView txtView = (TextView) findViewById(R.id.lblSinAngleCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblCosAngleCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblTanAngleCalculation);
			txtView.setText("");
		}
	}

	public void calculate(View view) {
		float angle = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtAngleAngleCalculation);
				angle = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianAngleCal);
			if (txtView.getText().toString().equalsIgnoreCase("degree")) {
				angle = MathUtils.Deg2Rad(angle);
			}
			txtView = (TextView) findViewById(R.id.lblSinAngleCalculation);
			txtView.setText(RoundingRounding.RRR(Double.toString(Math.sin(angle))));
			txtView = (TextView) findViewById(R.id.lblCosAngleCalculation);
			txtView.setText(RoundingRounding.RRR(Double.toString(Math.cos(angle))));
			txtView = (TextView) findViewById(R.id.lblTanAngleCalculation);
			txtView.setText(RoundingRounding.RRR(Double.toString(Math.tan(angle))));
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblSinAngleCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblCosAngleCalculation);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblTanAngleCalculation);
			txtView.setText("");
		}
	}
}
