package com.example.fangdou2.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import com.example.fangdou2.R;

public class CornerListView extends ListView
{
    public CornerListView(Context context)
    {
        super(context);
    }

    public CornerListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public CornerListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {

        System.out.println(ev.getAction());
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                int x = (int) ev.getX();
                int y = (int) ev.getY();
                int itemnum = pointToPosition(x, y);

                if (itemnum == 0)
                {
                    if (itemnum == (getAdapter().getCount() - 1))
                    {
                        // 只有一项
                        setSelector(R.drawable.item_corner_one);
                    } else
                    {
                        // 第一项
                        setSelector(R.drawable.item_topbackground);
                    }
                } else if (itemnum == (getAdapter().getCount() - 1))
                    // 最后一项
                    setSelector(R.drawable.item_lastbackground);
                else
                {
                    // 中间一项
                    setSelector(R.drawable.item_midbackground);
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
