package strada.com.simpletipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillAmtInputActivity extends AppCompatActivity {

    Button btn7;
    TextView billTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_amt_input);

        //btn7 = (Button) findViewById(R.id.btn7);
        //btn7.setHeight(btn7.getMeasuredWidth());

        billTextView = (TextView) findViewById(R.id.bill_view);

        findViewById(R.id.btn_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append(".");
            }
        });

        findViewById(R.id.btn_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //billTextView.append("\b");
                billTextView.setText(billTextView.getText().subSequence(0,billTextView.getText().length()-1));
            }
        });

        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("0");
            }
        });

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("1");
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("2");
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("3");
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("4");
            }
        });
        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("5");
            }
        });

        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("6");
            }
        });

        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("7");
            }
        });

        findViewById(R.id.btn_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("8");
            }
        });

        findViewById(R.id.btn_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billTextView.append("9");
            }
        });

        findViewById(R.id.done_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BillAmtInputActivity.this, MainActivity.class).putExtra("bill_string", billTextView.getText().toString()));
            }
        });
        //findViewById();
        //findViewById();
        //findViewById();
        //findViewById();



    }
}
