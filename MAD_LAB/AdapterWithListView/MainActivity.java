package com.example.adapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
String s[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
ListView lv;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
lv=(ListView) findViewById(R.id.iv);
ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.textview,s);
lv.setAdapter(adapter);
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
Toast.makeText(getApplicationContext(),lv.getItemAtPosition(position).toString(),T
oast.LENGTH_SHORT).show();
}
});
}
}
