package com.example.nirvana.ui.songsearch;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nirvana.R;

public class PlaybacksearchActivity extends AppCompatActivity {
    private SeekBar musicSeekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private boolean isPlaying = false;
    private ImageButton playButton, pauseButton, rewindButton, fastForwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playbacksearch);

        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("SONG_TITLE");
        initializeMediaPlayer(songTitle);

        ImageView songThumbnailImageView = findViewById(R.id.songThumbnail);
        songThumbnailImageView.setImageResource(R.drawable.shlok);

        musicSeekBar = findViewById(R.id.musicSeekBar);
        if (mediaPlayer != null) {
            musicSeekBar.setMax(mediaPlayer.getDuration());
        }


        playButton = findViewById(R.id.button_Play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        pauseButton = findViewById(R.id.button_Pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseSong();
            }
        });

        rewindButton = findViewById(R.id.button_Rewind);
        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewindSong();
            }
        });

        fastForwardButton = findViewById(R.id.button_FastForward);
        fastForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fastForwardSong();
            }
        });

        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateSeekBar();
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private void initializeMediaPlayer(String songTitle) {
        int songResource = 0;
        if (songTitle.equals("marathichapter1")) {
            songResource = R.raw.marathichapter1;
        } else if (songTitle.equals("marathichapter2")) {
            songResource = R.raw.marathichapter2;
        } else if (songTitle.equals("marathichapter3")) {
            songResource = R.raw.marathichapter3;
        } else if (songTitle.equals("hindichapter1")) {
            songResource = R.raw.hindichapter1;
        } else if (songTitle.equals("hindichapter2")) {
            songResource = R.raw.hindichapter2;
        } else if (songTitle.equals("hindichapter3")) {
            songResource = R.raw.hindichapter3;
        } else if (songTitle.equals("tamilchapter1")) {
            songResource = R.raw.tamilchapter1;
        } else if (songTitle.equals("tamilchapter2")) {
            songResource = R.raw.tamilchapter2;
        } else if (songTitle.equals("tamilchapter3")) {
            songResource = R.raw.tamilchapter3;
        } else if (songTitle.equals("englishchapter1")) {
            songResource = R.raw.englishchapter1;
        } else if (songTitle.equals("englishchapter2")) {
            songResource = R.raw.englishchapter2;
        } else if (songTitle.equals("englishchapter3")) {
            songResource = R.raw.englishchapter3;
        } else if (songTitle.equals("gujaratichapter1")) {
            songResource = R.raw.gujaratichapter1;
        } else if (songTitle.equals("gujaratichapter2")) {
            songResource = R.raw.gujaratichapter2;
        } else if (songTitle.equals("gujaratichapter3")) {
            songResource = R.raw.gujaratichapter3;
        } else if (songTitle.equals("sanskritchapter1")) {
            songResource = R.raw.sanskritchapter1;
        } else if (songTitle.equals("sanskritchapter2")) {
            songResource = R.raw.sanskritchapter2;
        } else if (songTitle.equals("sanskritchapter3")) {
            songResource = R.raw.sanskritchapter3;
        } else if (songTitle.equals("raatanlambiyan")) {
            songResource = R.raw.raatanlambiyan;
        } else if (songTitle.equals("manvalage")) {
            songResource = R.raw.manvalage;
        } else if (songTitle.equals("phirnaaisiraataayegi")) {
            songResource = R.raw.phirnaaisiraataayegi;
        } else if (songTitle.equals("humkoyaadkaroge")) {
            songResource = R.raw.humkoyaadkaroge;
        } else if (songTitle.equals("gerua")) {
            songResource = R.raw.gerua;
        } else if (songTitle.equals("raghupatiraghav")) {
            songResource = R.raw.raghupatiraghav;
        } else if (songTitle.equals("bannoteraswagger")) {
            songResource = R.raw.bannoteraswagger;
        } else if (songTitle.equals("afganjalebi")) {
            songResource = R.raw.afganjalebi;
        } else if (songTitle.equals("mohmohkedhage")) {
            songResource = R.raw.mohmohkedhage;
        } else if (songTitle.equals("heganaraya")) {
            songResource = R.raw.heganaraya;
        } else if (songTitle.equals("dhakaddhakad")) {
            songResource = R.raw.dhakaddhakad;
        } else if (songTitle.equals("happy")) {
            songResource = R.raw.happy;
        }  else if (songTitle.equals("nashese")) {
            songResource = R.raw.nashese;
        } else if (songTitle.equals("uffteriadaa")) {
            songResource = R.raw.uffteriadaa;
        } else if (songTitle.equals("saadadilvitu")) {
            songResource = R.raw.saadadilvitu;
        } else if (songTitle.equals("one1234")) {
            songResource = R.raw.one1234;
        } else if (songTitle.equals("gandibaat")) {
            songResource = R.raw.gandibaat;
        }

        if (songResource != 0) {
            mediaPlayer = MediaPlayer.create(this, songResource);
        }
    }

    private void playSong() {
        if (!isPlaying) {
            mediaPlayer.start();
            isPlaying = true;
            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
        }
    }

    private void pauseSong() {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            playButton.setEnabled(true);
            pauseButton.setEnabled(false);
        }
    }

    private void rewindSong() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int newPosition = currentPosition - 5000;

        if (newPosition < 0) {
            newPosition = 0;
        }

        mediaPlayer.seekTo(newPosition);
    }

    private void fastForwardSong() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int duration = mediaPlayer.getDuration();
        int newPosition = currentPosition + 5000;

        if (newPosition > duration) {
            newPosition = duration;
        }

        mediaPlayer.seekTo(newPosition);
    }

    private void updateSeekBar() {
        if (mediaPlayer != null && isPlaying) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            musicSeekBar.setProgress(currentPosition);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
