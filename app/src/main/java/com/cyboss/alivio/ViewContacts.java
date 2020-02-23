package com.cyboss.alivio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class ViewContacts extends AppCompatActivity {
    private final String COLLECTION_KEY = "Rescue";

    //Views
    private TextView mHeaderView;
    private RecyclerView mMainlist;

    //Firebase
    private FirebaseFirestore db;
    private List_Adapter list_adapter;

    private List<contacts> list;
    private static final String TAG="FireLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contacts);
        mHeaderView=(TextView)findViewById(R.id.HeadContact);
//        ContactList=(ListView)findViewById(R.id.ContactList);
        //get Database
        list=new ArrayList<>();
        list_adapter=new List_Adapter(getApplicationContext(),list);
        db = FirebaseFirestore.getInstance();
        mMainlist=(RecyclerView)findViewById(R.id.recycle1);
        mMainlist.setHasFixedSize(true);
        mMainlist.setLayoutManager(new LinearLayoutManager(this));
        mMainlist.setAdapter(list_adapter);
        db.collection("Rescue").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots,  FirebaseFirestoreException e) {
                if(e != null){
                    Log.d(TAG,"Error"+e.getMessage());
                }
                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType()==DocumentChange.Type.ADDED){
                        String user_id=doc.getDocument().getId();
                        contacts contact=doc.getDocument().toObject(contacts.class).withId(user_id);
                        list.add(contact);
                        list_adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
