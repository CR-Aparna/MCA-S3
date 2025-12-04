package com.example.gridview;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
public class MainActivity extends AppCompatActivity {
 GridView gv;
 String[] gridViewString={"pic1","pic2","pic3","pic4","pic5","pic6","pic7"};
 public int
 imgarray[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawab
le.f,R.drawable.g};
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 imageadapter imageAdapter=new 
imageadapter(this,R.layout.lview,gridViewString,imgarray);
 gv=findViewById(R.id.gridview);
 gv.setAdapter(imageAdapter);
 gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 AlertDialog.Builder bldr;
 bldr=new AlertDialog.Builder(MainActivity.this);
 bldr.setTitle("Title");
 AlertDialog alrt=bldr.create();
 alrt.setMessage(gridViewString[position]);
 alrt.show();
 }
 });
 }
}
