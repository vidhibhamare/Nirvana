package com.example.nirvana.ui.premade_playlist;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nirvana.R;

public class PlaybackActivity extends AppCompatActivity {
    private SeekBar musicSeekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private boolean isPlaying = false;
    private ImageButton playButton, pauseButton, rewindButton, fastForwardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playback);

        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("SONG_TITLE");
        initializeMediaPlayer(songTitle);
        ImageView songThumbnailImageView = findViewById(R.id.songThumbnail);
        songThumbnailImageView.setImageResource(R.drawable.nirvana);


        musicSeekBar = findViewById(R.id.musicSeekBar);
        musicSeekBar.setMax(mediaPlayer.getDuration());

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
        if (songTitle.equals("englishchapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.englishchapter1);
        } else if (songTitle.equals("englishchapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.englishchapter2);
        } else if (songTitle.equals("englishchapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.englishchapter3);
        } else if (songTitle.equals("gujaratichapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.gujaratichapter1);
        } else if (songTitle.equals("gujaratichapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.gujaratichapter2);
        } else if (songTitle.equals("gujaratichapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.gujaratichapter3);
        } else if (songTitle.equals("hindichapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.hindichapter1);
        } else if (songTitle.equals("hindichapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.hindichapter2);
        } else if (songTitle.equals("hindichapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.hindichapter3);
        } else if (songTitle.equals("tamilchapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.tamilchapter1);
        } else if (songTitle.equals("tamilchapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.tamilchapter2);
        } else if (songTitle.equals("tamilchapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.tamilchapter3);
        } else if (songTitle.equals("marathichapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.marathichapter1);
        } else if (songTitle.equals("marathichapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.marathichapter2);
        } else if (songTitle.equals("marathichapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.marathichapter3);
        } else if (songTitle.equals("sanskritchapter1")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sanskritchapter1);
        } else if (songTitle.equals("sanskritchapter2")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sanskritchapter2);
        }else if (songTitle.equals("sanskritchapter3")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.sanskritchapter3);
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