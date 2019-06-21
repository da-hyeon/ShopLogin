package com.hdh.shoplogin;

import android.widget.CheckBox;
import android.widget.EditText;

public interface LoginContract {

    interface View{
        //show
        void showToast(String message);
        void showLoginText();
        void showLoading();
        void showSubMessage();
        void showAutoLoginTerm();

        //hide
        void hideLoginText();
        void hideLoading();
        void hideSubMessage();
        @Deprecated
        void hideAutoLoginTerm();

        //change
        void changeMainMessage(String message);

        void alphaValueIncrease();
        void alphaValueReduction();

        void inputAvailable();
        void inputImpossible();

    }

    interface Presenter{
        //click
        void clickTermLayout(CheckBox checkBox);
        void clickLogin(EditText userID , EditText userPassword , boolean termCheck);
    }
}
