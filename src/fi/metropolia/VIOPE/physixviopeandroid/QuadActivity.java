package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.Quad;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quad);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quad, menu);
		return true;
	}

	public void calculate(View view) throws NegativeException, ParsingException {
		float w = 0, h = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtWidthQuad);
				w = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtHeightQuad);
				h = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			Quad quad = new Quad(w, h);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsQuad);
			txtView.setText(Float.toString(quad.Area()));
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsQuad);
			txtView.setText(Float.toString((quad.Perimeter())));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsQuad);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsQuad);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsQuad);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblPerimeterAnsQuad);
			txtView.setText("");

		}
	}

	public void onClickDialog(View view) {
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle("Information");
		TextView text = (TextView) dialog.findViewById(R.id.textContent);
		text.setText("A quad is one of the basic shapes in geometry. "
				+ "It is a polygon with four corners or vertices "
				+ "and four sides or edges which are line segments. "
				+ "The two opposite sides are equal. The adjacent "
				+ "two sides form a 90 degree angle."
				+ "\nA quad of width w and height h. "
				+ "If w = h the quad is a square, otherwise it is a rectangular"
				+ "\nThe area of the quad " + "\n\ta = w*h "
				+ "\nThe perimeter of the quad " + "\n\tp = 2*w+2*h");
		dialog.show();
	}

}
