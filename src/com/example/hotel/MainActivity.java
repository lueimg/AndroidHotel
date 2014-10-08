package com.example.hotel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {
	
	private boolean favorite  = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//        int id = item.getItemId();
//        if (id == R.id.action_fav) {
//            return true;
//        }
    	
    	switch (item.getItemId()) {
		case R.id.action_fav:
			Drawable icon = null;
			if(favorite ){
				icon = getResources().getDrawable(R.drawable.rating_not_important_1);
			}else{
				icon = getResources().getDrawable(R.drawable.rating_important_1);
			}
			
			favorite = !favorite;
			item.setIcon(icon);
			
			return true;
		case R.id.action_share:
			Intent share = new Intent();
			
			share.setAction(Intent.ACTION_SEND);
			
			String msg = getResources().getString(R.string.msg_share);
			share.putExtra(Intent.EXTRA_TEXT, msg);
			
			Uri img_res = Uri.parse("android.resource://"+ getPackageName() +
					"/drawable/" + R.drawable.hotel1_1);
			share.putExtra(Intent.EXTRA_STREAM, img_res);
			
			share.setType("image/jpeg");
			startActivity(Intent.createChooser(share, "Compartir"));
			
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
    	
        
    }
}
