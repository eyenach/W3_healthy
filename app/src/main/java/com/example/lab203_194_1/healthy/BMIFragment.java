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

import org.w3c.dom.Text;

public class BMIFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initCalculateBtn();
        initBackBtn();

    }

    public void initCalculateBtn (){
        Button _calBtn = (Button) getView().findViewById(R.id.bmi_cal_btn);
        _calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _height = (EditText) getView().findViewById(R.id.bmi_height);
                EditText _weight = (EditText) getView().findViewById(R.id.bmi_weight);
                TextView _result = (TextView) getView().findViewById(R.id.bmi_result);
                String _heightStr = _height.getText().toString();
                String _weightStr = _weight.getText().toString();
                String _resultStr = _result.getText().toString();

                if (_heightStr.isEmpty() || _weightStr.isEmpty()) {
                    Toast.makeText(
                            getActivity(), "กรุณาระบุข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT
                    ).show();
                    Log.d("BMI", "FIELD NAME IS EMPTY");
                } else {
                    Float _heightflo = Float.parseFloat(_heightStr)/100;
                    Float _weightflo = Float.parseFloat(_weightStr);
                    Float _resultflo = _weightflo/(_heightflo*_heightflo);
                    _result.setText(_resultflo.toString());
                    Log.d("BMI", "BMI IS VALUE");
                }
            }
        });
    }

    public void initBackBtn(){
        Button _backBtn = (Button) getView().findViewById(R.id.bmi_back_btn);
        _backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new MenuFragment())
                        .commit();
            }
        });
    }
}
