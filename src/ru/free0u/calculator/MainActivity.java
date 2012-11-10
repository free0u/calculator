package ru.free0u.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView tv;
	EditText et;
	Button bt;
	
	MathParser mp = null;
	
	private void setExpressionResult(String exp) {
		String result;
		try {
        	double res = mp.evaluate(exp);
        	result = Double.toString(res);
        } catch (IllegalArgumentException e) {
        	result = "Illegal expression";
        } catch (ArithmeticException e) {
        	result = "Divide by zero";
        }
		tv.setText(result);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView)findViewById(R.id.textView_out);
        et = (EditText)findViewById(R.id.editText1);
        bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(this);
        
        mp = new MathParser();
    }

	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			Log.i("calc", "onClick button");
			String exp = et.getText().toString();
			Log.i("calc", "exp: " + exp);
			setExpressionResult(exp);
		}
	}
}
