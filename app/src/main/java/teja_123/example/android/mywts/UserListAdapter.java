package teja_123.example.android.mywts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {
    ArrayList<Userobject> userlist;
    public UserListAdapter(ArrayList<Userobject> userlist){
        this.userlist=userlist;
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,null,false);
        RecyclerView.LayoutParams lp=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutview.setLayoutParams(lp);
        UserListViewHolder userListViewHolder=new UserListViewHolder(layoutview);

        return userListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        holder.name.setText(userlist.get(position).getName());
        holder.phoneno.setText(userlist.get(position).getPhoneno());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class  UserListViewHolder extends RecyclerView.ViewHolder{
        public TextView phoneno,name;
        public UserListViewHolder(View view){
            super(view);
            name=view.findViewById(R.id.textView2);
            phoneno=view.findViewById(R.id.textView3);

        }

    }
}
