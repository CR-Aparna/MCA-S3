package com.example.sqlitedatabasesavedata;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText etName, etCell;
    TextView tvResult;
    ContactsDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etCell = findViewById(R.id.etCell);
        tvResult = findViewById(R.id.tvResult);
        db = new ContactsDB(this);

        findViewById(R.id.btnInsert).setOnClickListener(v -> insert());
        findViewById(R.id.btnShow).setOnClickListener(v -> showData());
        findViewById(R.id.btnUpdate).setOnClickListener(v -> update());
        findViewById(R.id.btnDelete).setOnClickListener(v -> delete());
    }

    private void insert() {
        try {
            db.open();
            db.insert(etName.getText().toString(), etCell.getText().toString());
            db.close();
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void showData() {
        try {
            db.open();
            Cursor c = db.fetch();
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append(c.getString(0)).append(": ");
                sb.append(c.getString(1)).append(", ");
                sb.append(c.getString(2)).append("\n");
            }
            tvResult.setText(sb.toString());
            db.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void update() {
        try {
            db.open();
            db.update("1", etName.getText().toString(), etCell.getText().toString());
            db.close();
            Toast.makeText(this, "Updated where id=1", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void delete() {
        try {
            db.open();
            db.delete("1");
            db.close();
            Toast.makeText(this, "Deleted where id=1", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

}
