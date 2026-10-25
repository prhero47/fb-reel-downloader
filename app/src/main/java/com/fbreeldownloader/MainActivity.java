
package com.fbreeldownloader;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.setPadding(24, 40, 24, 24);
        layout.setBackgroundColor(Color.rgb(15, 23, 42));

        TextView title = new TextView(this);
        title.setText("FB Reel Downloader");
        title.setTextSize(27);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 20, 0, 16);
        layout.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Paste your Facebook Reel link below");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, 24);
        layout.addView(subtitle);

        EditText urlInput = new EditText(this);
        urlInput.setHint("https://www.facebook.com/reel/...");
        urlInput.setTextColor(Color.BLACK);
        urlInput.setHintTextColor(Color.GRAY);
        urlInput.setSingleLine(true);
        urlInput.setPadding(14, 12, 14, 12);
        urlInput.setBackgroundColor(Color.WHITE);
        layout.addView(urlInput);

        Button downloadButton = new Button(this);
        downloadButton.setText("Continue");
        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.setMargins(0, 20, 0, 12);
        layout.addView(downloadButton, buttonParams);

        TextView status = new TextView(this);
        status.setText("Ready");
        status.setTextSize(15);
        status.setTextColor(Color.WHITE);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 16, 0, 16);
        layout.addView(status);

        downloadButton.setOnClickListener(v -> {
            String url = urlInput.getText().toString().trim();

            if (url.isEmpty()) {
                status.setText("Please paste a Reel link first.");
                return;
            }

            String lowerUrl = url.toLowerCase();

            boolean valid =
                    lowerUrl.startsWith("https://facebook.com/") ||
                    lowerUrl.startsWith("https://www.facebook.com/") ||
                    lowerUrl.startsWith("https://m.facebook.com/") ||
                    lowerUrl.startsWith("https://fb.watch/");

            if (valid) {
                status.setText(
                    "Link accepted. Use an authorized download source " +
                    "for videos you own or have permission to save."
                );
            } else {
                status.setText("Please enter a valid HTTPS Facebook link.");
            }
        });

        setContentView(layout);
    }
}
