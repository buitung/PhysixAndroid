package fi.metropolia.VIOPE.physixviopeandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VectorDotProductActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vector_dot_product);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vector_dot_product, menu);
		return true;
	}

}
