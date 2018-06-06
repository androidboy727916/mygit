package com.desirephoto.game.pixel.activity;

/**
 * Created by admin on 2018/2/2.
 */

public class LoginActivity extends BaseAppCompatActivity implements ClientStandard.OnLoginResultListener, RtResultCallbackListener {   
sjadfdfadsffdfd
    @OnClick({R.id.login_facebook, R.id.login_google})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.login_facebook:
                platformFlag = FACEBOOK;
                loginClient = ClientManager.getInstance(this).getFacebookLoginClient();
                loginClient.setOnLoginResultListener(this);
                loginClient.showLoginWindow();
                break;
            case R.id.login_google:
                platformFlag = GOOGLE;
                int statusCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
                if (statusCode != 0) {
                    Toast.makeText(this, "No GooglePlayServices Found!", Toast.LENGTH_LONG).show();
                } else {
                    loginClient = ClientManager.getInstance(this).getGooglePlusLoginClient();
                    loginClient.setOnLoginResultListener(this);
                    loginClient.showLoginWindow();
                }
                break;
        }
    }

   
}
