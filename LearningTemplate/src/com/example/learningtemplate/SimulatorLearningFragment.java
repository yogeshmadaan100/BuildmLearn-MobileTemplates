package com.example.learningtemplate;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class SimulatorLearningFragment extends Fragment {
	private ListView mListView;
	public static ArrayList mDataList=new ArrayList();
	ArrayList<String> mWords=new ArrayList<String>();
	Fragment f;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.layout_questions_list, container,false);
		mListView=(ListView)rootView.findViewById(R.id.list);
		
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mDataList=new ArrayList<LearningDataTemplate>();
		mDataList=((MainActivity)getActivity()).getData();
		
		if(mDataList!=null&mDataList.size()!=0)
		{
			for(int i=0;i<mDataList.size();i++)
			{
				
				String title=((LearningDataTemplate) mDataList.get(i)).getmTitle();
				Log.e("title", ""+title);
				mWords.add(title);
			}
		}
		EfficientAdapter adapter =new EfficientAdapter(getActivity(),mWords);
		mListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String meaning=(((LearningDataTemplate) mDataList.get(position)).getDescription());
				Toast.makeText(getActivity(), meaning, 2000).show();
			}
		});
	}

}
