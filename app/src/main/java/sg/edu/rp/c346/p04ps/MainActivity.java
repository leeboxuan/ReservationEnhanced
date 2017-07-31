package sg.edu.rp.c346.p04ps;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Number;
    EditText Pax;

    Button Confirm;
    Button Reset;
    EditText etDay;
    EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.Name);
        Number = (EditText)findViewById(R.id.Number);
        Pax = (EditText)findViewById(R.id.amt);
        Confirm = (Button)findViewById(R.id.confirm);
        Reset = (Button)findViewById(R.id.reset);



        Confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = Name.getText() + " " + Number.getText() + " Number of People:" + Pax.getText()
                        + "Date: " +etDay.getText() + "Time: " + etTime.getText();
                //Create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details

                myBuilder.setTitle("Reservation Details");
                myBuilder.setMessage(text);
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", null);

                //Create and display the Dialog

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            };
        }
        );
        Reset.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){

               Name.setText("");
               Number.setText("");
               Pax.setText("");
                 etDay.setText("");
                 etTime.setText("");

             };
        }
        );
        etDay = (EditText) findViewById(R.id.EditTextDay);
        etTime = (EditText) findViewById(R.id.EditTextTime);

        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        etDay.setText("" + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                Calendar cal = Calendar.getInstance();
                int year = cal.get(cal.YEAR);
                int day = cal.get(cal.DAY_OF_MONTH);
                int month = cal.get(cal.MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        etTime.setText("" + hourOfDay + ":" + minute);
                    }
                };

               /* // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, 20, 00, true);
*/
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(cal.HOUR_OF_DAY);
                int minutes = cal.get(cal.MINUTE);

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hour, minutes, true);

                myTimeDialog.show();
            }
        });
    }
}
