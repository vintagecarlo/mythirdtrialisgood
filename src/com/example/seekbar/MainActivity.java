package com.example.seekbar;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnSeekBarChangeListener {
    SeekBar skRed, skGreen,skBlue;
    TextView txtResult;
    int red = 0,green = 0, blue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.skRed = (SeekBar) this.findViewById(R.id.seekBar1);
        this.skGreen = (SeekBar) this.findViewById(R.id.seekBar2);
        this.skBlue = (SeekBar) this.findViewById(R.id.seekBar3);
        
        this.txtResult = (TextView) this.findViewById(R.id.textView4);
        this.txtResult.setBackgroundColor(Color.rgb(red, green, blue));
        this.txtResult.setTextColor(Color.rgb(255, 255, 255));
        this.skRed.setOnSeekBarChangeListener(this);
        this.skGreen.setOnSeekBarChangeListener(this);
        this.skBlue.setOnSeekBarChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		
		switch(id){
		case R.id.seekBar1:red = this.skRed.getProgress();break;
		case R.id.seekBar2:green = this.skGreen.getProgress();break;
		case R.id.seekBar3:blue = this.skBlue.getProgress();
		}
		this.txtResult.setBackgroundColor(Color.rgb(red, green, blue));
		String colorValue = String.format("#%02X %02X %02X", red,green,blue);
		this.txtResult.setText(colorValue);
		
		int revRed =  255 - red;
		int revGreen = 255 - green;
		int revBlue = 255 - blue;
		this.txtResult.setTextColor(Color.rgb(revRed, revGreen, revBlue));
	}


	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
}
