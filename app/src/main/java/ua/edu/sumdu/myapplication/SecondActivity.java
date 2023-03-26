package ua.edu.sumdu.myapplication;

import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected String getStateFragment() {
        return "second_state_of_fragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void additionalButtonInit() {
        super.additionalButtonInit();

        Button activityButton = findViewById(R.id.back_button);
        activityButton.setOnClickListener(view -> finish());
    }
}