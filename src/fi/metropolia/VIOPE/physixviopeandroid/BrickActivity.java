package fi.metropolia.VIOPE.physixviopeandroid;

import fi.metropolia.VIOPE.exception.NegativeException;
import fi.metropolia.VIOPE.exception.ParsingException;
import fi.metropolia.VIOPE.physixlib.Brick;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BrickActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brick);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brick, menu);
		return true;
	}

	public void calculate(View view) throws NegativeException, ParsingException {
		float w = 0, h = 0, l = 0;
		try {
			try {
				EditText editText = (EditText) findViewById(R.id.txtWidthBrick);
				w = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtHeightBrick);
				h = Float.parseFloat(editText.getText().toString());
				editText = (EditText) findViewById(R.id.txtLengthBrick);
				l = Float.parseFloat(editText.getText().toString());
			} catch (Exception e) {
				throw new ParsingException(
						"Please enter inputs in the right form");
			}
			Brick brick = new Brick(w, h, l);
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsBrick);
			txtView.setText(Float.toString(brick.Area()));
			txtView = (TextView) findViewById(R.id.lblVolumeAnsBrick);
			txtView.setText(Float.toString((brick.Volume())));

		} catch (NegativeException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsBrick);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsBrick);
			txtView.setText("");
		} catch (ParsingException e) {
			Context context = getApplicationContext();
			CharSequence text = e.getMessage();
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			TextView txtView = (TextView) findViewById(R.id.lblAreaAnsBrick);
			txtView.setText("");
			txtView = (TextView) findViewById(R.id.lblVolumeAnsBrick);
			txtView.setText("");
		}
	}

}
