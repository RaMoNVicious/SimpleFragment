package ua.edu.sumdu.myapplication;

import android.content.Intent;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    @Override
    protected String getStateFragment() {
        return "main_state_of_fragment";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void additionalButtonInit() {
        super.additionalButtonInit();

        Button activityButton = findViewById(R.id.next_button);
        activityButton.setOnClickListener(view ->
                startActivity(new Intent(this, SecondActivity.class))
        );
    }
}