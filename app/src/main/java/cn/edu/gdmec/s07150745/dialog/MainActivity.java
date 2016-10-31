package cn.edu.gdmec.s07150745.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1  = (EditText) findViewById(R.id.uidate);
        et2  = (EditText) findViewById(R.id.uitime);
        et3  = (EditText) findViewById(R.id.charactor);
    }
    public void charactordialog(View v){
        final String options = "34297108#65*";
      CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,options,false){
          @Override
          public void onClick(View v) {
              //super.onClick(v);
              et3.append(((Button)v).getText().toString());
              if(((Button)v).getText().toString().equals("")){
                  dismiss();
              }
          }
      };
        cpd.show();
    }
    public void datedialog(View v){
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            et1.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        },2016,9,31);
        dpd.show();
    }
    public void timedialog(View v){
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            et2.setText(hourOfDay+":"+minute);
            }
        },9,9,true);
        tpd.show();
    }
    public void progressdialog(View v){
        final ProgressDialog pg = ProgressDialog.show(this,"下载","13G蓝光...",true);
        new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}
