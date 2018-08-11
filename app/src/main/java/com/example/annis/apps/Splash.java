package com.example.annis.apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class Splash extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash) {
        configSplash.setBackgroundColor(R.color.colorPrimary);
        configSplash.setAnimCircularRevealDuration(1500);
        configSplash.setLogoSplash(R.drawable.calm);
        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimLogoSplashTechnique(Techniques.BounceIn);
        configSplash.setTitleTextSize(0);
    }

    @Override
    public void animationsFinished() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("berhasil",1);
        startActivity(intent);
        finish();
    }

}