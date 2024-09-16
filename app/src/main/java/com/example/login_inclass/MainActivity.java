package com.example.login_inclass;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Tìm các view từ layout
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        TextView dangki = findViewById(R.id.dangki);

        // Thiết lập sự kiện click cho button login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = username.getText().toString();
                String pass = password.getText().toString();

                // Hiển thị thông báo đăng nhập
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin đăng nhập")
                        .setMessage("Username: " + ten + "\nPassword: " + pass)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        // Thiết lập sự kiện click cho TextView "Đăng ký"
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Điều hướng sang màn hình đăng ký
                Intent intent = new Intent(MainActivity.this, RegisterLogin.class);
                startActivity(intent);
            }
        });
    }
}
