package com.example.ataraxia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.BreakIterator;
import java.util.Calendar;

public class PengingatmakanActivity extends AppCompatActivity {


    ImageButton backpengingat;

    MaterialTimePicker timepicker, timepickersiang, timepickermalam, timepickeroptional;

    AlarmManager alarmManager, alarmManagersiang, alarmManagermalam, alarmManageroptional;

    Calendar calendar, calendarsiang, calendarmalam, calendaroptional;

    PendingIntent pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4;

    TextView settime, settimesiang, settimemalam, settimeoptional;
    Button btnsetsarapan, btncancelsarapan, btnsetsiang, btncancelsiang, btnsetmalam, btncancelmalam, btnsetoptional, btncanceloptional;

    String userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengingatmakan);
        backpengingat = findViewById(R.id.backpengingat);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            userId = extra.getString("userid");
        }

        createNotificationChannel();
        createNotificationChannel2();
        createNotificationChannel3();
        createNotificationChannel4();

        //pagi
        settime = findViewById(R.id.selectsarapan);
        btnsetsarapan = findViewById(R.id.btnsetsarapan);
        btncancelsarapan = findViewById(R.id.btncancelsarapan);

        // siang
        settimesiang = findViewById(R.id.selectedalarmsiang);
        btnsetsiang = findViewById(R.id.setalarmsiang);
        btncancelsiang = findViewById(R.id.cancelalarmsiang);

        // malam
        settimemalam = findViewById(R.id.selectalarmmalam);
        btnsetmalam = findViewById(R.id.setalarmmalam);
        btncancelmalam = findViewById(R.id.cancelalarmmalam);

        //optional
        settimeoptional = findViewById(R.id.selectedalarmoptional);
        btnsetoptional = findViewById(R.id.setalarmoptional);
        btncanceloptional = findViewById(R.id.cancelalarmoptional);


        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });

        // alarm pagi

        btnsetsarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }
        });

        btncancelsarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });


        backpengingat.setOnClickListener(v -> {
            Intent open = new Intent(PengingatmakanActivity.this, MakanannActivity.class);
            open.putExtra("userid", userId);
            startActivity(open);
        });

        // alarm siang

        settimesiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickersiang();
            }
        });

        btnsetsiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarmsiang();
            }
        });

        btncancelsiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarmsiang();
            }
        });

        // alarm malam

        settimemalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickermalam();
            }
        });

        btnsetmalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarmmalam();
            }
        });

        btncancelmalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarmmalam();
            }
        });

        // alarm optional

        settimeoptional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickeroptional();
            }
        });

        btnsetoptional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarmoptional();
            }
        });

        btncanceloptional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarmoptional();
            }
        });


    }



    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Ataraxia";
            String description = "Pengingat Makan";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel("Ataraxia", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    private void createNotificationChannel2() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Ataraxia";
            String description = "Pengingat Makan";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel("Ataraxia2", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    private void createNotificationChannel3() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Ataraxia";
            String description = "Pengingat Makan";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel("Ataraxia3", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    private void createNotificationChannel4() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Ataraxia";
            String description = "Pengingat Makan";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel("Ataraxia4", name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }


    private void showTimePicker() {
        timepicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        timepicker.show(getSupportFragmentManager(), "Ataraxia");

        timepicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timepicker.getHour() > 12) {
                    settime.setText(
                            String.format("%02d",(timepicker.getHour()-12)) +" : "+ String.format("%02d", timepicker.getMinute())+" PM"
                    );
                } else {
                    settime.setText(
                            String.format("%02d", timepicker.getHour()) + " : " +String.format("%02d", timepicker.getMinute()) + " AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timepicker.getHour());
                calendar.set(Calendar.MINUTE, timepicker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

            }
        });
    }

    private void showTimePickersiang() {
        timepickersiang = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        timepickersiang.show(getSupportFragmentManager(), "Ataraxia2");

        timepickersiang.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timepickersiang.getHour() > 12) {
                    settimesiang.setText(
                            String.format("%02d",(timepickersiang.getHour()-12)) +" : "+ String.format("%02d", timepickersiang.getMinute())+" PM"
                    );
                } else {
                    settimesiang.setText(
                            String.format("%02d", timepickersiang.getHour()) + " : " +String.format("%02d", timepickersiang.getMinute()) + " AM");
                }

                calendarsiang = Calendar.getInstance();
                calendarsiang.set(Calendar.HOUR_OF_DAY, timepickersiang.getHour());
                calendarsiang.set(Calendar.MINUTE, timepickersiang.getMinute());
                calendarsiang.set(Calendar.SECOND, 0);
                calendarsiang.set(Calendar.MILLISECOND, 0);

            }
        });
    }

    private void showTimePickermalam() {
        timepickermalam = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        timepickermalam.show(getSupportFragmentManager(), "Ataraxia3");

        timepickermalam.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timepickermalam.getHour() > 12) {
                    settimemalam.setText(
                            String.format("%02d",(timepickermalam.getHour()-12)) +" : "+ String.format("%02d", timepickermalam.getMinute())+" PM"
                    );
                } else {
                    settimemalam.setText(
                            String.format("%02d", timepickermalam.getHour()) + " : " +String.format("%02d", timepickermalam.getMinute()) + " AM");
                }

                calendarmalam = Calendar.getInstance();
                calendarmalam.set(Calendar.HOUR_OF_DAY, timepickermalam.getHour());
                calendarmalam.set(Calendar.MINUTE, timepickermalam.getMinute());
                calendarmalam.set(Calendar.SECOND, 0);
                calendarmalam.set(Calendar.MILLISECOND, 0);

            }
        });
    }

    private void showTimePickeroptional() {
        timepickeroptional = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alarm Time")
                .build();

        timepickeroptional.show(getSupportFragmentManager(), "Ataraxia4");

        timepickeroptional.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timepickeroptional.getHour() > 12) {
                    settimeoptional.setText(
                            String.format("%02d",(timepickeroptional.getHour()-12)) +" : "+ String.format("%02d", timepickeroptional.getMinute())+" PM"
                    );
                } else {
                    settimeoptional.setText(
                            String.format("%02d", timepickeroptional.getHour()) + " : " +String.format("%02d", timepickeroptional.getMinute()) + " AM");
                }

                calendaroptional = Calendar.getInstance();
                calendaroptional.set(Calendar.HOUR_OF_DAY, timepickeroptional.getHour());
                calendaroptional.set(Calendar.MINUTE, timepickeroptional.getMinute());
                calendaroptional.set(Calendar.SECOND, 0);
                calendaroptional.set(Calendar.MILLISECOND, 0);

            }
        });
    }



    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this , AlarmReceiver.class);

        pendingIntent = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(PengingatmakanActivity.this, "Alarm Sarapan Set Success", Toast.LENGTH_SHORT).show();

    }

    private void setAlarmsiang() {
        alarmManagersiang = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this , AlarmReceiver2.class);

        pendingIntent2 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);

        alarmManagersiang.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendarsiang.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent2);

        Toast.makeText(PengingatmakanActivity.this, "Alarm Makan Siang set Success", Toast.LENGTH_SHORT).show();

    }

    private void setAlarmmalam() {
        alarmManagermalam = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this , AlarmReceiver3.class);

        pendingIntent3 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);

        alarmManagermalam.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendarmalam.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent3);

        Toast.makeText(PengingatmakanActivity.this, "Alarm Makan Malam set Success", Toast.LENGTH_SHORT).show();

    }

    private void setAlarmoptional() {
        alarmManageroptional = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this , AlarmReceiver4.class);

        pendingIntent4 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);

        alarmManageroptional.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendaroptional.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent4);

        Toast.makeText(PengingatmakanActivity.this, "Alarm set Success", Toast.LENGTH_SHORT).show();

    }

    private void cancelAlarm() {
        Intent intent = new Intent(PengingatmakanActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);
        if (alarmManager == null){
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingIntent);
        Toast.makeText(PengingatmakanActivity.this, "Alarm Sarapan Cancelled", Toast.LENGTH_SHORT).show();
    }

    private void cancelAlarmsiang() {
            Intent intent = new Intent(PengingatmakanActivity.this, AlarmReceiver2.class);
            pendingIntent2 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);
            if (alarmManagersiang == null){
                alarmManagersiang = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            }
            alarmManagersiang.cancel(pendingIntent2);
            Toast.makeText(PengingatmakanActivity.this, "Alarm Makan Siang Cancelled", Toast.LENGTH_SHORT).show();
        }

    private void cancelAlarmmalam() {
        Intent intent = new Intent(PengingatmakanActivity.this, AlarmReceiver3.class);
        pendingIntent3 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);
        if (alarmManagermalam == null){
            alarmManagermalam = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManagermalam.cancel(pendingIntent3);
        Toast.makeText(PengingatmakanActivity.this, "Alarm Makan Malam Cancelled", Toast.LENGTH_SHORT).show();
    }



    private void cancelAlarmoptional() {
        Intent intent = new Intent(PengingatmakanActivity.this, AlarmReceiver4.class);
        pendingIntent4 = PendingIntent.getBroadcast(PengingatmakanActivity.this, 0, intent, 0);
        if (alarmManageroptional == null){
            alarmManageroptional = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        }
        alarmManageroptional.cancel(pendingIntent4);
        Toast.makeText(PengingatmakanActivity.this, "Alarm Cancelled", Toast.LENGTH_SHORT).show();
    }



}