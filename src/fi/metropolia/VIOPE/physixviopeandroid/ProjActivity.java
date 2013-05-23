package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

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
				+ "\n\th = v*v*sin(alpha)*sin(alpha)/(2*g).");
		dialog.show();
	}

}
