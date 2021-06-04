package com.geek.myapplication11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.geek.myapplication11.databinding.FragmentDialogBinding;

public class ChangeDialogFragment extends DialogFragment {

    private FragmentDialogBinding binding;
    private int color =0;
    private int position;
    MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        activity = (MainActivity) requireActivity();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.rg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb1:
                    color = R.color.salad;
                    break;
                case R.id.rb2:
                    color = R.color.pruple2;
                    break;
                case R.id.rb3:
                    color = R.color.blu;
                    break;
            }
            binding.btnChange.setOnClickListener(this:: click);
        });

    }

    void click( View view){
        if (color!=0){
            activity.adapter.setColor(position,color);
            getDialog().dismiss();
        }
    }

    void setPos(int pos){
        this.position = pos;
    }

}