package com.example.pr3_popitka2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment_2 extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        Button button = view.findViewById(R.id.button3);
        EditText editText = view.findViewById(R.id.editTextText4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();
                Bundle result = new Bundle();
                result.putString("bundKey", enteredText);
                getParentFragmentManager().setFragmentResult("reqKey",
                        result);
            }
        });
        return view;
    }
}