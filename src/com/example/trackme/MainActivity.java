package com.example.trackme;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
<<<<<<< HEAD
=======
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

<<<<<<< HEAD
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
=======
public class MainActivity extends ActionBarActivity implements LocationListener{
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	protected Context context;
	
	String lat;
	String provider;
	String message;
	protected String latitude,longitude; 
	protected boolean gps_enabled,network_enabled;
	
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        //location sample code + Need to work on fetching location via GPS/Internet too Now app is crashing without internet
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80
        
        Button trackme = (Button)findViewById(R.id.button1);
        System.out.println("{{{{{{{"  + trackme.getId());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        trackme.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
<<<<<<< HEAD
				// TODO Auto-generated method stub
				sendSMS("+917259250682","Test Test Hello Test");
=======
				// Blindly sending it to my no.
				sendSMS("+917259250682",message);
>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80
			}
		});
        
        }
    
   
<<<<<<< HEAD
    private void sendSMS(String phoneNumber, String message)
    {        
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
            new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
            new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
=======
    	private void sendSMS(String phoneNumber, String message)
    	{        
        	String SENT = "SMS_SENT";
        	String DELIVERED = "SMS_DELIVERED";

        	PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
        	 new Intent(SENT), 0);

        	PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
            	new Intent(DELIVERED), 0);

        	//---when the SMS has been sent---
        	registerReceiver(new BroadcastReceiver(){
            	@Override
            	public void onReceive(Context arg0, Intent arg1) {
>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off", 
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS delivered", 
                                Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered", 
                                Toast.LENGTH_SHORT).show();
                        break;                        
                }
            }
        }, new IntentFilter(DELIVERED));        

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);        
    }
    protected void sendsms() 
    {

       /* try
        {
        		SmsManager smsManager = SmsManager.getDefault();
        		smsManager.sendTextMessage("0917259250682", null, "This is shit test myan.", null, null);
        		Toast.makeText(getApplicationContext(), "Sent",
        				Toast.LENGTH_LONG).show();
        } 
        catch (Exception e) 
        {
        	Toast.makeText(getApplicationContext(),
        			"SMS Sucked",
        	Toast.LENGTH_LONG).show();
        	e.printStackTrace();
       	}*/
    	Intent sendIntent = new Intent(Intent.ACTION_VIEW);
    	sendIntent.putExtra("sms_body", "default content"); 
    	sendIntent.setType("vnd.android-dir/mms-sms");
    	startActivity(sendIntent);
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

    /**
     * A placeholder fragment containing a simple view.
     */
<<<<<<< HEAD
    public static class PlaceholderFragment extends Fragment {
=======
	 public static class PlaceholderFragment extends Fragment {
>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

<<<<<<< HEAD
=======
	@Override
	public void onLocationChanged(Location location) {
		message=("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());	
		// Simplest way to fetch location- Saurav
		
	}


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

>>>>>>> 0312df793892e37ba53e971c6a71dddf9accdd80
}
