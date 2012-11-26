package com.abhisheksabbarwal.CustomListViewWithImages;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter {

	// we use the constructor allowing to provide a List of objects for the data
    // to be binded.
	public ListViewAdapter(Context context, int textViewResourceId,
			List countryNames) {
		super(context, textViewResourceId, countryNames);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// A ViewHolder keeps references to children views to avoid unneccessary
        // calls
        // to findViewById() on each row.
		ViewHolder holder;
		
		
		// When convertView is not null, we can reuse it directly, there is no
        // need
        // to reinflate it. We only inflate a new View when the convertView
        // supplied
        // by ListView is null.
		if(convertView == null) {
			
			convertView = View.inflate(getContext(), R.layout.list_view_row, null);
			
			// Creates a ViewHolder and store references to the children
            // views
            // we want to bind data to.
			holder = new ViewHolder();
			
			holder.countryName = (TextView) convertView.findViewById(R.id.countryName);
			holder.listRowImg = (ImageView) convertView.findViewById(R.id.image);
			
			holder.listRowImg.setFocusable(false);
			holder.listRowImg.setFocusableInTouchMode(false);
			convertView.setTag(holder);
		}else {
			// Get the ViewHolder back to get fast access to the listrow elements
			holder = (ViewHolder) convertView.getTag();
		}
		
		// Bind the data efficiently with the holder.
		
		String countryName = (String) getItem(position);
		holder.countryName.setText(countryName);
		holder.listRowImg.setImageResource(R.drawable.ic_launcher);

		return convertView;
	}
	
	static class ViewHolder {
		
		TextView countryName;
		ImageView listRowImg;
	}

}
