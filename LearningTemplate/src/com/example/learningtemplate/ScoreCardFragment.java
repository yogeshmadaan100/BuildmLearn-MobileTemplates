package com.example.learningtemplate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ScoreCardFragment extends Fragment {
	TextView result;
	Button restart,exit;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.layout_scorecard, container,false);
		result=(TextView)rootView.findViewById(R.id.result);
		restart=(Button)rootView.findViewById(R.id.btnRestart);
		exit=(Button)rootView.findViewById(R.id.btnExit);
		try{
		result.setText(getArguments().getString("result"));
		}catch(Exception e)
		{
			
		}
		restart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					
						((MainActivity)getActivity()).switchFragment(new SimulatorLearningFragment());
					
			}
		});
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().finish();
			}
		});
		return rootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
}
