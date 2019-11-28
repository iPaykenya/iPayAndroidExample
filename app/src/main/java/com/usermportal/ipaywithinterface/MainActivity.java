package com.usermportal.ipaywithinterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ipay.iPaycheckout.PaymentActivity;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test_button = (Button) findViewById(R.id.test_button);
        context = this;
        final String amounts = "100";
        final String phones = "070000000";
        final String emails = "example@example.com";

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIpay(context, amounts, phones, emails);
            }
        });
    }

    public void callIpay(Context context, String amounts, String phones, String emails)
    {
        //data to send to ipay
        String live             = "0";
        String oid              = "";
        String mer              = ""; //merchant name
        String amount           = amounts;//amounts;
        String phone_number     = phones;
        String email            = emails;
        String vid              = "demo"; //Vendor ID
        String curr             = "KES"; //or USD
        String cst              = "1"; //email notification
        String crl              = "0";
        String autopay          = "1";
        String cbk              = "https://exmple.com/payment/ipay.php";
        String security_key     = "demoCHANED";
        /** can pass extra param below **/
        String p1               = "";
        String p2               = "";
        String p3               = "";
        String p4               = "";

        /**channel setting (1-sets on && 0-sets off)**/
        String mpesa_status    = "1";
        String mbonga_status   = "1";
        String airtel_status   = "1";
        String easy_status     = "1";
        String visa_status     = "1";


        Intent data = new Intent(context, PaymentActivity.class);
        data.putExtra("live", live);
        data.putExtra("mer", mer);
        data.putExtra("oid", oid);
        data.putExtra("vid", vid);
        data.putExtra("cbk", cbk);
        data.putExtra("key", security_key);
        data.putExtra("amount", amount);
        data.putExtra("autopay", autopay);
        data.putExtra("p1", p1);
        data.putExtra("p2", p2);
        data.putExtra("p3", p3);
        data.putExtra("p4", p4);
        data.putExtra("currency", curr);
        data.putExtra("cst", cst);
        data.putExtra("crl", crl);
        data.putExtra("phone", phone_number);
        data.putExtra("email", email);
        data.putExtra("mpesa_status", mpesa_status);
        data.putExtra("mbonga_status", mbonga_status);
        data.putExtra("airtel_status", airtel_status);
        data.putExtra("easy_status", easy_status);
        data.putExtra("visa_status", visa_status);
        context.startActivity(data);
        ((Activity) context).finish();
    }
}
