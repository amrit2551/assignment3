package com.example.amrit.a3.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.amrit.a3.R;

/**
 * Created by palak on 21/4/17.
 */

public class UpcomingAndPastFragment extends Fragment {
	private String mMode;
	private ViewPager viewPager;
	private Button btnUpcoming, btnPast;
	private TextView tvdisplayhead;

	public UpcomingAndPastFragment() {

	}

	public UpcomingAndPastFragment(final String mMode) {

		this.mMode = mMode;
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		View view = inflater.inflate( R.layout.frag_up_past, container, false );
		viewPager = (ViewPager) view.findViewById( R.id.vpSwipe );
		btnUpcoming = (Button) view.findViewById( R.id.btn1 );
		btnPast = (Button) view.findViewById( R.id.btn2 );
		tvdisplayhead = (TextView) view.findViewById( R.id.displaySelectedItem );

		if ("upcoming".equals( mMode )) {
			tvdisplayhead.setText( "Upcoming List" );
			btnUpcoming.setText( "Pending" );
			btnPast.setText( "Accepted" );
		} else {
			tvdisplayhead.setText( "Past List" );
			btnUpcoming.setText( "Canceled" );
			btnPast.setText( "Completed" );
		}
		viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(final int position) {
				if (position == 0) {
					btnUpcoming.setBackgroundResource( R.color.colorAccent );
					btnPast.setBackgroundResource( R.color.colorPrimaryDark );
				} else {
					btnUpcoming.setBackgroundResource( R.color.colorAccent );
					btnPast.setBackgroundResource( R.color.colorPrimary );
				}
			}

			@Override
			public void onPageScrollStateChanged(final int state) {

			}
		} );
		FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()){
			@Override
			public android.support.v4.app.Fragment getItem(final int position) {

				if ("upcoming".equals(mMode)) {
					switch (position) {
						case 0:
							return new PendingAcceptCompleteCancelFragment("pending");
						case 1:
							return new PendingAcceptCompleteCancelFragment("accepted");
						default:
							return null;
					}
				} else {
					switch (position) {
						case 0:
							return new PendingAcceptCompleteCancelFragment( "cancelled");
						case 1:
							return new PendingAcceptCompleteCancelFragment("completed");
						default:
							return null;
					}
				}
			}

			@Override
			public int getCount() {
				return 2;
			}
		};
		viewPager.setAdapter( fragmentStatePagerAdapter );

		return view;
	}
}









