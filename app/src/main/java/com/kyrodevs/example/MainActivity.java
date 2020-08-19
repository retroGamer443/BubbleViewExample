package com.kyrodevs.example;

import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);

        BubbleView bv = new BubbleView(this);
        bv.setTextSize((int) Utility.spToPx(16, this));
        bv.setPadding(20, 10, 30, 10);
        bv.setTextColor(Color.WHITE);
        bv.setBackgroundColor(Color.parseColor("#31cf80"));
        bv.setText("lorem ipsum dollar sit \namet, lorem ipsum");
        layout.addView(bv);
        setContentView(layout);
    }
}