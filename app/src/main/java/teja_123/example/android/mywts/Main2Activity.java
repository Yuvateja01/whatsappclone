package teja_123.example.android.mywts;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button users=findViewById(R.id.Users);
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
                permissions();

            }
        });


        }

    private void permissions() {
        requestPermissions(new String[]{Manifest.permission.WRITE_CONTACTS,Manifest.permission.READ_CONTACTS},1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.settings:
                Toast t=Toast.makeText(this,"We are Working on This.Not Available Currently",Toast.LENGTH_LONG);
                t.show();
                return true;
            case R.id.contactdeveloper:
                Toast t1=Toast.makeText(this,"Sai Yuva Teja Gorthy.mail me at yuvas2001@gmail.com",Toast.LENGTH_LONG);
                t1.show();
                return true;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
