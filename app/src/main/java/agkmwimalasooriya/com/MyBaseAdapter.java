package agkmwimalasooriya.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    Context c;


    ArrayList<EmployeeModel> items ;


    public MyBaseAdapter(Context c, ArrayList<EmployeeModel> items) {
        this.c = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
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
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_layout, parent,false);
        }

        TextView tv = convertView.findViewById(R.id.textview);
        TextView tv2 = convertView.findViewById(R.id.textviewphone);
        tv.setText(items.get(position).getFirstName() + " "+items.get(position).getSecondName());
        tv2.setText(items.get(position).getPhone());
        return convertView;
    }
}
