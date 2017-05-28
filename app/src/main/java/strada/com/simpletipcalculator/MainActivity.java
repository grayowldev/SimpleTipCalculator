package strada.com.simpletipcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView billAmtView, totalView, totalEachView,eachTV, tipAmtView;
    Button billAmtBtn,perc0,perc5,perc10,perc15,perc20,perc25;
    int billAmt = 0;
    Double total,tipPercentage,tipAmt,totalEach;
    SeekBar seekBar;
    EditText splitValue;

    Tipper tipper = new Tipper();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tipPercentage = 0.0;


        // view init
        billAmtView = (TextView)findViewById(R.id.bill_amt_view);
        totalView = (TextView)findViewById(R.id.total_view);
        //eachTV = (TextView) findViewById(R.id.each_tv);
        totalEachView = (TextView) findViewById(R.id.total_ind_view);
        billAmtBtn = (Button) findViewById(R.id.bill_amt_edit_btn_onHome);
        perc0 = (Button) findViewById(R.id.perc0);
        perc5 = (Button) findViewById(R.id.perc5);
        perc10 = (Button) findViewById(R.id.perc10);
        perc15 = (Button) findViewById(R.id.perc15);
        perc20 = (Button) findViewById(R.id.perc20);
        perc25 = (Button) findViewById(R.id.perc25);

        tipAmtView = (TextView) findViewById(R.id.tip_amt_view);
        splitValue = (EditText) findViewById(R.id.split_edit);


        //Set zero values to views
        totalEachView.setText("Total: " + billAmt);
        totalView.setText("");
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 0 ,0F);

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
                resetTipSize();
                perc0.setTextSize(30);
                tipPercentage = 0.00;
                updateTotal();
            }
        });

        findViewById(R.id.perc5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTipSize();
                perc5.setTextSize(30);
                tipPercentage = 0.05;
                updateTipAmt();
                updateTotal();
            }
        });

        findViewById(R.id.perc10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTipSize();
                perc10.setTextSize(30);
                tipPercentage = 0.1;
                updateTotal();
            }
        });

        findViewById(R.id.perc15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTipSize();
                perc15.setTextSize(30);
                tipPercentage = 0.15;
                updateTotal();
            }
        });

        findViewById(R.id.perc20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTipSize();
                perc20.setTextSize(30);
                tipPercentage = 0.20;
                updateTotal();
            }
        });

        findViewById(R.id.perc25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTipSize();
                perc25.setTextSize(30);
                tipPercentage = 0.25;
                updateTotal();
            }
        });


        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String intentString = extra.getString("bill_string");
            tipper.setBillAmount(Double.valueOf(intentString));
            updateTotal();
        }

        if (tipper.getBillAmount() != 0){
            billAmtBtn.setText(String.valueOf(tipper.getBillAmount()));
        }

        seek();




        tipAmtView.setText(tipPercentage + "");
        tipAmt = billAmt*tipPercentage;

        onSplitChange();
        //totalView.setText("Total: " + total);

    }

    public void updateTipAmt(){
        tipper.setTipPercentage(tipPercentage);
        tipper.tipAmount(tipper.getTipPercentage());
        tipAmtView.setText(tipper.getTipAmount() + "");
    }

    public void updateTotal(){
        splitValue = (EditText) findViewById(R.id.split_edit);
        updateTipAmt();

        /**
        //total = tipper.total(tipper.getTipAmount(),getBillAmt());
        if (tipper.getSplitNumber() > 1){
            totalEachView.setText(tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount())) + "");
        }
        totalView.setText(tipper.total(tipper.getTipAmount(),tipper.getBillAmount()) + "");
         **/
        totalEach = tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount()));
        if (tipper.getSplitNumber() == 1){
            totalEachView.setText("Total: " + tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount())));
        }
        else {
            totalEachView.setText("Total: " + tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount())) +
                    " Each");
        }

        /**
        splitValue = (EditText) findViewById(R.id.split_edit);
        if(Integer.valueOf(splitValue.getText().toString()) > 1){
            //totalView.setText("Total: " + total);
        }**/


    }

    public void oneTotalMod(){
        splitValue = (EditText) findViewById(R.id.split_edit);
        if (Integer.valueOf(splitValue.getText().toString()) == 1){
            totalView.setText("Total: " + tipper.total(tipper.getTipAmount(),tipper.getBillAmount()));
        }
    }

    public void resetTipSize(){
        perc0.setTextSize(18);
        perc5.setTextSize(18);
        perc10.setTextSize(18);
        perc15.setTextSize(18);
        perc20.setTextSize(18);
        perc25.setTextSize(18);
    }

    public void seek(){
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekValue;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekValue = i;
                if (seekValue == 0){
                    seekValue = 1;
                }
                splitValue.setText(seekValue + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (seekValue == 0){
                    seekValue = 1;
                }
                splitValue.setText(seekValue + "");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onSplitChange(){
        splitValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Integer.valueOf(splitValue.getText().toString()) == 1){
                    total = tipper.total(tipper.getTipAmount(),tipper.getBillAmount());
                    tipper.setSplitNumber(1);
                    totalEach = tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount()));
                    totalView.setText("");
                    TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 0 ,0F);
                    totalEachView.setText("Total " + total);

                }
                else {
                    tipper.setSplitNumber(Integer.valueOf(splitValue.getText().toString()));
                    totalEach = tipper.totalEach(tipper.total(tipper.getTipAmount(),tipper.getBillAmount()));
                    totalView.setText("Total: " + tipper.total(tipper.getTipAmount(),tipper.getBillAmount()));
                    totalEachView.setText("Total " + totalEach + " Each");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}
