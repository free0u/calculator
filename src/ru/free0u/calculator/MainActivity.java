package ru.free0u.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MathParser mp = new MathParser();
        
        String result;
        try {
        	double res = mp.evaluate("-+2");
        	result = Double.toString(res);
        } catch (IllegalArgumentException e) {
        	result = "Illegal expression";
        }
        
        tv = (TextView)findViewById(R.id.textView_out);
        tv.setText(result);
    }
}
