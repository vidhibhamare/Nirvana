package com.example.nirvana.ui.premade_playlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nirvana.R;

public class PremadeplylistActivity extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_playlist, container, false);

        ImageView marathiCategory = root.findViewById(R.id.myImageView);
        ImageView englishCategory = root.findViewById(R.id.myImageView2);
        ImageView hindiCategory = root.findViewById(R.id.myImageView3);
        ImageView sanskritCategory = root.findViewById(R.id.myImageView4);
        ImageView tamilCategory = root.findViewById(R.id.myImageView5);
        ImageView gujaratiCategory = root.findViewById(R.id.myImageView6);

        marathiCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MarathiActivity.class);
                startActivity(intent);
            }
        });

        englishCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EnglishActivity.class);
                startActivity(intent);
            }
        });

        hindiCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HindiActivity.class);
                startActivity(intent);
            }
        });

        sanskritCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SanskritActivity.class);
                startActivity(intent);
            }
        });

        tamilCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TamilActivity.class);
                startActivity(intent);
            }
        });

        gujaratiCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GujaratiActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
