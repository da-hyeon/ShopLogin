package com.hdh.shoplogin;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hdh.shoplogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private ActivityLoginBinding mBinding;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mBinding.setLoginActivity(this);

        mPresenter = new LoginPresenter(this, this);


        //약관동의 레이아웃 클릭
        mBinding.llTerm.setOnClickListener(v ->
                mPresenter.clickTermLayout(mBinding.cbTerm)
        );

        //로그인 클릭
        mBinding.llLogin.setOnClickListener(v ->
                mPresenter.clickLogin(mBinding.etId, mBinding.etPassword, mBinding.cbTerm.isChecked())
        );
    }

    /**
     * Toast 메세지 보여주기
     *
     * @param message 보여줄 메세지
     */
    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 로그인 버튼의 글씨 보이기
     */
    @Override
    public void showLoginText() {
        mBinding.tvLogin.setVisibility(View.VISIBLE);
    }

    /**
     * 로딩 보이기
     */
    @Override
    public void showLoading() {
        mBinding.pbLoading.setVisibility(View.VISIBLE);
    }

    /**
     * subMessage 보이기
     */
    @Override
    public void showSubMessage() {
        mBinding.tvSubMessage.setVisibility(View.VISIBLE);
    }

    /**
     * 자동로그인 연결 약관 보이기
     */
    @Override
    public void showAutoLoginTerm() {
        mBinding.llTerm.setVisibility(View.GONE);
        mBinding.btAutoLoginTerm.setVisibility(View.VISIBLE);
    }

    /**
     * 로그인 버튼의 글씨 숨기기
     */
    @Override
    public void hideLoginText() {
        mBinding.tvLogin.setVisibility(View.GONE);
    }

    /**
     * 로딩 숨기기
     */
    @Override
    public void hideLoading() {
        mBinding.pbLoading.setVisibility(View.GONE);
    }


    /**
     * subMessage 숨기기
     */
    @Override
    public void hideSubMessage() {
        mBinding.tvSubMessage.setVisibility(View.GONE);
    }

    /**
     * 자동로그인약관 숨기기
     */
    @Override
    public void hideAutoLoginTerm() {
        mBinding.llTerm.setVisibility(View.VISIBLE);
        mBinding.btAutoLoginTerm.setVisibility(View.GONE);
    }

    /**
     * MainText 변경
     *
     * @param message 보여줄 메세지
     */
    @Override
    public void changeMainMessage(String message) {
        mBinding.tvMainMessage.setText(message);
    }

    /**
     * 알파값 증가
     */
    @Override
    public void alphaValueIncrease() {
        mBinding.etId.setAlpha(1);
        mBinding.etPassword.setAlpha(1);
        mBinding.llTerm.setAlpha(1);
        mBinding.llFindAccount.setAlpha(1);
    }

    /**
     * 알파값 감소
     */
    @Override
    public void alphaValueReduction() {
        mBinding.etId.setAlpha(0.5f);
        mBinding.etPassword.setAlpha(0.5f);
        mBinding.llTerm.setAlpha(0.5f);
        mBinding.llFindAccount.setAlpha(0.5f);
    }

    /**
     * 입력 가능
     */
    @Override
    public void inputAvailable() {
        mBinding.etId.setEnabled(true);
        mBinding.etPassword.setEnabled(true);
        mBinding.llTerm.setClickable(true);
        mBinding.cbTerm.setClickable(true);
        mBinding.llLogin.setClickable(true);
    }

    /**
     * 입력 불가능
     */
    @Override
    public void inputImpossible() {
        mBinding.etId.setEnabled(false);
        mBinding.etPassword.setEnabled(false);
        mBinding.llTerm.setClickable(false);
        mBinding.cbTerm.setClickable(false);
        mBinding.llLogin.setClickable(false);
    }

}
