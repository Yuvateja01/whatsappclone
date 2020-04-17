package teja_123.example.android.mywts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

import static androidx.recyclerview.widget.LinearLayoutManager.*;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView users;

    private RecyclerView.LayoutManager userlayout;
    private RecyclerView.Adapter useradapter;
    ArrayList<Userobject> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        users=findViewById(R.id.recview);
        userlist= new ArrayList<>();

        initializeadapter();
        getcontacts();

    }

    private void getcontacts() {
        Cursor conts=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while(conts.moveToNext()){
            String name=conts.getString(conts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneno=conts.getString(conts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            Userobject contacts=new Userobject(name,phoneno);
            userlist.add(contacts);
            useradapter.notifyDataSetChanged();;
        }

    }

    private void initializeadapter() {
        userlayout=new LinearLayoutManager(this, VERTICAL,false);
        users.setHasFixedSize(false);
        users.setNestedScrollingEnabled(false);
        users.setLayoutManager(userlayout);
        useradapter=new UserListAdapter(userlist);
        users.setAdapter(useradapter);

    }
}
