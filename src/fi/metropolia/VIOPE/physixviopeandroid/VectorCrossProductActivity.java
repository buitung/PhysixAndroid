package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class VectorCrossProductActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_cross_product);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_cross_product, menu);
		return true;
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Circle Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("Vector is a geometric object that has magnitude "
				+ "(or length) and direction and can be added to "
				+ "other vectors according to vector algebra; "
				+ "it is frequently represented by a line segment "
				+ "with a definite direction, or graphically as an "
				+ "arrow, connecting an initial point A with a terminal point B."
				+ "\nAssume now that a and b are not necessarily "
				+ "equal vectors, but that they may have different "
				+ "magnitudes and directions."
				+ "\n\ta = a1.i + a2.j + a3.k"
				+ "\n\tb = b1.i + b2.j + b3.k"
				+ "\nThe cross product of a and b is: "
				+ "\n\ta x b = (a2*b3 - a3*b2)i + (a3*b1 - a1*b3)j + (a1*b2 - b1*a2)k");
		dialog.show();
	}

}
