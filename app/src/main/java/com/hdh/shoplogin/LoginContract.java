package com.hdh.shoplogin;

import android.widget.CheckBox;
import android.widget.EditText;

public interface LoginContract {
    interface View{
        void showToast(String message);
        void showLoginTry();
        void showLoginSuccess();
        void showLoginText();
        void showLoading();

        void alphaValueIncrease();
        void alphaValueReduction();

        void hideLoading();
        void hideLoginText();
    }
    interface Presenter{
        void clickTermLayout(CheckBox checkBox);
        void clickLogin(EditText userID , EditText userPassword , boolean termCheck);
    }
}
