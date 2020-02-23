package com.cyboss.alivio;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    private String TAG="RecyclerView";
    View mView;
    StorageReference storageReference=FirebaseStorage.getInstance().getReference("All_Image_Uploads");

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView=itemView;
    }
    public void setDetails(Context ctx,String title,String body,String photo)
    {
        TextView tv1=mView.findViewById(R.id.textHead);
        TextView tv2=mView.findViewById(R.id.textView2);
        ImageView iv=mView.findViewById(R.id.img);
        tv1.setText(title);
        tv2.setText(body);
        Log.d(TAG, "setDetails: ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+photo);
        Picasso.get()
                .load(photo)
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(iv);
    }
}
