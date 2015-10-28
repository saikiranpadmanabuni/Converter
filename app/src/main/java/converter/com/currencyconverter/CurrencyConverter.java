package converter.com.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class CurrencyConverter extends AppCompatActivity {

	private EditText editeTextAmount;
	private ListView listView;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency_converter);
		editeTextAmount = (EditText) findViewById(R.id.editText);
		spinner = (Spinner) findViewById(R.id.spinner);
		final CurrencyAdapter currencyAdapter = new CurrencyAdapter(this);
		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int selectedPosition = spinner.getSelectedItemPosition();
				currencyAdapter.setSelectedPosition(selectedPosition);
				currencyAdapter.calculate(editeTextAmount.getText().toString());
				currencyAdapter.notifyDataSetChanged();
			}
		});
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(currencyAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_currency_converter, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
