package com.neu.util;

import android.app.Activity;
import android.view.View;

public final class ViewUtil {

	public static <T>T getView(Activity context,int id){
		View view=context.findViewById(id);
		return (T)view;
	}
}
