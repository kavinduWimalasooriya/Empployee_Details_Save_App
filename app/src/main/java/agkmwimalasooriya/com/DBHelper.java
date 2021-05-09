package agkmwimalasooriya.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static final String EMPLOYEE_TABLE = "Employee_details";
    public static final String NIC = "nic";
    public static final String FIRST_NAME = "firstName";
    public static final String SECOND_NAME = "secondName";
    public static final String PHONE = "phone";

    public DBHelper(@Nullable Context context) {
        super(context, "Employee.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="create table "+EMPLOYEE_TABLE+ "(" + NIC + " TEXT primary key," + FIRST_NAME + " TEXT," + SECOND_NAME + " TEXT," + PHONE + " TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addEmployee(EmployeeModel employeeModel){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NIC,employeeModel.getNicNumber());
        cv.put(FIRST_NAME,employeeModel.getFirstName());
        cv.put(SECOND_NAME,employeeModel.getSecondName());
        cv.put(PHONE,employeeModel.getPhone());

        long insert_value=db.insert(EMPLOYEE_TABLE, null, cv);
         if ( insert_value== -1){
             return false;
         }else {
             return true;
         }



    }
    public List<EmployeeModel> showEmployees(){
        List<EmployeeModel> allEmployee = new ArrayList<EmployeeModel>();
        String select_query = "SELECT * FROM "+EMPLOYEE_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(select_query,null);
        if(cursor.moveToFirst()){
            do {
                String emp_nic = cursor.getString(0);
                String emp_fname = cursor.getString(1);
                String emp_sname = cursor.getString(2);
                String emp_phone= cursor.getString(3);
                EmployeeModel employeeModel = new EmployeeModel(emp_fname,emp_sname,emp_nic,emp_phone);
                allEmployee.add(employeeModel);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return allEmployee;
    }
    public String[] showEmployeesnames(){
        List<EmployeeModel> allEmployee = new ArrayList<EmployeeModel>();
        String[] names = new String[0];
        String select_query = "SELECT * FROM "+EMPLOYEE_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(select_query,null);
        if(cursor.moveToFirst()){
            do {
                String emp_nic = cursor.getString(0);
                String emp_fname = cursor.getString(1);
                String emp_sname = cursor.getString(2);
                String emp_phone= cursor.getString(3);
                String full_name = emp_fname +" "+emp_sname;


            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return names;
    }
}
