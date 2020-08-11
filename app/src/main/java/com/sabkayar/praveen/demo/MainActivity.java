package com.sabkayar.praveen.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sabkayar.praveen.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mActivityMainBinding.buttonShowToast.setOnClickListener(this);
        mActivityMainBinding.buttonShowSnackBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_show_toast:
                Context context = getApplicationContext();
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);

                //Positioning your Toast
                toast.setGravity(Gravity.START | Gravity.TOP, 0, 0);

                //Creating a Custom Toast View
                LayoutInflater inflater = LayoutInflater.from(this);
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView textView = (TextView) layout.findViewById(R.id.text);
                textView.setText("This is a custom toast");
                Toast toast1 = new Toast(getApplicationContext());
                toast1.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.setView(layout);
                toast1.show();
                toast.show();
                /*
                * Note: Do not use the public constructor for a Toast unless you are going to define the layout with setView(View). If you do not have a custom layout to use, you must use makeText(Context, int, int) to create the Toast.
                * */
                break;
            case R.id.button_show_snack_bar:
                break;
            default:
        }
    }
}
