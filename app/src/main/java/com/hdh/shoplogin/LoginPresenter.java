package com.hdh.shoplogin;

import android.content.Context;
import android.os.Handler;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Context mContext;

    /**
     * 생성자
     */
    public LoginPresenter(LoginContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }


    /**
     * 약관동의 레이아웃 클릭 이벤트 처리
     */
    @Override
    public void clickTermLayout(CheckBox checkBox) {
        checkBox.setChecked(!checkBox.isChecked());
    }

    /**
     * 로그인 버튼 클릭 이벤트 처리
     */
    @Override
    public void clickLogin(EditText userID, EditText userPassword, boolean termCheck) {

        if (termCheck) {
            if (!isEmpty(userID) && !isEmpty(userPassword)) {

                mView.showLoginTry();
                mView.alphaValueReduction();
                mView.showLoading();
                mView.hideLoginText();
                userID.setFocusableInTouchMode(false);
                userID.setClickable(false);
                userID.setFocusable(false);
                userPassword.setFocusableInTouchMode(false);
                userPassword.setClickable(false);
                userPassword.setFocusable(false);

                new Handler().postDelayed(() -> {
                    mView.showLoginSuccess();
                    mView.alphaValueIncrease();
                    mView.hideLoading();
                    mView.showLoginText();
                    userID.setFocusableInTouchMode(true);
                    userID.setClickable(true);
                    userID.setFocusable(true);
                    userPassword.setFocusableInTouchMode(true);
                    userPassword.setClickable(true);
                    userPassword.setFocusable(true);
                }, 5000);


            } else {
                mView.showToast("빈칸을 채워주세요.");
            }
        } else {
            mView.showToast("약관에 동의해주세요.");
        }
    }

    /**
     * EditText 빈칸 체크
     *
     * @return true - 빈칸 , false - 빈칸아님
     */
    private Boolean isEmpty(EditText editText) {
        return editText.getText().toString().equals("");
    }
}
