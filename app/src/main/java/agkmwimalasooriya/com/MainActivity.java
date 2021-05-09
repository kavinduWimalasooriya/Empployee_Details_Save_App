package agkmwimalasooriya.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button save, view_all;
    private EditText fname, sname, nic , phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.first_name);
        sname= findViewById(R.id.second_name);
        nic = findViewById(R.id.nic_number);
        phone = findViewById(R.id.phone_number);

        save = findViewById(R.id.save_button);
        view_all =findViewById(R.id.view_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployeeModel em;
                try {
                    em = new EmployeeModel(fname.getText().toString(), sname.getText().toString(),nic.getText().toString(),phone.getText().toString());
                    Toast.makeText(MainActivity.this, em.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    em = new EmployeeModel("error", "error","error","error");
                    Toast.makeText(MainActivity.this, "error "+ e.getMessage(), Toast.LENGTH_SHORT).show();

                }


                DBHelper dbHelper = new DBHelper(MainActivity.this);
                boolean add_successfully = dbHelper.addEmployee(em);
                Toast.makeText(MainActivity.this, "add successfully", Toast.LENGTH_SHORT).show();
                fname.setText(" ");
                sname.setText(" ");
                nic.setText(" ");
                phone.setText(" ");


            }
        });

        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "view button click", Toast.LENGTH_SHORT).show();
                Intent emp_view =new Intent(MainActivity.this,ViewEmployee.class);
                startActivity(emp_view);
            }
        });
    }
}