package com.example.testforall;

        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.example.testforall.normal.ButtonActivity;
        import com.example.testforall.normal.EditTextActivity;
        import com.example.testforall.normal.TextViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnButton;
    private Button mBtnEditTextBotton;
    private Button mBtnRadioButton;
    private Button mBtnTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 隐藏导航栏
         */
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        mBtnRadioButton = (Button)findViewById(R.id.btn_radiobutton);
        mBtnTextView = (Button)findViewById(R.id.btn_textview);
        mBtnButton = (Button)findViewById(R.id.btn_button);
        mBtnEditTextBotton = (Button)findViewById(R.id.btn_edit_button);
        setListeners();

    }
    /**
     * 设置setListeners方法，以及Onclick类，避免重复控件点击事件的代码冗余
     */
    private void setListeners(){
        //创建Onclick的实例
        Onclick onclick = new Onclick();
        //让下面四个控件分别调用setOnClickListener方法
        mBtnEditTextBotton.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnRadioButton.setOnClickListener(onclick);
        mBtnTextView.setOnClickListener(onclick);
    }

    //创建一个Onclick类，这个类用来实现View.OnclickListener接口
    private class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=null;  //设置intent初值为null
            switch (view.getId()){
                case R.id.btn_button:
                    //跳转至ButtonActivity
                    Toast.makeText(MainActivity.this,"您点击了Button",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edit_button:
                    //跳转至EditTextActivity
                    Toast.makeText(MainActivity.this,"您点击了EditTextBitton",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_textview:
                    //跳转至TextViewActivity
                    Toast.makeText(MainActivity.this,"您点击了EditTextBitton",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //跳转至RadioButtonActivity
                    Toast.makeText(MainActivity.this,"您点击了RadioButton",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
            }
            startActivity(intent);//启动Activity
        }
    }
}

