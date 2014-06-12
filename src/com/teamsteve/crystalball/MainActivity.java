package com.teamsteve.crystalball;

import com.teamsteve.cystalball.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mAnswerLabel;
	private Button mGetAnswerButton;
	private ImageView mCrystalBallImage;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toast.makeText(this, "First Toast Message!", Toast.LENGTH_LONG).show();
        
        //Declared Variables for View and assign the Views from the layout file
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
       mGetAnswerButton = (Button) findViewById(R.id.button1);
        
        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String answer = mCrystalBall.getAnAnswer(); 
				mAnswerLabel.setText(answer);
				
				//Start the animation too!
				animateCrystalBall(); // will run the method to flash the Crystal Ball
				
			}
		});
    }
    private void animateCrystalBall()
    {
    	mCrystalBallImage = (ImageView) findViewById(R.id.imageView1);
    	mCrystalBallImage.setImageResource(R.drawable.ball_animation);
    	AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
    	if(ballAnimation.isRunning())
    	{
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    	animateAnswer();
    	playSound();
    	
    }

    private void animateAnswer(){
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	
    	mAnswerLabel.setAnimation(fadeInAnimation);
    }
    
    private void playSound(){
    	MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
    		
    		public void onCompletion(MediaPlayer mp){
    			mp.release();
    		}
    	});
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
}
