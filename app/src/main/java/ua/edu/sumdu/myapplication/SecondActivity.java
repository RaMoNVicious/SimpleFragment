package ua.edu.sumdu.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button mButton, mActivityButton;

    private boolean isFragmentDisplayed = false;

    static final String STATE_FRAGMENT = "state_of_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mButton = findViewById(R.id.open_button);
        mActivityButton = findViewById(R.id.back_button);

        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT);
            if (isFragmentDisplayed) {
                mButton.setText(R.string.close);
            }
        }
        mButton.setOnClickListener(view -> {
            if (!isFragmentDisplayed) {
                displayFragment();
            } else {
                closeFragment();
            }
        });
        mActivityButton.setOnClickListener(view -> finish());
    }

    public void displayFragment() {
        SimpleFragment simpleFragment = SimpleFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, simpleFragment).addToBackStack(null).commit();

        mButton.setText(R.string.close);
        isFragmentDisplayed = true;
    }

    public void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);
        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }
        mButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(STATE_FRAGMENT, isFragmentDisplayed);
        super.onSaveInstanceState(savedInstanceState);
    }
}