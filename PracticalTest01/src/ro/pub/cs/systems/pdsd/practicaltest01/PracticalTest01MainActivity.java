package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	
	private Integer clickTL = 0;
	private Integer clickTR = 0;
	private Integer clickBL = 0;
	private Integer clickBR = 0;
	private Integer clickCenter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        final Button buttonTL = (Button)findViewById(R.id.buttonTopLeft);
        final Button buttonTR = (Button)findViewById(R.id.buttonTopRight);
        final Button buttonCenter = (Button)findViewById(R.id.buttonCenter);
        final Button buttonBL = (Button)findViewById(R.id.buttonBottomLeft);
        final Button buttonBR = (Button)findViewById(R.id.buttonBottomRight);
        
        buttonTL.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText text = (EditText)findViewById(R.id.editText1);
				String s = text.getText().toString();
				
				s += ", " + buttonTL.getText().toString();
				
				text.setText(s);
				
				clickTL++;
			}
		});
        
        buttonTR.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText text = (EditText)findViewById(R.id.editText1);
				String s = text.getText().toString();
				
				s += ", " + buttonTR.getText().toString();
				
				text.setText(s);
				
				clickTR++;
			}
		});
        
        buttonCenter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText text = (EditText)findViewById(R.id.editText1);
				String s = text.getText().toString();
				
				s += ", " + buttonCenter.getText().toString();
				
				text.setText(s);
				
				clickCenter++;
			}
		});
        
        buttonBL.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText text = (EditText)findViewById(R.id.editText1);
				String s = text.getText().toString();
				
				s += ", " + buttonBL.getText().toString();
				
				text.setText(s);
				clickBL++;
			}
		});
        
        buttonBR.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText text = (EditText)findViewById(R.id.editText1);
				String s = text.getText().toString();
				
				s += ", " + buttonBR.getText().toString();
				
				text.setText(s);
				clickBR++;
			}
		});
        
        
        Button secActivity = (Button)findViewById(R.id.buttonNavigateSec);
        
        secActivity.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText text = (EditText)findViewById(R.id.editText1);
				
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicalText01SecondaryActivity");
				intent.putExtra("sequence", text.getText().toString());
				
				startActivityForResult(intent, 12345);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	
    	outState.putInt("btnTLClicks", clickTL);
    	outState.putInt("btnTRClicks", clickTR);
    	outState.putInt("btnCenterClicks", clickCenter);
    	outState.putInt("btnBLClicks", clickBL);
    	outState.putInt("btnBRClicks", clickBR);
    	
    	EditText text = (EditText)findViewById(R.id.editText1);
    	
    	outState.putCharSequence("clickSequenceText", text.getText().toString());
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    	
    	setClickTL(savedInstanceState.getInt("btnTLClicks"));
    	setClickTR(savedInstanceState.getInt("btnTRClicks"));
    	setClickCenter(savedInstanceState.getInt("btnCenterClicks"));
    	setClickBL(savedInstanceState.getInt("btnBLClicks"));
    	setClickBR(savedInstanceState.getInt("btnBRClicks"));
    	
    	EditText text = (EditText)findViewById(R.id.editText1);
    	
    	text.setText(savedInstanceState.getCharSequence("clickSequenceText"));
    	
    	Toast.makeText(this, "Number of clicks: TL " + clickTL + ", TR " + clickTR + ", Center " + clickCenter + ", BL " + clickBL + ", BR " + clickBR, Toast.LENGTH_LONG).show();
    }


	public Integer getClickTL() {
		return clickTL;
	}


	public void setClickTL(Integer clickTL) {
		this.clickTL = clickTL;
	}


	public Integer getClickTR() {
		return clickTR;
	}


	public void setClickTR(Integer clickTR) {
		this.clickTR = clickTR;
	}


	public Integer getClickBL() {
		return clickBL;
	}


	public void setClickBL(Integer clickBL) {
		this.clickBL = clickBL;
	}


	public Integer getClickBR() {
		return clickBR;
	}


	public void setClickBR(Integer clickBR) {
		this.clickBR = clickBR;
	}


	public Integer getClickCenter() {
		return clickCenter;
	}


	public void setClickCenter(Integer clickCenter) {
		this.clickCenter = clickCenter;
	}
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	Toast.makeText(this, "Returned from secondary activity: " + resultCode, Toast.LENGTH_LONG).show();
    }
}
