package com.suse.criminalintent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/18 15:17
 */
public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleFiled;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //第三个参数告诉布局生成器是否将生成的视图添加给父视图
        View view = inflater.inflate(R.layout.fragment_crime,container,false);
        mTitleFiled = view.findViewById(R.id.crime_title);
        mTitleFiled.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = view.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = view.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener((buttonView,isChecked)-> mCrime.setSolved(isChecked));
        return view;
    }
}
