package net.grantforrest.swipedrawerwidget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gforrest on 9/1/16.
 */
public class DrawerWidgetItem {

    private String mLetter = null;
    private Context mContext;
    private List<ApplicationInfo> mApps;

    public DrawerWidgetItem(String letter, Context context) {
        mLetter = letter;
        mContext = context;
        mApps = getFilteredPackages();
    }

    public String getLetter() {
        return mLetter;
    }

    public List<ApplicationInfo> getApps() {
        return mApps;
    }

    private List<ApplicationInfo> getFilteredPackages() {
        List<ApplicationInfo> packages = mContext.getPackageManager()
                .getInstalledApplications(PackageManager.GET_META_DATA);

        List<ApplicationInfo> filtered = new ArrayList<>();
        for (ApplicationInfo pack : packages) {
            if (pack.name.startsWith(mLetter)) {
                filtered.add(pack);
            }
        }

        return filtered;
    }
}
