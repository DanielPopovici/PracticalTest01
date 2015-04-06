package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);
        
        Intent intent = getIntent();
        
        EditText text = (EditText)findViewById(R.id.editTextSec);
        text.setText(intent.getCharSequenceExtra("sequence"));
        
        Button buttonVerify = (Button)findViewById(R.id.buttonVerify);
        Button buttonCancel = (Button)findViewById(R.id.buttonCancel);
        
        buttonVerify.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_OK);
				finish();
			}
		});
        
        buttonCancel.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED);
				finish();
			}
		});
	}
}
