package as.bwei.com.zidingyi.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class WenHao extends View{

    private Paint mpaint;
    private int wsize = 50;
    private int hsize = 50;
    private Integer [] a={100,200,50,580,300,200,70};
    private String [] c={"100","200","400","600","800"};
    private String [] b={"一","二","三","四","五","六","日"};
    private int top ;
    private String texttop;
    private String sumtop;
    private int left = 70;
    private int textleft = 70;
    private int sumleft = 395;
    private int right = 120;
    private Paint paint1;

    public WenHao(Context context) {
        this(context,null);
    }

    public WenHao(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WenHao(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //画笔
        mpaint = new Paint();
        paint1 = new Paint();
        paint1.setColor(Color.GREEN);
        mpaint.setColor(Color.BLUE);//颜色
        mpaint.setStrokeWidth(5);//宽度
        mpaint.setTextSize(30);//字体大小
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,400,700,400,mpaint);//横轴
        canvas.drawLine(50,50,50,400,mpaint);//竖轴
        //循环竖轴
        for (int i=0;i<7;i++){
            wsize += 90;
            canvas.drawLine(wsize,50,wsize,400,mpaint);
        }
        //循环横轴
        for (int i=0;i<7;i++){
            hsize += 50;
            canvas.drawLine(50,hsize,679,hsize,mpaint);
        }
        //循环画矩形
        for (int j = 0 ; j < a.length ; j++){
            top = a[j] / 2;
            canvas.drawRect(left,400-top,right,400,paint1);
            left+=90;
            right+=90;
        }
        //循环日期
        for (int j = 0 ; j < b.length ; j++){
            texttop = b[j];
            canvas.drawText(texttop,textleft,450,mpaint);
            textleft+=90;
        }
        //循环Y轴数量
        for (int k = 0;k<c.length;k++){
            sumtop = c[k];
            canvas.drawText(sumtop,0,sumleft,mpaint);
            sumleft-=50;
        }
    }
}
