package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.Quad;
import android.os.Bundle;
import android.app.Activity;
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

}
