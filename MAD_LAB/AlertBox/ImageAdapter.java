package com.example.gridview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class imageadapter extends ArrayAdapter {
 private Context mContext;
 private String gvstring[];
 private int imgarray[];
 LayoutInflater inflator=null;
 public imageadapter(@NonNull Context c, int resource,String s[],int x[]) {
 super(c, resource);
 mContext=c;
 gvstring=s;
 imgarray=x;
 inflator=LayoutInflater.from(c);
 }
 @Override
 public int getCount(){
 return imgarray.length;
 }
 public Object getItem(int position) {
 return 0;
 }
 public View getView(int position, View convertView, ViewGroup parent) {
 if (convertView == null)
 convertView = inflator.inflate(R.layout.lview, null);
 TextView country = (TextView) convertView.findViewById(R.id.tv1);
 ImageView icon = (ImageView) convertView.findViewById(R.id.imgv1);
 icon.setImageResource(imgarray[position]);
 country.setText(gvstring[position]);
 return convertView;
 }
}
