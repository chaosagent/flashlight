package com.chaosagent.flashlight;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    Context context = getApplicationContext();

    Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTorch() {
        if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            Toast toast = Toast.makeText(context, "Device does not have camera LED", Toast.LENGTH_SHORT);
            toast.show();
        }
        cam = Camera.open();
        Camera.Parameters p = cam.getParameters();
        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        cam.startPreview();
    }

    public void stopTorch() {
        cam.stopPreview();
        cam.release();
    }
}
