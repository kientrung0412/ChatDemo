package com.hanabi.thithu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hanabi.thithu.adapter.MessageAdapter;
import com.hanabi.thithu.api.ApiBuilder;
import com.hanabi.thithu.models.Message;
import com.hanabi.thithu.models.MessageResponse;
import com.hanabi.thithu.models.User;


import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMessenga extends AppCompatActivity implements View.OnClickListener {

    private MessageAdapter adapter;
    private RecyclerView recyclerView;
    private User user;
    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_messenga);
        user = (User) getIntent().getSerializableExtra(User.class.getName());
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_mess);
        imageView = findViewById(R.id.iv_send);
        editText = findViewById(R.id.edt_mess);

        imageView.setOnClickListener(this);
        adapter = new MessageAdapter(getLayoutInflater(), user);
        recyclerView.setAdapter(adapter);
        fillAdapter();
    }

    private void fillAdapter() {

        new Thread(() -> ApiBuilder.getInstance().listChat().enqueue(new Callback<ArrayList<Message>>() {
            @Override
            public void onResponse(Call<ArrayList<Message>> call, Response<ArrayList<Message>> response) {
                adapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Message>> call, Throwable t) {
                Toast.makeText(ListMessenga.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })).start();


    }


    @Override
    public void onClick(View v) {
        ApiBuilder.getInstance().chat(user.getUsername(), editText.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                editText.setText("");
                fillAdapter();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}