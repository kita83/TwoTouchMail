package com.app.strkita.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 *
 * Created by strkita on 2017/06/12.
 */

public class PickUpActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);

        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgPlace = (RadioGroup) findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton) findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText) findViewById(R.id.editText);
                String title = edit01.getText().toString();
                Resources res = getResources();
                Uri uri = Uri.parse("mailto:" + res.getString(R.string.mail_to));

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, strPlace + "に迎えに来て");
                startActivity(intent);
            }
        });

    }
}
