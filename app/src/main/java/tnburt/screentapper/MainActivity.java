package tnburt.screentapper;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textHeader = (TextView) findViewById(R.id.text_header);
        final TextView textFooter = (TextView) findViewById(R.id.text_footer);

        final TextView textCount = (TextView) findViewById(R.id.text_count);
        textCount.setText(String.valueOf(count));

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.mainLayout);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        count++;
                        textHeader.setAlpha((float)0.8);
                        textFooter.setAlpha((float)0.8);
                        textCount.setTextSize(92);
                        break;
                    case MotionEvent.ACTION_UP:
                        textHeader.setAlpha(1);
                        textFooter.setAlpha(1);
                        textCount.setTextSize(82);
                        break;
                    default:
                        break;
                }
                textCount.setText(String.valueOf(count));
                return true;
            }
        });
    }

}
