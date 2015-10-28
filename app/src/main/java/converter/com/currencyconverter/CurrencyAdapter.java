package converter.com.currencyconverter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CurrencyAdapter extends BaseAdapter {
	private final Context mContext;
	double sourceAmount = 1;
	int selectedPosition = 0;

	double conversion[][] = {
			{1, 0.7289, 1.12974, 136.156, 1.57155, 1.49167},
			{1.371930306, 1, 1.549924544, 186.796542736, 2.156057072, 2.046467279},
			{0.885159417, 0.645192699, 1, 120.51976561, 1.391072282, 1.320365748},
			{0.007344517, 0.005353418, 0.008297394, 1, 0.011542275, 0.010955595},
			{0.636314467, 0.463809615, 0.718869906, 86.638032516, 1, 0.9491712},
			{0.670389563, 0.488646953, 0.757365905, 91.277561391, 1.053550718, 1}};

	String country[] = {"Euros", "Pounds", "US Dollars", "Japanese Yen", "Austrailian Dollars", "Canadian Dollars"};

	public CurrencyAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return 6;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup viewGroup = null;
		convertView = mInflater.inflate(R.layout.list_item, viewGroup);

		TextView text = (TextView) convertView.findViewById(R.id.textView);

		double targetAmount = sourceAmount * conversion[selectedPosition][position];

		text.setText(targetAmount + " " + country[position]);

		return convertView;
	}

	public void calculate(String text) {
		sourceAmount = Double.parseDouble(text);
	}

	public void setSelectedPosition(int position) {
		selectedPosition = position;
	}
}
