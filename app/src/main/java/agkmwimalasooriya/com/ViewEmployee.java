package agkmwimalasooriya.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployee extends AppCompatActivity {
    private ListView mView;
    public DBHelper my_dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);
        GridView gridView = findViewById(R.id.grid_view);


        my_dbHelper = new DBHelper(ViewEmployee.this);
        ArrayList<EmployeeModel> all = (ArrayList<EmployeeModel>) my_dbHelper.showEmployees();

// create a object of myBaseAdapter
        MyBaseAdapter baseAdapter = new MyBaseAdapter(this,all);
        gridView.setAdapter(baseAdapter);


    }
}