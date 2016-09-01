package net.grantforrest.swipedrawerwidget;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.widget.RemoteViewsService;

/**
 * Created by gforrest on 9/1/16.
 */
public class DrawerWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Context appContext = getApplicationContext();
        return new DrawerRemoteViewsFactory(appContext, intent);
    }
}
