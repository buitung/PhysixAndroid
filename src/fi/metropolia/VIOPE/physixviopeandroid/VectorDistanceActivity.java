package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.ParsingException;
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

public class VectorDistanceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_distance);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_distance, menu);
		return true;
	}

	public void calculate(View view) throws ParsingException {
		float x1 = 0, x2 = 0, y1 = 0, y2 = 0, z1 = 0, z2 = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtVectorXVectorDistance1);
				x1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorYVectorDistance1);
				y1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorZVectorDistance1);
				z1 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorXVectorDistance2);
				x2 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorYVectorDistance2);
				y2 = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtVectorZVectorDistance2);
				z2 = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			Vector vector1 = new Vector(x1, y1, z1);
			Vector vector2 = new Vector(x2, y2, z2);
			TextView txtView = (TextView) findViewById(R.id.lblDistanceVectorDistance);
			txtView.setText(Float.toString(vector1.DistanceVec(vector2)));

		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblDistanceVectorDistance);
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
				+ "\nAssume now that a and b are not necessarily equal"
				+ " vectors, but that they may have different magnitudes and directions."
				+ "\n\ta = a1.i + a2.j + a3.k" + "\n\tb = b1.i + b2.j + b3.k"
				+ "\nThe distance between 2 vectors is: "
				+ " \n\td = SqrRoot( (a1-b1)^2 + (a2-b2)^2 + (a3-b3)^2 )");
		dialog.show();
	}

}
