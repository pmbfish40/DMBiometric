package biometric.dm.com.dmbiometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.support.annotation.RequiresApi;


@RequiresApi(api = Build.VERSION_CODES.P)
final class DMBIOIListenerConverterV23ToV28 extends BiometricPrompt.AuthenticationCallback {

    private final DMBIOBase biometric;

    DMBIOIListenerConverterV23ToV28(final DMBIOBase biometric) {
        this.biometric = biometric;
    }

    @Override
    public void onAuthenticationSucceeded(final BiometricPrompt.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        biometric.onAuthenticationSuccessful(result.getCryptoObject().getCipher());
    }

    @Override
    public void onAuthenticationHelp(final int helpCode, final CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        biometric.onAuthenticationHelp(helpCode, helpString);
    }

    @Override
    public void onAuthenticationError(final int errorCode, final CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        biometric.onAuthenticationError(errorCode, errString);
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        biometric.onAuthenticationFailed();
    }
}
