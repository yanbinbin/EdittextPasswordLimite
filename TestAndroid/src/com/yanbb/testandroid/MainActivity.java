package com.yanbb.testandroid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yanbb.testandroid.R;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "TestAndroid";
    private EditText mPswEditText;
    private Button mFinishButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPswEditText = (EditText) findViewById(R.id.psd);
        mPswEditText.addTextChangedListener(new PasswordTextWatcher(mPswEditText) {
            /* (non-Javadoc)
             * @see com. .yanbb.testandroid. PasswordTextWatcher#afterTextChanged(android.text.Editable)
             */
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                super.afterTextChanged(s);
            }
            /* (non-Javadoc)
             * @see com. .yanbb.testandroid. PasswordTextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
             */
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                // TODO Auto-generated method stub
                super.beforeTextChanged(s, start, count, after);
            }
            /* (non-Javadoc)
             * @see com. .yanbb.testandroid. PasswordTextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                    int count) {
                // TODO Auto-generated method stub
                super.onTextChanged(s, start, before, count);
            }
        });
        mFinishButton = (Button) findViewById(R.id.finish);
        mFinishButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mPswEditText.setText("");
            }
        });
//        mPswEditText.addTextChangedListener(new TextWatcher() {
//            private boolean isMatch;
//            private CharSequence result;
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // TODO Auto-generated method stub
//                Log.v(LOG_TAG,"onTextChanged---> s = " + s + "; start = " + start + "; before = " + before + "; count = " + count);
//                CharSequence charSequence = s.subSequence(start, start + count);
//                Log.v(LOG_TAG,"charSequence = " + charSequence);
//                Log.v(LOG_TAG,"isMatch = " + isMatch);
//                if (!isMatch) {
//                    isMatch = pswFilter(charSequence);
//                    result = s.subSequence(0, s.length() - count);
//                    Log.v(LOG_TAG,"result = " + result);
//                }
//            }
//            
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                    int after) {
//                // TODO Auto-generated method stub
//                Log.v(LOG_TAG,"beforeTextChanged---> s = " + s + "; start = " + start + "; after = " + after + "; count = " + count );
//            }
//            
//            @Override
//            public void afterTextChanged(Editable s) {
//                // TODO Auto-generated method stub
//                Log.v(LOG_TAG,"afterTextChanged ---> s = " + s);
//                if (!isMatch) {
//                    isMatch = true;
//                    mPswEditText.setText(result);
//                    mPswEditText.setSelection(mPswEditText.length());
//                    Log.v(LOG_TAG,"--- after setText --- result = " + result);
//                }
//                isMatch = false;
//                Log.v(LOG_TAG,"------------------------------------------");
//            }
//        });
    }

    private boolean pswFilter(CharSequence s) {
        if (TextUtils.isEmpty(s)) {
            return true;
        }
        String regex = "[A-Z0-9a-z!@#$%^&*.~/\\{\\}|()'\"?><,.`\\+-=_\\[\\]:;]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

}
