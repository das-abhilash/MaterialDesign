package in.zollet.abhilash.materialdesign;

import android.content.Context;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
              return   AccountFragment.newInstance();
            case 1:
                return  CameraFragment.newInstance();
            case 2:
                return  SettingsFragment.newInstance();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="My Account";
                break;
            case 1:
                title="Camera";
                break;
            case 2:
                title="Settings";
                break;
        }

        return title;
    }

}
