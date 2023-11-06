package com.example.nirvana.ui.timer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nirvana.MainActivity;
import com.example.nirvana.R;
import com.example.nirvana.databinding.FragmentTimerBinding;

import java.lang.reflect.Field;

public class TimerFragment extends Fragment {
    private FragmentTimerBinding binding;
    private NumberPicker hoursPicker;
    private NumberPicker minutesPicker;
    private Button startTimerButton;
    private CountDownTimer countDownTimer;
    private TextView textViewTimer;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        hoursPicker = root.findViewById(R.id.hoursPicker);
        minutesPicker = root.findViewById(R.id.minutesPicker);
        startTimerButton = root.findViewById(R.id.startTimerButton);
        textViewTimer = root.findViewById(R.id.textViewTimer);

        int textColor = getResources().getColor(R.color.white);
        setNumberPickerTextColor(hoursPicker, textColor);
        setNumberPickerTextColor(minutesPicker, textColor);

        hoursPicker.setValue(0);
        minutesPicker.setValue(0);
        hoursPicker.setMinValue(0);
        hoursPicker.setMaxValue(23);
        minutesPicker.setMinValue(0);
        minutesPicker.setMaxValue(59);


        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedHours = hoursPicker.getValue();
                int selectedMinutes = minutesPicker.getValue();

                long timerDuration = (selectedHours * 60 + selectedMinutes) * 60 * 1000;

                countDownTimer = new CountDownTimer(timerDuration, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long totalSeconds = millisUntilFinished / 1000;
                        long remainingHours = totalSeconds / 3600;
                        long remainingMinutes = (totalSeconds % 3600) / 60;
                        long remainingSeconds = totalSeconds % 60;
                        textViewTimer.setText(String.format("%02d:%02d:%02d", remainingHours, remainingMinutes, remainingSeconds));
                    }

                    @Override
                    public void onFinish() {
                        // Handle timer completion
                        // Close the app
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("EXIT", true);
                        startActivity(intent);
                    }
                };

                countDownTimer.start();
            }
        });

        return root;
    }

    // Function to set the text color for a NumberPicker
    private void setNumberPickerTextColor(NumberPicker numberPicker, int color) {
        int count = numberPicker.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = numberPicker.getChildAt(i);
            if (child instanceof EditText) {
                try {
                    @SuppressLint("SoonBlockedPrivateApi") Field selectorWheelPaintField = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
                    selectorWheelPaintField.setAccessible(true);
                    ((Paint) selectorWheelPaintField.get(numberPicker)).setColor(color);
                } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
