package strada.com.simpletipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView billAmtView;
    int billAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view init
        billAmtView = (TextView)findViewById(R.id.bill_amt_view);


    }

    public double getBillAmt() {
        return Double.valueOf(billAmtView.getText().toString());
    }
}
