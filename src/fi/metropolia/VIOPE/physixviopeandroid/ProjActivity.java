package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.MathUtils;
import fi.metropolia.VIOPE.physixlib.Projectile;
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

public class ProjActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_projectile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.proj, menu);
		return true;
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("A projectile is any object projected into space "
				+ "by the exertion of a force. The projectile described "
				+ "here is that an object is projected upward with an "
				+ "angle with the horizontal line. "
				+ "\nThe projected object of velocity v "
				+ "of and the angle \"alpha\" with the horizontal line."
				+ "\nGravity acceleration g = 9.8 m/s^2 "
				+ "\nThe projectile maximum traveil distance is "
				+ "\n\td = v*v*sin(2*alpha)/g. "
				+ "\nThe projectile total air time is "
				+ "\n\tt = 2*v*sin(alpha)/g. "
				+ "\nThe projectile maimum achieve height is "
				+ "\n\th = v*v*sin(alpha)*sin(alpha)/(2*g).\n");
		dialog.show();
	}

	public void convertDegAndRad(View view) {
		float angle = 0;
		try {
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianProjectile);
			EditText editText = (EditText) findViewById(R.id.txtAngleProj);
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
						editText.setText(RoundingRounding.RRR(Float
								.toString(MathUtils.Deg2Rad(angle))));
					} else {
						txtView.setText("Degree");
						editText.setText(RoundingRounding.RRR(Float
								.toString(MathUtils.Rag2Deg(angle))));
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
			TextView txtView = (TextView) findViewById(R.id.lblDistanceAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblHeightAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblAirTimeAnsProj);
			txtView.setText("");
		}
	}

	public void calculate(View view) throws NegativeException, ParsingException {
		float v = 0, a = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtVelocityProjectile);
				v = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtAngleProj);
				a = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			TextView txtView = (TextView) findViewById(R.id.lblDegreeRadianProjectile);
			if (txtView.getText().toString().equalsIgnoreCase("degree")) {
				a = MathUtils.Deg2Rad(a);
			}

			Projectile projectile = new Projectile(v, a);
			txtView = (TextView) findViewById(R.id.lblDistanceAnsProj);
			txtView.setText(RoundingRounding.RRR(Float.toString(Math
					.abs(projectile.Distance()))));
			txtView = (TextView) findViewById(R.id.lblHeightAnsProj);
			txtView.setText(RoundingRounding.RRR(Float.toString(Math
					.abs(projectile.Height()))));
			txtView = (TextView) findViewById(R.id.lblAirTimeAnsProj);
			txtView.setText(RoundingRounding.RRR(Float.toString(Math
					.abs(projectile.ProjTime()))));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblDistanceAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblHeightAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblAirTimeAnsProj);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblDistanceAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblHeightAnsProj);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblAirTimeAnsProj);
			txtView.setText("");
		}
	}

}
