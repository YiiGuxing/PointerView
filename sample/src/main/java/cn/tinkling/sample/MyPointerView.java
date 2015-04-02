package cn.tinkling.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import cn.tinkling.pointerview.PointerView;

public class MyPointerView extends PointerView {

    public MyPointerView(Context context) {
        super(context);
    }

    public MyPointerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPointerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDrawOffset(Canvas canvas, Drawable pointer, float spacing,
                                float positionOffset) {
        Rect bounds = pointer.getBounds();
        int right = bounds.right;
        int dw = pointer.getIntrinsicWidth();

        pointer.setBounds(0, 0, dw + (int) (spacing * Math.sin(positionOffset * Math.PI) / 2d),
                bounds.bottom);
        canvas.translate((dw + spacing) * positionOffset, 0);
        pointer.draw(canvas);
        pointer.setBounds(0, 0, right, bounds.bottom);
    }
}
