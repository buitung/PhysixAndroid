package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.RoundingRounding;
import fi.metropolia.VIOPE.physixlib.Triangle;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TriangleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_triangle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.triangle, menu);
		return true;
	}

	public void calculate(View view) throws NegativeException, ParsingException {
		float a = 0, b = 0, c = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtaTriangle);
				a = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtbTriangle);
				b = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtcTriangle);
				c = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			Triangle triangle = new Triangle(a, b, c);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText(RoundingRounding.RRR(Float.toString(triangle.Area())));
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText(RoundingRounding.RRR(Float.toString((triangle.Perimeter()))));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText("");

		} catch (IllegalArgumentException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsTriangle);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsTriangle);
			txtView.setText("");

		}
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("A triangle is one of the basic shapes in geometry. "
				+ "It is a polygon with three corners or vertices and "
				+ "three sides or edges which are line segments."
				+ "\nA triangle of  three sides : a, b and c. "
				+ "\nThe perimeter of the triangle" + "\n\tp = a+b+c"
				+ "\nThe area of the triangle "
				+ "\n\ta = SqrRoot( p*(p-a)*(p-b)*(p-c) )");
		dialog.show();
	}

}
