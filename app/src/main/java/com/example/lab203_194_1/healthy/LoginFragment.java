package com.example.lab203_194_1.healthy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initLoginBtn();
        initRegisterBtn();

    }

    void initLoginBtn(){
        Button _loginBtn = (Button) getView().findViewById(R.id.login_login_btn);
        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _userId = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.login_password);
                String _userIdStr = _userId.getText().toString();
                String _passwordStr = _password.getText().toString();

                if (_userIdStr.isEmpty() || _passwordStr.isEmpty()) {
                    Toast.makeText(
                            getActivity(), "กรุณาระบุ user or password", Toast.LENGTH_SHORT
                    ).show();
                } else if (_userIdStr.equals("admin") && _passwordStr.equals("admin")) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new MenuFragment())
                            .addToBackStack(null)
                            .commit();
                    Log.d("USER", "GOTO BMI");
                } else {
                    Toast.makeText(
                            getActivity(), "user or password ไม่ถูกต้อง", Toast.LENGTH_SHORT
                    ).show();
                    Log.d("USER", "INVALID USER OR PASSWORD");
                }
            }
        });
    }

    void initRegisterBtn(){
        TextView _regBtn = (TextView) getView().findViewById(R.id.login_reg_btn);
        _regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("USER", "GOTO REGISTER");
            }
        });
    }
}
