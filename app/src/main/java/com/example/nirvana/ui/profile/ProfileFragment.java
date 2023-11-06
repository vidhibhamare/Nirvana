package com.example.nirvana.ui.profile;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nirvana.databinding.FragmentProfileBinding;
import com.example.nirvana.dbHandler;
import com.example.nirvana.homePage;

public class ProfileFragment extends Fragment{
    EditText editTextUser, editTextPass, editTextPass2;
    Button update;
    String username;
    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homePage activity = (homePage) getActivity();
        username = activity.username;

        editTextUser = binding.editTextUser;
        editTextPass = binding.editTextPass;
        editTextPass2 = binding.editTextPass2;
        editTextUser.setText(username);

        update = binding.button2;
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUsername = editTextUser.getText().toString();
                String newPassword = editTextPass.getText().toString();
                String newPassword2 = editTextPass2.getText().toString();

                if (newPassword.equals(newPassword2)) {
                    dbHandler db = new dbHandler(requireContext());

                    int rowsUpdated = db.updateUserCredentials(username, newUsername, newPassword);
                    if (rowsUpdated > 0) {
                        Toast.makeText(getContext(), "Update Successful!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getContext(), "Update Failed!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("PASSWORDS DO NOT MATCH");
                    builder.setTitle("Alert!");
                    builder.setCancelable(false);
                    builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                        dialog.cancel();
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
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