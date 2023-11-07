package com.example.nirvana.ui.record;

import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.nirvana.R;
import com.example.nirvana.databinding.FragmentHomeBinding;

import java.io.File;

public class RecordFragment extends Fragment {
    private FragmentHomeBinding binding;
    private static final int MICROPHONE_PERMISSION_CODE = 200;
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    Button recordButton, stopButton, playButton;
    private boolean isRecording = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_record, container, false);

        recordButton = root.findViewById(R.id.record);
        stopButton = root.findViewById(R.id.stop);
        playButton = root.findViewById(R.id.play);

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRecordPressed(v);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStopPressed(v);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlayPressed(v);
            }
        });

        // Check and request microphone permission
        if (isMicrophonePresent()) {
            getMicrophonePermission();
        }

        return root;
    }

    public void btnRecordPressed(View v) {
        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();
            isRecording = true;
            Toast.makeText(requireContext(), "RECORDING IS STARTED", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnStopPressed(View v) {
        if (isRecording) {
            try {
                mediaRecorder.stop();
            } catch (IllegalStateException e) {
                // Handle the exception
                e.printStackTrace();
            } finally {
                mediaRecorder.release();
                mediaRecorder = null;
                isRecording = false;
            }
        }
        Toast.makeText(requireContext(), "RECORDING HAS BEEN STOPPED", Toast.LENGTH_LONG).show();
    }


    public void btnPlayPressed(View v) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(requireContext(), "RECORDING IS PLAYING", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isMicrophonePresent() {
        if (requireContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            return true;
        } else {
            return false;
        }
    }

    private void getMicrophonePermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]
                    {android.Manifest.permission.RECORD_AUDIO}, MICROPHONE_PERMISSION_CODE);
        }
    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(requireContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory, "testRecordingFile" + ".mp3");
        return file.getPath();
    }
}