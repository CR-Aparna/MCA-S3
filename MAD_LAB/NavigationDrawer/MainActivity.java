package com.example.navigation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
public class MainActivity extends AppCompatActivity {
DrawerLayout dl;
ActionBarDrawerToggle abdg;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
dl=(DrawerLayout)findViewById(R.id.my_drawer_layout);
abdg =new ActionBarDrawerToggle(this,dl, R.string.nav_open,
R.string.nav_close);
dl.addDrawerListener(abdg);
abdg.syncState();
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
navView.setNavigationItemSelectedListener(new
NavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
int itemId = menuitem.getItemId();
if (itemId == R.id.nav_account) {
Toast.makeText(getApplicationContext(), menuitem.getTitle(),
Toast.LENGTH_SHORT).show();
}
else if (itemId == R.id.nav_settings) {
Toast.makeText(getApplicationContext(), menuitem.getTitle(),
Toast.LENGTH_SHORT).show();

}
else if (itemId == R.id.nav_logout) {
Toast.makeText(getApplicationContext(), menuitem.getTitle(),
Toast.LENGTH_SHORT).show();
}
return false;
}
});
}
public boolean onOptionsItemSelected(@NonNull MenuItem item)
{
if (abdg.onOptionsItemSelected(item))
return true;
return super.onOptionsItemSelected(item);
}
}
