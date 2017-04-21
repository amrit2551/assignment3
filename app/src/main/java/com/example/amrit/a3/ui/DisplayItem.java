package com.example.amrit.a3.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.amrit.a3.BaseActivity;
import com.example.amrit.a3.R;
import com.example.amrit.a3.fragment.UpcomingAndPastFragment;

/**
 * Created by palak on 20/4/17.
 */

public class DisplayItem extends BaseActivity {
	private Button btnupcoming;
	private Button btnpast;
	private ViewPager vp;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.display_screen );
		init();

		vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


			@Override
			public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(final int position) {
				if (position == 0) {
					btnupcoming.setBackgroundResource(R.color.colorPrimaryDark);
					btnpast.setBackgroundColor(getResources().getColor(R.color.colorAccent));


				} else {
					btnupcoming.setBackgroundColor(getResources().getColor(R.color.colorAccent));
					btnpast.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

				}

			}

			@Override
			public void onPageScrollStateChanged(final int state) {

			}
		});

		FragmentStatePagerAdapter StatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
			@Override
			public android.support.v4.app.Fragment getItem(final int position) {
				if (position == 0) {
					return new UpcomingAndPastFragment( "upcoming" );
				}
				return new UpcomingAndPastFragment("past");
			}

			@Override
			public int getCount() {
				return 2;
			}

		};
		vp.setAdapter(StatePagerAdapter);
	}

	public void init(){
		btnupcoming = (Button)findViewById( R.id.btnUp );
		btnpast = (Button)findViewById( R.id.btnPast );
		vp = (ViewPager)findViewById( R.id.vp );
	}
}

