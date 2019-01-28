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
    private SimpleDateFormat mTimeFormat  = new SimpleDateFormat("HH:mm:ss  dd:MM:yyyy" , Locale.US);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private TextView mTimeTextView;
    private Runnable mTickRoutine = new Runnable() {
        @Override
        public void run() {
        mTimeTextView.setText(mTimeFormat.format(Calendar.getInstance().getTime()));
        mHandler.postDelayed(this, TICK_DELAY_MILLIS);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimeTextView = findViewById(R.id.view_time);
    }


    public void Show(View view) {
        mTimeTextView.setText(mTimeFormat.format(Calendar.getInstance().getTime()));
        mTickRoutine.run();

    }

    public void Hide(View view) {
        mTimeTextView.setText("");
        mHandler.removeCallbacks(mTickRoutine);
    }
}
