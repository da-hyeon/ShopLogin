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
    LoginPresenter(LoginContract.View mView, Context mContext) {
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

        //약관동의가 되어있고
        if (termCheck) {

            //아이디 , 비밀번호의 데이터는 없으므로 아무 텍스트나 입력하면 로그인 가능
            //입력란이 비어있지 않으면
            if (!isEmpty(userID) && !isEmpty(userPassword)) {
                mView.showLoading();

                mView.hideSubMessage();
                mView.hideLoginText();

                mView.changeMainMessage("로그인 중입니다..");

                mView.alphaValueReduction();

                mView.inputImpossible();

                //요구사항에서 자세하게 기입이 되어있지 않아서 임의로
                //로그인 성공 표시를 보여준 후 1초 후 약관체크버튼이 사라지게 구현함.
                new Handler().postDelayed(() -> {

                    mView.changeMainMessage("로그인 성공!");

                    new Handler().postDelayed(() -> {
                        mView.showLoginText();
                        mView.showSubMessage();
                        mView.showAutoLoginTerm();

                        mView.hideLoading();

                        mView.changeMainMessage(mContext.getResources().getString(R.string.login_info_mainMessage));

                        mView.alphaValueIncrease();

                        mView.inputAvailable();
                    }, 1000);
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
