package com.example.ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView example_img,main_image ,first_ImageView ,ante_example_img,antoma_example_img,antom_example_img,antona_example_img ;
    MediaPlayer anta_sound,ante_sound,antoma_sound,antom_sound,antona_sound,titel_sound,explain_sound,anta_used_sound ;
    private LinearLayout myLinearLayout,exampleLinearLayout,my_firstLinearLayout,ante_Layout,antoma_Layout,antom_Layout,antona_Layout,
            ante_exampels_layout,antoma_exampels_layout,antom_exampels_layout,antona_exampels_layout;
   private Button anta_Button,anta_Button2 ,ante_Button,ante_Button2, antoma_Button,antoma_Button2,antom_Button,antom_Button2,
           antona_Button ,antona_Button2, example_Button,ante_example_button,antoma_example_button,antom_example_button,antona_example_button;

//   private TextView example_view,uses_view;
    private TextView    titel_view ,
        example_view, ante_example_textView,antoma_example_textView, antom_example_textView,antona_example_textView,
        uses_view,ante_uses_textView,antoma_uses_textView,antom_uses_textView,antona_uses_textView;

    int counter_examples = 0;
    int ante_counter =0;
    int antoma_counter =0;
    int antom_counter =0;
    int antona_counter =0;

    MediaPlayer currentMediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //*********************************** (GUI Part)************************************************

        // ---------------- Layouts -------------------------
        my_firstLinearLayout = findViewById(R.id.first_layout);
        my_firstLinearLayout.setVisibility(View.GONE);

        myLinearLayout = findViewById(R.id.detailes_linearlayout);
        // Hide the LinearLayout
        myLinearLayout.setVisibility(View.GONE);

        exampleLinearLayout = findViewById(R.id.exampels_layout);
        // Hide the LinearLayout
        exampleLinearLayout.setVisibility(View.GONE);

        ante_Layout = findViewById(R.id.ante_layout);
        ante_Layout.setVisibility(View.GONE);

        antoma_Layout = findViewById(R.id.antoma_layout);
        antoma_Layout.setVisibility(View.GONE);

        antom_Layout = findViewById(R.id.antom_layout);
        antom_Layout.setVisibility(View.GONE);

        antona_Layout = findViewById(R.id.antona_layout);
        antona_Layout.setVisibility(View.GONE);

        ante_exampels_layout = findViewById(R.id.ante_exampels_layout);
        ante_exampels_layout.setVisibility(View.GONE);

        antoma_exampels_layout = findViewById(R.id.antoma_exampels_layout);
        antoma_exampels_layout.setVisibility(View.GONE);

        antom_exampels_layout = findViewById(R.id.antom_exampels_layout);
        antom_exampels_layout.setVisibility(View.GONE);

        antona_exampels_layout = findViewById(R.id.antona_exampels_layout);
        antona_exampels_layout.setVisibility(View.GONE);

        // --------------- ImageViews -----------------------
        example_img = findViewById(R.id.example_imageview);
        ante_example_img = findViewById(R.id.ante_example_imageview);
        antoma_example_img = findViewById(R.id.antoma_example_imageview);
        antom_example_img = findViewById(R.id.antom_example_imageview);
        antona_example_img = findViewById(R.id.antona_example_imageview);

        main_image = findViewById(R.id.main_imageView);
        first_ImageView = findViewById(R.id.imageView1);

        // Declare an integer array to store the image resource IDs
        int[] ante_imgs = new int[] {R.drawable.ante,R.drawable.onegirl_eat,R.drawable.ante_play,R.drawable.onegirl_happy};
        int[] antoma_imgs = new int[] {R.drawable.antoma,R.drawable.two_eat,R.drawable.two_happy,R.drawable.two_plays};
        int[] antom_imgs = new int[] {R.drawable.antom,R.drawable.group_eat,R.drawable.group_happy,R.drawable.group_plays};
        int[] antona_imgs = new int[] {R.drawable.antona,R.drawable.girls_eat,R.drawable.girls_happy,R.drawable.girls_plays};


        // --------------- MediaPlayer -----------------------------
        anta_sound= MediaPlayer.create(this, R.raw.anta_sound);
        ante_sound= MediaPlayer.create(this, R.raw.ante_sound);
        antoma_sound= MediaPlayer.create(this, R.raw.antoma_sound);
        antom_sound= MediaPlayer.create(this, R.raw.antom_sound);
        antona_sound= MediaPlayer.create(this, R.raw.antona_sound);
        titel_sound = MediaPlayer.create(this, R.raw.damaer_almukhateb);
        explain_sound = MediaPlayer.create(this, R.raw.to_explain);
        anta_used_sound = MediaPlayer.create(this, R.raw.anta_used);

        // للضمير انتَ
        MediaPlayer[] examples_of_anta_sounds = new MediaPlayer[3];
        examples_of_anta_sounds[0] = MediaPlayer.create(this, R.raw.anta_saed);
        examples_of_anta_sounds[1] = MediaPlayer.create(this, R.raw.anta_eat_sound);
        examples_of_anta_sounds[2] = MediaPlayer.create(this, R.raw.anta_talab);
        // أنتِ
        MediaPlayer[] examples_of_ante_sounds = new MediaPlayer[3];
        examples_of_ante_sounds[0] = MediaPlayer.create(this, R.raw.ante_happy_sound);
        examples_of_ante_sounds[1] = MediaPlayer.create(this, R.raw.ante_eat_sound);
        examples_of_ante_sounds[2] = MediaPlayer.create(this, R.raw.ante_play_sound);
        // أنتما
        MediaPlayer[] examples_of_antoma_sounds = new MediaPlayer[3];
        examples_of_antoma_sounds[0] = MediaPlayer.create(this, R.raw.antoma_happy_sound);
        examples_of_antoma_sounds[1] = MediaPlayer.create(this, R.raw.antoma_eat_sound);
        examples_of_antoma_sounds[2] = MediaPlayer.create(this, R.raw.antoma_play_sound);
        // أنتم
        MediaPlayer[] examples_of_antom_sounds = new MediaPlayer[3];
        examples_of_antom_sounds[0] = MediaPlayer.create(this, R.raw.antom_happy);
        examples_of_antom_sounds[1] = MediaPlayer.create(this, R.raw.antom_eat_sound);
        examples_of_antom_sounds[2] = MediaPlayer.create(this, R.raw.antom_play_sound);;
        // أنتن
        MediaPlayer[] examples_of_antona_sounds = new MediaPlayer[3];
        examples_of_antona_sounds[0] = MediaPlayer.create(this, R.raw.antona_happy_sound);
        examples_of_antona_sounds[1] = MediaPlayer.create(this, R.raw.antona_eat_sound);
        examples_of_antona_sounds[2] = MediaPlayer.create(this, R.raw.antona_play_sound);;


        // اراي تشمل الاصوات المخصصة للاستخدام لكل ضمير
        MediaPlayer[] uses_sounds = new MediaPlayer[5];
        uses_sounds[0] = MediaPlayer.create(this, R.raw.ante_use_sound);
        uses_sounds[1] = MediaPlayer.create(this, R.raw.antoma_use_sound);
        uses_sounds[2] = MediaPlayer.create(this, R.raw.antom_use_sound2);
        uses_sounds[3] = MediaPlayer.create(this, R.raw.antona_use_sound);

        // ---------------- Buttons -------------------
        anta_Button = findViewById(R.id.anta_button);
        anta_Button2 =  findViewById(R.id.anta_button2);

        ante_Button = findViewById(R.id.ante_button);
        ante_Button2 = findViewById(R.id.ante_button2);

        antoma_Button = findViewById(R.id.antoma_button);
        antoma_Button2 = findViewById(R.id.antoma_Button2);

        antom_Button =findViewById(R.id.antom_button);
        antom_Button2 =findViewById(R.id.antom_Button2);

        antona_Button = findViewById(R.id.antona_button);
        antona_Button2 = findViewById(R.id.antona_Button2);

        // example button
        example_Button = findViewById(R.id.example_button);
        ante_example_button = findViewById(R.id.ante_example_button);
        antoma_example_button = findViewById(R.id.antoma_example_button);
        antom_example_button = findViewById(R.id.antom_example_button);
        antona_example_button = findViewById(R.id.antona_example_button);



        //------------------- Text views ---------------------
        example_view = findViewById(R.id.example_textView);
        ante_example_textView =findViewById(R.id.ante_example_textView);
        antoma_example_textView =findViewById(R.id.antoma_example_textView);
        antom_example_textView =findViewById(R.id.antom_example_textView);
        antona_example_textView =findViewById(R.id.antona_example_textView);


        uses_view = findViewById(R.id.uses_textView);
        uses_view.setVisibility(View.GONE);

        ante_uses_textView = findViewById(R.id.ante_uses_textView);
        ante_uses_textView.setVisibility(View.GONE);

        antoma_uses_textView = findViewById(R.id.antoma_uses_textView);
        antoma_uses_textView.setVisibility(View.GONE);

        antom_uses_textView = findViewById(R.id.antom_uses_textView);
        antom_uses_textView.setVisibility(View.GONE);

        antona_uses_textView = findViewById(R.id.antona_uses_textView);
        antona_uses_textView.setVisibility(View.GONE);


        titel_view = findViewById(R.id.titel_Textview);


