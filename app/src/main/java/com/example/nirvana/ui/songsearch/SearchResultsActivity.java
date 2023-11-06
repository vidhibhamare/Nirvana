package com.example.nirvana.ui.songsearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.nirvana.R;

public class SearchResultsActivity extends Fragment {

    private SearchView searchView;
    private ListView songListView;
    private String[] songs = {"marathichapter1", "marathichapter2", "marathichapter2", "hindichapter1",
            "hindichapter2", "hindichapter3", "tamilchapter1", "tamilchapter2",
            "tamilchapter3", "englishchapter1", "englishchapter2","englishchapter3",
            "gujaratichapter1","gujaratichapter2","gujaratichapter3","sanskritchapter1",
            "sanskritchapter2","sanskritchapter3","raatanlambiyan","manvalage",
            "phirnaaisiraataayegi","humkoyaadkaroge","gerua","raghupatiraghav","bannoteraswagger",
            "afganjalebi","mohmohkedhage","heganaraya","dhakaddhakad","happy","nashese","uffteriadaa",
            "saadadilvitu","one1234","gandibaat"};

    public SearchResultsActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        searchView = view.findViewById(R.id.searchView);
        songListView = view.findViewById(R.id.songListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.custom_list_item, songs);

        songListView.setAdapter(adapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected song
                String selectedSong = songs[position];

                // Create an Intent to navigate to the PlaybacksearchActivity
                Intent intent = new Intent(requireContext(), PlaybacksearchActivity.class);
                intent.putExtra("SONG_TITLE", selectedSong);
                startActivity(intent);
            }
        });

        // Set up the SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle the search query here and filter the results
                adapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle real-time filtering if needed
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return view;
    }
}
