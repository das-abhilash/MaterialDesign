package in.zollet.abhilash.materialdesign;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraFragment extends Fragment {
    private static final int PERMISSIONS_REQUEST = 1000;

    private Camera mCamera;
    private CameraPreview mPreview;

    public CameraFragment() {
    }

    public static CameraFragment newInstance() {
        CameraFragment fragment = new CameraFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ImageView cameraButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_camera, container, false);

        cameraButton = (ImageView) rootView.findViewById(R.id.button_capture);
        cameraButton.setVisibility(View.GONE);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.SEND_SMS,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.READ_CONTACTS},
                        PERMISSIONS_REQUEST);
            }

        } else {
            // Create an instance of Camera
            mCamera = getCameraInstance();
            cameraButton.setVisibility(View.VISIBLE);

            // Create our Preview view and set it as the content of our activity.
            mPreview = new CameraPreview(getActivity(), mCamera);
            FrameLayout preview = (FrameLayout) rootView.findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }
        // Inflate the layout for this fragment
        return rootView;
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            int er = 0;
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(getActivity(), "Camera Request needed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