//*****************************************(Code working part )*************************************
        titel_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titel_sound.start();
                my_firstLinearLayout.setVisibility(View.VISIBLE);
            }
        });

        first_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                explain_sound.start();

            }
        });

        // ************************* anta work *****************************************************
        anta_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myLinearLayout.getVisibility() == View.GONE) {
                    // Show the LinearLayout of anta and Gone other layouts
                    myLinearLayout.setVisibility(View.VISIBLE);
                    // Gone layouts
                    ante_Layout.setVisibility(View.GONE);
                    antoma_Layout.setVisibility(View.GONE);
                    antom_Layout.setVisibility(View.GONE);
                    antona_Layout.setVisibility(View.GONE);

                    if (currentMediaPlayer != null && currentMediaPlayer.isPlaying()) {
                        currentMediaPlayer.stop();
                    }
                    anta_sound.start(); // start anta and stop others

                    // color the anta button red and others button blue
                    changeButtonColor(anta_Button, "#FF5722"); // red
                    changeButtonColor(ante_Button, "#03A9F4"); // blue
                    changeButtonColor(antoma_Button, "#03A9F4");
                    changeButtonColor(antona_Button, "#03A9F4");
                    changeButtonColor(antom_Button, "#03A9F4");

                } else {
                    // Hide the LinearLayout
                    myLinearLayout.setVisibility(View.GONE);
                }
            }
        });

        // When pressing the button, the use of this pronoun will appear with a sound
        anta_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anta_used_sound.start();
                if ( uses_view.getVisibility() == View.VISIBLE) {
                    gone_visible_textview(uses_view, 1); // set text gone
                }
                else {
                    gone_visible_textview(uses_view, 2); // set text visible
                }

            }
        });

        // when press on the example button the example linear layout shows and it has an example with image
        example_Button.setOnClickListener(new View.OnClickListener() {
            String [] examples_text = {"أنْتَ سَعِيـْدٌ","أنْتَ تأكُلُ","أنْتَ تَلْعَب"};
            int []examples_photos = {R.drawable.anta, R.drawable.oneboy_eat, R.drawable.play1boy};

            @Override
            public void onClick(View v) {

                    // Show the LinearLayout
                    exampleLinearLayout.setVisibility(View.VISIBLE);
                    //plays sound example and change it each time when pressed again
                    examples_of_anta_sounds[counter_examples].start();

                    example_Button.setText("مثال آخر");

                    example_view.setText(examples_text[counter_examples]);
                    example_img.setImageResource(examples_photos[ counter_examples]);

                    counter_examples++;
                    if ( counter_examples == 3){
                        counter_examples =0;
                    }
            }
        });

        // ++++++++++++++++++++++++++++++++++++ Ante work ++++++++++++++++++++++++++++++++++++++++++
        ante_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ante_Layout.getVisibility() == View.GONE) {

                    // Show the LinearLayout of ante and Gone other layouts
                    ante_Layout.setVisibility(View.VISIBLE);
                    // Gone
                    myLinearLayout.setVisibility(View.GONE);
                    antoma_Layout.setVisibility(View.GONE);
                    antom_Layout.setVisibility(View.GONE);
                    antona_Layout.setVisibility(View.GONE);

                    // play the sound ante
                    ante_sound.start();

                    // color the ante button red and others button blue
                    changeButtonColor(ante_Button, "#FF5722"); // red
                    changeButtonColor(anta_Button, "#03A9F4"); // blue
                    changeButtonColor(antoma_Button, "#03A9F4");
                    changeButtonColor(antona_Button, "#03A9F4");
                    changeButtonColor(antom_Button, "#03A9F4");
                }
                else {
                    ante_Layout.setVisibility(View.GONE);
                }
            }

        });

        // When pressing the button, the use of this pronoun will appear with a sound
        ante_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uses_sounds[0].start();
                ante_uses_textView.setVisibility(View.VISIBLE);

            }
        });

        // when press on the example button the example linear layout shows and it has an example with image
        ante_example_button.setOnClickListener(new View.OnClickListener() {

            String [] examples_text = {"أنْتِ سَعِيدَةٌ", "أنْتِ تَأكُليْن", "أنْتِ تَلْعَبِين"};
//                    "أنتما سَعيدانِ","أنتما تَأكُلان","أنتما تَلعَبَان"
//                    "أنتم سُعداءُ" , "أنتم تَأكُلُوْن" ,"أنتم تَلعَبُون"
//                    "أنتُنَّ سَعِيداتٌ" , "أنتُنَّ تأكُلْنَ" , "أنتُنَّ تَلعَبْنَ"

            int []ante_examples_photos = {ante_imgs[3], ante_imgs[1],ante_imgs[2]};

            @Override
            public void onClick(View v) {

                // Show the LinearLayout
                ante_exampels_layout.setVisibility(View.VISIBLE);
                //plays sound example and change it each time when pressed again
                examples_of_ante_sounds[ante_counter].start(); //????????????????????????????????????????

                ante_example_button.setText("مثال آخر"); // ch

                ante_example_textView.setText(examples_text[ante_counter]);
                ante_example_img.setImageResource(ante_examples_photos[ ante_counter]);

                ante_counter ++;
                if ( ante_counter == 3){
                    ante_counter =0;
                }
            }
        });

        // ++++++++++++++++++++++++++++ antoma work ++++++++++++++++++++++++++++++++++++++++++++++++
        antoma_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(antoma_Layout.getVisibility() == View.GONE) {

                    // Show the LinearLayout of ante and Gone other layouts
                    antoma_Layout.setVisibility(View.VISIBLE); // antoma
                    // Gone
                    myLinearLayout.setVisibility(View.GONE); //anta
                    ante_Layout.setVisibility(View.GONE); // ante
                    antom_Layout.setVisibility(View.GONE); // antom
                    antona_Layout.setVisibility(View.GONE); // antona

                    // play the sound ante
                    antoma_sound.start();

                    // color the ante button red and others button blue
                    changeButtonColor(antoma_Button, "#FF5722"); // red
                    changeButtonColor(anta_Button, "#03A9F4"); // blue
                    changeButtonColor(ante_Button, "#03A9F4");
                    changeButtonColor(antona_Button, "#03A9F4");
                    changeButtonColor(antom_Button, "#03A9F4");
                }
                else {
                    antoma_Layout.setVisibility(View.GONE);
                }
            }

        });

        antoma_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uses_sounds[1].start();
                antoma_uses_textView.setVisibility(View.VISIBLE);
            }
        });

        antoma_example_button.setOnClickListener(new View.OnClickListener() {

            String [] examples_text = {"أنتما سَعيدانِ","أنتما تَأكُلان","أنتما تَلعَبَان"};
//                    "أنتم سُعداءُ" , "أنتم تَأكُلُوْن" ,"أنتم تَلعَبُون"
//                    "أنتُنَّ سَعِيداتٌ" , "أنتُنَّ تأكُلْنَ" , "أنتُنَّ تَلعَبْنَ"

            int []antoma_examples_photos = {antoma_imgs[2], antoma_imgs[1],antoma_imgs[3]};

            @Override
            public void onClick(View v) {

                // Show the LinearLayout
                antoma_exampels_layout.setVisibility(View.VISIBLE);
                //plays sound example and change it each time when pressed again
                examples_of_antoma_sounds[antoma_counter].start();

                antoma_example_button.setText("مثال آخر"); // ch

                antoma_example_textView.setText(examples_text[antoma_counter]);
                antoma_example_img.setImageResource(antoma_examples_photos[ antoma_counter]);

                antoma_counter ++;
                if ( antoma_counter == 3){
                    antoma_counter =0;
                }
            }
        });

        //*********************************** antom work *******************************************

        antom_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(antom_Layout.getVisibility() == View.GONE) {

                    // Show the LinearLayout of ante and Gone other layouts
                    antom_Layout.setVisibility(View.VISIBLE); // antoma
                    // Gone
                    myLinearLayout.setVisibility(View.GONE); //anta
                    ante_Layout.setVisibility(View.GONE); // ante
                    antoma_Layout.setVisibility(View.GONE); // antom
                    antona_Layout.setVisibility(View.GONE); // antona

                    // play the sound ante
                    antom_sound.start();

                    // color the ante button red and others button blue
                    changeButtonColor(antom_Button, "#FF5722"); // red
                    changeButtonColor(anta_Button, "#03A9F4"); // blue
                    changeButtonColor(ante_Button, "#03A9F4");
                    changeButtonColor(antona_Button, "#03A9F4");
                    changeButtonColor(antoma_Button, "#03A9F4");
                }
                else {
                    antom_Layout.setVisibility(View.GONE);
                }
            }

        });

        antom_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uses_sounds[2].start();
                antom_uses_textView.setVisibility(View.VISIBLE);
            }
        });

        antom_example_button.setOnClickListener(new View.OnClickListener() {
            String [] examples_text = {"أنتم سُعداءُ" , "أنتم تَأكُلُوْن" ,"أنتم تَلعَبُون"};
//
//                    "أنتُنَّ سَعِيداتٌ" , "أنتُنَّ تأكُلْنَ" , "أنتُنَّ تَلعَبْنَ"

            int []antom_examples_photos = {antom_imgs[2], antom_imgs[1],antom_imgs[3]};

            @Override
            public void onClick(View v) {

                // Show the LinearLayout
                antom_exampels_layout.setVisibility(View.VISIBLE);
                //plays sound example and change it each time when pressed again
                examples_of_antom_sounds[antom_counter].start();

                antom_example_button.setText("مثال آخر"); // ch

                antom_example_textView.setText(examples_text[antom_counter]);
                antom_example_img.setImageResource(antom_examples_photos[antom_counter]);


                antom_counter ++;
                if ( antom_counter == 3){
                    antom_counter =0;
                }
            }
        });

        // ********************************* antona work *******************************************

        antona_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(antona_Layout.getVisibility() == View.GONE) {

                    // Show the LinearLayout of ante and Gone other layouts
                    antona_Layout.setVisibility(View.VISIBLE); // antoma
                    // Gone
                    myLinearLayout.setVisibility(View.GONE); //anta
                    ante_Layout.setVisibility(View.GONE); // ante
                    antoma_Layout.setVisibility(View.GONE); // antom
                    antom_Layout.setVisibility(View.GONE); // antona

                    // play the sound ante
                    antona_sound.start();

                    // color the ante button red and others button blue
                    changeButtonColor(antona_Button, "#FF5722"); // red
                    changeButtonColor(anta_Button, "#03A9F4"); // blue
                    changeButtonColor(ante_Button, "#03A9F4");
                    changeButtonColor(antom_Button, "#03A9F4");
                    changeButtonColor(antoma_Button, "#03A9F4");
                }
                else {
                    antona_Layout.setVisibility(View.GONE);
                }
            }

        });

        antona_Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uses_sounds[3].start();
                antona_uses_textView.setVisibility(View.VISIBLE);
            }
        });

        antona_example_button.setOnClickListener(new View.OnClickListener() {

            String [] examples_text = {"أنتُنَّ سَعِيداتٌ" , "أنتُنَّ تأكُلْنَ" , "أنتُنَّ تَلعَبْنَ"};

            int []antona_examples_photos = {antona_imgs[2], antona_imgs[1],antona_imgs[3]};

            @Override
            public void onClick(View v) {

                // Show the LinearLayout
                antona_exampels_layout.setVisibility(View.VISIBLE);
                //plays sound example and change it each time when pressed again
                examples_of_antona_sounds[antona_counter].start();

                antona_example_button.setText("مثال آخر"); // ch

                antona_example_textView.setText(examples_text[antona_counter]);
                antona_example_img.setImageResource(antona_examples_photos[ antona_counter]);

                antona_counter ++;
                if ( antona_counter == 3){
                    antona_counter =0;
                }
            }
        });

        }

        // ************************ Functions *******************************
        public void changeButtonColor(Button button, String color) {
            button.setBackgroundColor(Color.parseColor(color));
        }

        // IF I send 1 with it so set the text view gone else visible
        public void gone_visible_textview (TextView text , int num ){
            if (num == 1)
                text.setVisibility(View.GONE);
            else
                text.setVisibility(View.VISIBLE);
        }

        public void blink_color_button (Button btn){
            int color1 = Color.RED;
            int color2 = Color.BLUE;
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator anim1 = ObjectAnimator.ofInt(btn, "backgroundColor", color1, color2);
            anim1.setDuration(1000);
            anim1.setEvaluator(new ArgbEvaluator());

            ObjectAnimator anim2 = ObjectAnimator.ofInt(btn, "backgroundColor", color2, color1);
            anim2.setDuration(1000);
            anim2.setEvaluator(new ArgbEvaluator());
            set.playSequentially(anim1, anim2);
            set.start();

        }

    }
