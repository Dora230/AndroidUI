package com.example.dora.eletricity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dora.eletricity.R;
import com.example.dora.eletricity.activity.menuactivity.MainMain;

/**
 * Created by Dora on 2021/4/18.
 */

public class Login extends AppCompatActivity {

    public Button btn1,btn2;
    private EditText editName;
    private EditText edtPsw;

    Intent intent=new Intent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        editName =(EditText)findViewById(R.id.et_number);
        edtPsw =(EditText)findViewById(R.id.et_password);

        btn1 = (Button) findViewById(R.id.btn_login);//绑定登录按钮
        btn2 = (Button) findViewById(R.id.btn_reg);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editName.getText().toString();
                String password=edtPsw.getText().toString();
                if (name.length()==0){
                    Toast.makeText(Login.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                if (password.length()==0){
                    Toast.makeText(Login.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }else if(password.length()<=4){
                    Toast.makeText(Login.this, "密码长度应大于4位", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                    intent.setClass(getApplicationContext(), MainMain.class);
                    startActivity(intent);
                    Login.this.finish();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setClass(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });


    }
}
