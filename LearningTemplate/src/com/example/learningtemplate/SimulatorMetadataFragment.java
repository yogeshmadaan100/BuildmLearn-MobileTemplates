package com.example.learningtemplate;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SimulatorMetadataFragment extends Fragment{
	TextView appName,authorName;
	Button btnStart;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.layout_simulator_metadata, container,false);
		appName=(TextView)rootView.findViewById(R.id.appName);
		authorName=(TextView)rootView.findViewById(R.id.authorName);
		btnStart=(Button)rootView.findViewById(R.id.btnStart);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	//	try{
			appName.setText(""+((MainActivity)getActivity()).getModel().getmAppName());
			authorName.setText(""+((MainActivity)getActivity()).getModel().getmAuthorName());
			
		/*}catch(Exception e)
		{
			
		}*/
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
							((MainActivity)getActivity()).switchFragment(new SimulatorLearningFragment());
						
				}
		});
	}

}
