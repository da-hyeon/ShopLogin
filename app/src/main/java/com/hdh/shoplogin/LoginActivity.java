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
        mBinding.llTerm.setOnClickListener(v -> {
            if (mBinding.tvLogin.getVisibility() == View.VISIBLE) {
                mPresenter.clickTermLayout(mBinding.cbTerm);
            }
        });

        //로그인 클릭
        mBinding.llLogin.setOnClickListener(v -> {
            if (mBinding.tvLogin.getVisibility() == View.VISIBLE) {
                mPresenter.clickLogin(mBinding.etId, mBinding.etPassword, mBinding.cbTerm.isChecked());
            }
        });
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

    @Override
    public void showLoginTry() {
        mBinding.tvMainMessage.setText("로그인 중입니다..");
        mBinding.tvSubMessage.setVisibility(View.GONE);
    }

    @Override
    public void showLoginSuccess() {
        mBinding.tvMainMessage.setText("로그인 성공!");
    }

    @Override
    public void showLoginText() {
        mBinding.tvLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        mBinding.pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void alphaValueIncrease() {
        mBinding.etId.setAlpha(1);
        mBinding.etPassword.setAlpha(1);
        mBinding.llTerm.setAlpha(1);
        mBinding.llFindAccount.setAlpha(1);
    }

    @Override
    public void alphaValueReduction() {
        mBinding.etId.setAlpha(0.5f);
        mBinding.etPassword.setAlpha(0.5f);
        mBinding.llTerm.setAlpha(0.5f);
        mBinding.llFindAccount.setAlpha(0.5f);
    }

    @Override
    public void hideLoading() {
        mBinding.pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void hideLoginText() {
        mBinding.tvLogin.setVisibility(View.GONE);
    }
}
