package com.yourssohail.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean isSpinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);

        Picasso.get().load("https://pngimg.com/uploads/bottle/bottle_PNG2090.png")
                .into(bottle);


        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSpinning) {
                    int newDir = random.nextInt(1800);
                    float pivotX = bottle.getWidth() / 2;
                    float pivotY = bottle.getHeight() / 2;
                    Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
                    rotate.setDuration(2500);
                    rotate.setFillAfter(true);
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            isSpinning = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            isSpinning = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    lastDir = newDir;
                    bottle.startAnimation(rotate);
                }

            }
        });

    }
}
