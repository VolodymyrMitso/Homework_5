package mitso.m.homework_5;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEditText_To;
    EditText mEditText_Subject;
    EditText mEditText_MessageText;
    Button mButton_Send;
    Button mButton_Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mEditText_To = (EditText) findViewById(R.id.et_To_AM);
        mEditText_Subject = (EditText) findViewById(R.id.et_Subject_AM);
        mEditText_MessageText = (EditText) findViewById(R.id.et_MessageText_AM);

        TextDrawable.drawStringInEditText(mEditText_To, Constants.TO, 110);
        TextDrawable.drawStringInEditText(mEditText_Subject, Constants.SUBJECT, 235);

        mButton_Send = (Button) findViewById(R.id.btn_Send_AM);
        mButton_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String To = mEditText_To.getText().toString();
                String subject = mEditText_Subject.getText().toString();
                String messageText = mEditText_MessageText.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{To});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, messageText);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client:"));
            }
        });

        mButton_Call = (Button) findViewById(R.id.btn_Call_AM);
        mButton_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT == 23) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)) {
                            showDialog(1);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, Constants.PERMISSION_REQUEST_CALL_PHONE);
                        }
                    } else {
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse(Constants.TEL));
                        startActivity(call);
                    }
                } else {
                    Intent call = new Intent(Intent.ACTION_CALL);
                    call.setData(Uri.parse(Constants.TEL));
                    startActivity(call);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constants.PERMISSION_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    try {
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse(Constants.TEL));
                        startActivity(call);
                    } catch (SecurityException e) {
                    }
                } else {
                    Toast.makeText(MainActivity.this, "DENIED", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    protected Dialog onCreateDialog(int id) {
        if (id == Constants.DIALOG) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setMessage(Constants.DIALOG_MESSAGE);
            adb.setPositiveButton(Constants.DIALOG_POSITIVE, myClickListener);
            adb.setNegativeButton(Constants.DIALOG_NEGATIVE, myClickListener);
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    private DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, Constants.PERMISSION_REQUEST_CALL_PHONE);
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    Toast.makeText(MainActivity.this, "DENIED", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}