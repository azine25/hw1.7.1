package com.geek.myapplication11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geek.myapplication11.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClicks{
    RecyclerView rv;
    Adapter adapter;
    ArrayList<User> list = new ArrayList<>();
    private ChangeDialogFragment dialogFragment;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new Adapter();
        adapter.setOnClicks(this);
        adapter.add(getUsersList());
        binding.rv.setAdapter(adapter);
    }


    private ArrayList<User>  getUsersList() {
        for (int i = 0; i < 15; i++) {
            list.add(new User(0,R.color.white));
        }
        return list;
    }

    public void clickOn(User user, int pos) {
        dialogFragment = new ChangeDialogFragment();
        dialogFragment.setPos(pos);
        dialogFragment.show(getSupportFragmentManager(),"sss");
    }
}