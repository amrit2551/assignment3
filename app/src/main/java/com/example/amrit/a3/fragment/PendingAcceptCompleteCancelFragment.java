package com.example.amrit.a3.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amrit.a3.R;

/**
 * Created by palak on 21/4/17.
 */

public class PendingAcceptCompleteCancelFragment extends Fragment {
	private String mode;
	private TextView tvDispay;

	public PendingAcceptCompleteCancelFragment(final String mode){
		this.mode = mode;
	}
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup viewGroup, final Bundle savedInstance) {
		View view;
		view = inflater.inflate(R.layout.frag_pendingaccept_completecancel, null);
		tvDispay = (TextView) view.findViewById( R.id.tv_display);

		if ("pending".equals(mode)) {
			tvDispay.setText("Pending");
		} else if ("accepted".equals(mode)) {
			tvDispay.setText("Accepted");
		} else if ("canceled".equals(mode)) {
			tvDispay.setText("Canceled");
		} else {
			tvDispay.setText("Completed");
		}

		return view;
	}
}
