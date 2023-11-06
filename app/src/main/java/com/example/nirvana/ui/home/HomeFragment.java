package com.example.nirvana.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nirvana.databinding.FragmentHomeBinding;
import com.example.nirvana.homePage;
import com.example.nirvana.ui.songsearch.PlaybacksearchActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    Button button5, button6, button7;
    TextView textView8;
    String song1;
    String song2;
    String song3;
    String mood = "indifferent";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homePage activity = (homePage) getActivity();
        if (activity != null) {
            mood = activity.mood;
        } else {
            mood = "indifferent"; // Set a default value or handle this case as needed.
        }

        textView8 = binding.textView8;
        textView8.setText(mood);

        button5 = binding.button5;
        button6 = binding.button6;
        button7 = binding.button7;

        if(mood.equalsIgnoreCase("happy")){
            textView8.setText("Feeling on top of the world? Here are some happy songs to keep the good vibes rolling.");
            song1 = "uffteriadaa";
            song2 = "nashese";
            song3 = "happy";
        } else if (mood.equalsIgnoreCase("sad")) {
            textView8.setText("It's okay to feel sad sometimes. Here are some songs that understand what you're going through.");
            song1 = "humkoyaadkaroge";
            song2 = "phirnaaisiraataayegi";
            song3 = "terehawaale";
        } else if (mood.equalsIgnoreCase("romantic")) {
            textView8.setText("Love is in the air! These romantic melodies will make your heart skip a beat.");
            song1 = "gerua";
            song2 = "manvalage";
            song3 = "raatanlambiyan";
        } else if (mood.equalsIgnoreCase("energetic")) {
            textView8.setText("Need a burst of energy? These high-energy tracks will get you moving and grooving in no time.");
            song1 = "one1234";
            song2 = "gandibaat";
            song3 = "saadadilvitu";
        } else if (mood.equalsIgnoreCase("relaxed")) {
            textView8.setText("It's time to unwind and relax. These soothing melodies will help you find your inner calm.");
            song1 = "dhakaddhakad";
            song2 = "heyganaraya";
            song3 = "mohmohkedhage";
        }else {
            textView8.setText("For those moments when you're feeling neutral or carefree, these songs are the perfect companion");
            song1 = "afganjalebi";
            song2 = "bannoteraswagger";
            song3 = "raghupatiraghav";
        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), PlaybacksearchActivity.class);
                intent.putExtra("SONG_TITLE", song1);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), PlaybacksearchActivity.class);
                intent.putExtra("SONG_TITLE", song2);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), PlaybacksearchActivity.class);
                intent.putExtra("SONG_TITLE", song3);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}