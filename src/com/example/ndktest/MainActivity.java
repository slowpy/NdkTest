package com.example.ndktest;

import java.io.File;
import java.util.Date;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ndk.NdkNativeJava;
import com.example.util.UtilsTool;

public class MainActivity extends Activity {

	public final static String filePath = Environment.getExternalStorageDirectory()
			+ File.separator + "zyxkapp"+File.separator +"boys.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }
        private  EditText editText;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tv = (TextView) rootView.findViewById(R.id.textview);
            tv.setText(NdkNativeJava.getCallResultByC());
            //NdkNativeJava.updateFile(filePath);
            Button btn = (Button) rootView.findViewById(R.id.button);
            editText = (EditText) rootView.findViewById(R.id.edittext);
            btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					String message = ("\r\n"+UtilsTool.getLocalDate()+"----"+editText.getText().toString());
//					NdkNativeJava.writeFile(filePath, message);
					int[] resultIntArray = NdkNativeJava.updateIntArray(new int[]{1,2,3,4,5});
					for(int i = 0;i<resultIntArray.length;i++){
						//NdkNativeJava.writeFile(filePath, "\r\n"+UtilsTool.getLocalDate()+"----"+resultIntArray[i]);
					}
				}
			});
            return rootView;
        }
    }

}
