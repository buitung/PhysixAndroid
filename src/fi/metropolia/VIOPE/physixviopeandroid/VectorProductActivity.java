package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class VectorProductActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_product);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_product, menu);
		return true;
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
				+ "\nAssume now that a is a vector:"
				+ "\n\ta = a1.i + a2.j + a3.k"
				+ "\nThe multiplication between a and number N is:"
				+ "\n\tMul_a = (N*a1)i + (N*a2)j + (N*a3)k");
		dialog.show();
	}

}
