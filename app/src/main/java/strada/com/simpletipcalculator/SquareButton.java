package strada.com.simpletipcalculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GrayOwl on 5/26/17.
 */

class SquareButton extends View {
    public SquareButton(Context context){
        super(context);
    }

    public SquareButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); // Snap to width
    }
}
