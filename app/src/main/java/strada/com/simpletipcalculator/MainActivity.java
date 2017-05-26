package strada.com.simpletipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView billAmtView, totalView, totalEachView,eachTV;
    Button billAmtBtn,perc0,perc5,perc10,perc15,perc20,perc25;
    int billAmt = 0;
    int totalEach;
    Double total,tipPercentage,tipAmt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentage = 0.0;


        // view init
        billAmtView = (TextView)findViewById(R.id.bill_amt_view);
        totalView = (TextView)findViewById(R.id.total_view);
        eachTV = (TextView) findViewById(R.id.each_tv);
        totalEachView = (TextView) findViewById(R.id.total_ind_view);
        billAmtBtn = (Button) findViewById(R.id.bill_amt_edit_btn_onHome);
        perc0 = (Button) findViewById(R.id.perc0);
        perc5 = (Button) findViewById(R.id.perc5);
        perc10 = (Button) findViewById(R.id.perc10);
        perc15 = (Button) findViewById(R.id.perc15);
        perc20 = (Button) findViewById(R.id.perc20);
        perc25 = (Button) findViewById(R.id.perc25);



        //  OnClicks
        findViewById(R.id.bill_amt_edit_btn_onHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BillAmtInputActivity.class));
            }
        });

        findViewById(R.id.perc0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(30);
                perc5.setTextSize(18);
                perc10.setTextSize(18);
                perc15.setTextSize(18);
                perc20.setTextSize(18);
                perc25.setTextSize(18);
                tipPercentage = 0.00;
            }
        });

        findViewById(R.id.perc5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(18);
                perc5.setTextSize(30);
                perc10.setTextSize(18);
                perc15.setTextSize(18);
                perc20.setTextSize(18);
                perc25.setTextSize(18);
                tipPercentage = 0.05;
            }
        });

        findViewById(R.id.perc10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(18);
                perc5.setTextSize(18);
                perc10.setTextSize(30);
                perc15.setTextSize(18);
                perc20.setTextSize(18);
                perc25.setTextSize(18);
                tipPercentage = 0.1;
            }
        });

        findViewById(R.id.perc15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(18);
                perc5.setTextSize(18);
                perc10.setTextSize(18);
                perc15.setTextSize(30);
                perc20.setTextSize(18);
                perc25.setTextSize(18);
                tipPercentage = 0.15;
            }
        });

        findViewById(R.id.perc20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(18);
                perc5.setTextSize(18);
                perc10.setTextSize(18);
                perc15.setTextSize(18);
                perc20.setTextSize(30);
                perc25.setTextSize(18);
                tipPercentage = 0.20;
            }
        });

        findViewById(R.id.perc25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perc0.setTextSize(18);
                perc5.setTextSize(18);
                perc10.setTextSize(18);
                perc15.setTextSize(18);
                perc20.setTextSize(18);
                perc25.setTextSize(30);
                tipPercentage = 0.25;
            }
        });


        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String intentString = extra.getString("bill_string");
            billAmt = Integer.valueOf(intentString);
        }

        if (billAmt != 0){
            billAmtBtn.setText(String.valueOf(billAmt));
        }

        total = Double.valueOf(billAmt); // Temporal fix
        tipAmt = billAmt*tipPercentage;
        total = billAmt + tipAmt;
        totalView.setText("Total " + total);

        if (total == totalEach){
            totalView.setText("");
            totalEachView.setText("Total " + totalEach);
            eachTV.setText("");
        }



    }

    public double getBillAmt() {
        return Double.valueOf(billAmtView.getText().toString());
    }


}
