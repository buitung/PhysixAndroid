package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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
