package com.example.v_s.leson_1;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final int TICK_DELAY_MILLIS=250;
    private SimpleDateFormat timeFormat  = new SimpleDateFormat("HH:mm:ss  dd:MM:yyyy" , Locale.US);
    private Handler handler = new Handler(Looper.getMainLooper());
    private TextView timeTextView;
    private Runnable tickRoutine = new Runnable() {
        @Override
        public void run() {
        timeTextView.setText(timeFormat.format(Calendar.getInstance().getTime()));
        handler.postDelayed(this, TICK_DELAY_MILLIS);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeTextView = findViewById(R.id.view_time);
    }


    public void Show(View view) {
        timeTextView.setText(timeFormat.format(Calendar.getInstance().getTime()));
        tickRoutine.run();

    }

    public void Hide(View view) {
        timeTextView.setText("");
        handler.removeCallbacks(tickRoutine);
    }
}
