package com.issamelasri.moneymanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.issamelasri.moneymanager.R;
import com.issamelasri.moneymanager.ui.pojo.PostModel;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    final int RQ_CODE_ADD = 1;
    MyAdapter myAdapter;
    private Button button;
    private ListView listView;


    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        listView = root.findViewById(R.id.listView);
        button = root.findViewById(R.id.button);
        listView.setAdapter(myAdapter);
        ArrayList<PostModel> postModelArrayList = new ArrayList<>();
        postModelArrayList.add(new PostModel("102-Mar-20", 2000, "Expenses"));
        myAdapter = new MyAdapter(getContext(), R.layout.psot_item, postModelArrayList);
        listView.setAdapter(myAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddActivity.class);
                startActivityForResult(intent, RQ_CODE_ADD);
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RQ_CODE_ADD && resultCode == RESULT_OK) {
            PostModel postModel = (PostModel) data.getSerializableExtra(AddActivity.REQ_CODE_POSTS);
            myAdapter.addItem(postModel);

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}