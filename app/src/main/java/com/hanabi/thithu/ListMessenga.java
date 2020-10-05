package com.hanabi.thithu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hanabi.thithu.adapter.MessageAdapter;
import com.hanabi.thithu.models.Message;

import java.util.ArrayList;
import java.util.Date;

public class ListMessenga extends AppCompatActivity {

    private MessageAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_messenga);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_mess);
        adapter = new MessageAdapter(getLayoutInflater());
        recyclerView.setAdapter(adapter);
        fillAdapter();
    }

    private void fillAdapter() {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(1, 1, "asfdt ayfd a sga adastyerc at uasduyt auduatdu ah iada ady uiasgd daj djk a"));
        messages.add(new Message(1, 2, "asfđádt ayfd adá đá  sga asgd daj djk a"));
        messages.add(new Message(1, 1, "asfdt ayfd a sgaá dá  asgd daj djk a"));
        messages.add(new Message(1, 1, "asfádasdt ayfd a sgda sda asgd daj djk a"));
        messages.add(new Message(1, 1, "asfdt ayfd a sga asgd daj djk a"));
        messages.add(new Message(1, 2, "asfdt ayfd a sá dá gđáa asgd daj djk a"));
        messages.add(new Message(1, 1, "asfdt ayfd a sga asgd daj djk a"));

        adapter.setData(messages);
    }
}