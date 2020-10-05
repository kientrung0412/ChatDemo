package com.hanabi.thithu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_LOGIN = 1;

    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnRes;
    private AlertDialog dialog;

    public LoginActivity() {
        super("LoginActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRes = findViewById(R.id.btn_res);

        btnLogin.setOnClickListener(this);
        btnRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    showAlertDialog();
                    break;
                }
                Toast.makeText(this, String.format("Username: %s, password: %s", username, password), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_ok:
                dialog.dismiss();
            case R.id.btn_res:
                changeRes();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }

    private void changeRes() {
        Intent intent = new Intent(this, ReginsterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.alert_login, null);
        Button btnOk = view.findViewById(R.id.btn_ok);
        Button btnCancel = view.findViewById(R.id.btn_cancel);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        builder.setView(view);

        dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                edtUsername.setText(data.getStringExtra(ReginsterActivity.EXTRA_USERNAME));
                edtPassword.setText(data.getStringExtra(ReginsterActivity.EXTRA_PASSWORD));
            }
        }
    }
}