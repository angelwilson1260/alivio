package com.cyboss.alivio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ViewHolder> {
    public List<contacts> list;
    public Context context;
public List_Adapter(Context context,List<contacts> list){
this.list=list;
this.context=context;
}

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list__adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(list.get(position).getName());
//        holder.number.setText(list.get(position).getNum());
        final String id=list.get(position).cntcsID;
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Id"+id,Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    View mView;
    public TextView name;
    public TextView number;
public ViewHolder(View itemView){
    super(itemView);
    mView=itemView;
    name=(TextView)mView.findViewById(R.id.Aname);
    number=(TextView)mView.findViewById(R.id.number);
}
}

}
