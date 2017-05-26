package strada.com.simpletipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView billAmtView;
    Button billAmtBtn;
    int billAmt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view init
        billAmtView = (TextView)findViewById(R.id.bill_amt_view);
        billAmtBtn = (Button) findViewById(R.id.bill_amt_edit_btn_onHome);


        //  OnClicks
        findViewById(R.id.bill_amt_edit_btn_onHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BillAmtInputActivity.class));
            }
        });

        //billAmtBtn.setText("hi");

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String intentString = extra.getString("bill_string");
            billAmt = Integer.valueOf(intentString);
        }

        if (billAmt != 0){
            billAmtBtn.setText(String.valueOf(billAmt));
        }


    }

    public double getBillAmt() {
        return Double.valueOf(billAmtView.getText().toString());
    }
}
