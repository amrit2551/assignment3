package com.example.amrit.a3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amrit.a3.R;
import com.example.amrit.a3.modal.ItemListModal;
import com.example.amrit.a3.ui.DisplayItem;

import java.util.ArrayList;

/**
 * Created by palak on 20/4/17.
 */

public class ItemAdapter extends android.support.v7.widget.RecyclerView.Adapter<ItemAdapter.ViewHolder> {
	private Context context;
	private ArrayList<ItemListModal> itemsList;
	private String mode;

	public ItemAdapter(final Context context, final ArrayList<ItemListModal> itemList, final String mode) {
		this.context = context;
		this.itemsList = itemList;
		this.mode = mode;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.custom_row_layout, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		ItemListModal listModal = itemsList.get( position );
		if (mode.equals("upcoming")) {
			holder.tvName.setText(listModal.getName());
			holder.tvpop.setText(String.valueOf( listModal.getPopulation() ));
		} else if (mode.equals("past")) {
			holder.tvName.setText(listModal.getName());
			holder.tvpop.setText(String.valueOf( listModal.getPopulation() ));
		} else {
			holder.tvName.setText(listModal.getName());
			holder.tvpop.setText(String.valueOf( listModal.getPopulation() ));
		}
	}

		@Override
		public int getItemCount() {

			return itemsList.size();
		}

		public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
			public TextView tvName, tvpop;
			/**
			 * @param itemView item View
			 */
			public ViewHolder(final View itemView) {
				super( itemView );
				tvName = (TextView) itemView.findViewById( R.id.name );
				tvpop = (TextView) itemView.findViewById( R.id.population );
				itemView.setOnClickListener( this );
			}

			@Override
			public void onClick(final View v) {
				final int pos = getAdapterPosition();
				Intent intent = new Intent( context, DisplayItem.class );
				context.startActivity( intent );
			}
		}
	}
