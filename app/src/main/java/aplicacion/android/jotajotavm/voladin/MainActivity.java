package aplicacion.android.jotajotavm.voladin;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random random = new Random();
    private Button voladoBtn;
    private ImageView moneda;
    private final int interval = 1000; // 1 Second
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        public void run() {
            int numberRandom = random.nextInt(2);
            if (numberRandom == 1) {
                moneda.setImageResource(R.mipmap.moneda_cara);
            } else {
                moneda.setImageResource(R.mipmap.moneda_cruz);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voladoBtn = (Button) findViewById(R.id.button);
        moneda = (ImageView) findViewById(R.id.imageViewMoneda);

        voladoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation;
                animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.sample_animation);
                    moneda.setImageResource(R.mipmap.moneda_sin_cara);

                        moneda.startAnimation(animation);
                        handler.postAtTime(runnable, System.currentTimeMillis()+interval);
                        handler.postDelayed(runnable, interval);

                }
        });

    }

}
