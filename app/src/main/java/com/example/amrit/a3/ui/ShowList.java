package com.example.amrit.a3.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amrit.a3.BaseActivity;
import com.example.amrit.a3.R;
import com.example.amrit.a3.adapter.ItemAdapter;
import com.example.amrit.a3.modal.ItemListModal;
import java.util.ArrayList;


/**
 * Created by palak on 20/4/17.
 */

public class ShowList extends BaseActivity {
	private ArrayList<ItemListModal> list = new ArrayList<>();
	ItemListModal item1,item2;
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.recyler_view );
		item1 = new ItemListModal( "india",3.14 );
		item2= new ItemListModal( "japan",4.96 );
		list.add(item1);
		list.add( item2 );
		ItemAdapter adapter = new ItemAdapter(this , list ,"");
		RecyclerView recyclerView = (RecyclerView) findViewById( R.id.recycler_view);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setHasFixedSize(true);


	}
}
