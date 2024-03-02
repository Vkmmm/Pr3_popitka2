package com.example.pr3_popitka2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_1 extends Fragment {
    private int defaultValue = 0;
    private static final String TAG = "MyApp";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("some_int", defaultValue);
        }
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
           }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        TextView textView = view.findViewById(R.id.ch_text);
        getChildFragmentManager().setFragmentResultListener("reqKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundKey");
                textView.setText(result);
            }
        });
        Fragment_2 fragment2 = new Fragment_2();
        getChildFragmentManager().beginTransaction()
                .add(R.id.fragment_ch, fragment2)
                .addToBackStack(null)
                .commit();


        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", textView.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey",
                        result);
            }
        });
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView");
        return view;
    }
    @Override
    public void onViewCreated (View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(),"onViewCreated", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onViewCreated");
    }

    public void onViewStateRestored (View view, Bundle savedInstanceState)
    {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(),"onViewStateRestored", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onViewStateRestored");
    }
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }
}