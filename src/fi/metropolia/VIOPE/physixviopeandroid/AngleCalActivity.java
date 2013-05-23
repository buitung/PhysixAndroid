package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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
				+ "\n\tCos = Adj/Hypo" + "\n\tTan = Opp/ Adj = Sin/Cos");
		dialog.show();
	}

}
