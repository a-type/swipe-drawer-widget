package net.grantforrest.swipedrawerwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gforrest on 9/1/16.
 */
public class DrawerRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private static final String[] LETTERS = new String[] { "#", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    private Context mContext;
    private List<DrawerWidgetItem> mWidgetItems = new ArrayList<>();
    private int mAppWidgetId;

    public DrawerRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {
        for (int i = 0; i < LETTERS.length; i++) {
            mWidgetItems.add(new DrawerWidgetItem(LETTERS[i], mContext));
        }
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.drawer_item);
        rv.setTextViewText(R.id.drawerTitle, mWidgetItems.get(position).getLetter());

        return rv;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
