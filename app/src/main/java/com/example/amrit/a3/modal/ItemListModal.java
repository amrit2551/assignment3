package com.example.amrit.a3.modal;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by palak on 20/4/17.
 */

public class ItemListModal implements Parcelable {

	public static final Creator<ItemListModal> CREATOR = new Creator<ItemListModal>() {
		@Override
		public ItemListModal createFromParcel(Parcel in) {
			return new ItemListModal(in);
		}

		@Override
		public ItemListModal[] newArray(int size) {
			return new ItemListModal[size];
		}
	};
	private String name;
	private double population;
	public ItemListModal(String name, double population){
		this.name = name;
		this.population = population;
	}
private ItemListModal(final Parcel in){
	name =in.readString();
	population = in.readDouble();
}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
dest.writeString(name);
		dest.writeDouble(population);

	}
public String getName()
{
	return name;
}
public void setName(final String name){
	this.name = name;
}
public double getPopulation(){
	return population;
}
public void setPopulation(final double population){
	this.population= population;
}}

