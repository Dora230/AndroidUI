package com.example.dora.eletricity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dora.eletricity.R;
import com.example.dora.eletricity.activity.menuactivity.MainMain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dora on 2021/4/18.
 */

public class Register extends AppCompatActivity {

    private Button btn_reg;
    private EditText phone,passW,repassW;
    private final String TAG = "RegisterActivity";
//
//    String account = "";
//
//    private SharedPreferences sp;
//    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
//
//        Intent intent=getIntent();
//        account=intent.getStringExtra("account");

        phone=(EditText)findViewById(R.id.et_phone);
        passW=(EditText)findViewById(R.id.et_password);
        repassW=(EditText)findViewById(R.id.et_repassword);
        btn_reg=(Button)findViewById(R.id.btn_register);

        btn_reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String tel = phone.getText().toString();
                String password1 = passW.getText().toString();
                String passowrd2 = repassW.getText().toString();
                String pattern = "^[1]([3-9])[0-9]{9}$";


                if (tel.length()==0){
                    Toast.makeText(Register.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if (tel.length()<11){
                    Toast.makeText(Register.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                }else if (password1.trim().equals(passowrd2.trim())){
                    Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.setClass(getApplicationContext(), Login.class);
                    startActivity(intent);
                    Register.this.finish();
                }else{
                    Toast.makeText(Register.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

//                                           else if((mEtPassword1.getText().toString().trim()).equals(mEtPassword2.getText().toString().trim())){
//                                               Toast.makeText(RegisteActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();
//                                               RegisteActivity.this.finish();
//                                           }
//                                           else {
//                                               Toast.makeText(RegisteActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
//                                           }
//






//
//    private boolean isPhoneVaild(String PHONE){
//        if (PHONE==null){
//            return false;
//        }
//
//        String pattern="^[1]([3-9])[0-9]{9}$";
//        Pattern r=Pattern.compile(pattern);
//        Matcher m=r.matcher(PHONE);
//        return m.matches();
//    }
//
//    private boolean isPasswordVaild(String password){
//        return password!=null && password.trim().length()>5;
//    }
//
//    private void setOnFocusChangeErrMsg(final EditText editText, final String inputType, final String errMsg){
//        editText.setOnFocusChangeListener(
//                new View.OnFocusChangeListener(){
//
//                    @Override
//                    public void onFocusChange(View v, boolean hasFocus) {
//                        String inputStr=editText.getText().toString();
//                        if (!hasFocus){
//                            if (inputType=="phone"){
//                                if (isPhoneVaild(inputStr)){
//                                    editText.setError(null);
//                                }else{
//                                    editText.setError(errMsg);
//                                }
//                            }
//                            if (inputType=="password"){
//                                if (isPasswordVaild(inputStr)){
//                                    editText.setError(null);
//                                }else{
//                                    editText.setError(errMsg);
//                                }
//                            }
//                        }
//                    }
//                }
//        );
//    }
}
