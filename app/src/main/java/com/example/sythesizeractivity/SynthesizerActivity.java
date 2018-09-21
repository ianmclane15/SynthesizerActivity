package com.example.sythesizeractivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonEb;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonAb;
    private Button buttonAhigh;
    private Button buttonBbhigh;
    private Button buttonBhigh;
    private Button buttonChigh;
    private Button buttonCshigh;
    private Button buttonDhigh;
    private Button buttonEbhigh;
    private Button buttonEhigh;
    private Button buttonFhigh;
    private Button buttonFshigh;
    private Button buttonGhigh;
    private Button buttonAbhigh;
    private Button buttonScale;
    private Button buttonEscale;
    private Button buttonTwinkle;
    private Button buttonNever;


    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteEb;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteAb;
    private int noteAhigh;
    private int noteBbhigh;
    private int noteBhigh;
    private int noteChigh;
    private int noteCshigh;
    private int noteDhigh;
    private int noteEbhigh;
    private int noteEhigh;
    private int noteFhigh;
    private int noteFshigh;
    private int noteGhigh;
    private int noteAbhigh;

    private Map<Integer, Integer> noteMap;

    private int scale;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int WHOLE_NOTE = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map, you store a key:value pair
        //the key is the buttonId, the value is the noteId
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);


    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs,1);
        noteD = soundPool.load(this, R.raw.scaled,1);
        noteEb = soundPool.load(this, R.raw.scaleds,1);
        noteE = soundPool.load(this, R.raw.scalee,1);
        noteF = soundPool.load(this, R.raw.scalef,1);
        noteFs = soundPool.load(this, R.raw.scalefs,1);
        noteG = soundPool.load(this, R.raw.scaleg,1);
        noteAb = soundPool.load(this, R.raw.scalegs,1);
        noteAhigh = soundPool.load(this, R.raw.scalehigha, 1);
        noteBbhigh = soundPool.load(this, R.raw.scalehighbb, 1);
        noteBhigh = soundPool.load(this, R.raw.scalehighb, 1);
        noteChigh = soundPool.load(this, R.raw.scalehighc, 1);
        noteCshigh = soundPool.load(this, R.raw.scalehighcs, 1);
        noteDhigh = soundPool.load(this, R.raw.scalehighd, 1);
        noteEbhigh = soundPool.load(this, R.raw.scalehighds, 1);
        noteEhigh = soundPool.load(this, R.raw.scalehighe, 1);
        noteFhigh = soundPool.load(this, R.raw.scalehighf, 1);
        noteFshigh = soundPool.load(this, R.raw.scalehighfs, 1);
        noteGhigh = soundPool.load(this, R.raw.scalehighg, 1);
        noteAbhigh = soundPool.load(this, R.raw.scalehighgs, 1);


    }

    private void setListeners() {
        KeyboardNoteListener noteListener= new KeyboardNoteListener();
        buttonA.setOnClickListener(this);
        buttonBb.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonCs.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonEb.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonFs.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonAb.setOnClickListener(this);
        buttonAhigh.setOnClickListener(this);
        buttonBbhigh.setOnClickListener(this);
        buttonBhigh.setOnClickListener(this);
        buttonChigh.setOnClickListener(this);
        buttonCshigh.setOnClickListener(this);
        buttonDhigh.setOnClickListener(this);
        buttonEbhigh.setOnClickListener(this);
        buttonEhigh.setOnClickListener(this);
        buttonFhigh.setOnClickListener(this);
        buttonFshigh.setOnClickListener(this);
        buttonGhigh.setOnClickListener(this);
        buttonAbhigh.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonEscale.setOnClickListener(this);
        buttonTwinkle.setOnClickListener(this);
        buttonNever.setOnClickListener(this);


    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonScale = findViewById(R.id.button_synth_scale);
        buttonEscale = findViewById(R.id.button_synth_escale);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonEb = findViewById(R.id.button_synth_eb);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonAb = findViewById(R.id.button_synth_ab);
        buttonAhigh = findViewById(R.id.button_synth_ahigh);
        buttonBbhigh = findViewById(R.id.button_synth_bbhigh);
        buttonBhigh = findViewById(R.id.button_synth_bhigh);
        buttonChigh = findViewById(R.id.button_synth_chigh);
        buttonCshigh = findViewById(R.id.button_synth_cshigh);
        buttonDhigh = findViewById(R.id.button_synth_dhigh);
        buttonEbhigh = findViewById(R.id.button_synth_ebhigh);
        buttonEhigh = findViewById(R.id.button_synth_ehigh);
        buttonFhigh = findViewById(R.id.button_synth_fhigh);
        buttonFshigh = findViewById(R.id.button_synth_fshigh);
        buttonGhigh = findViewById(R.id.button_synth_ghigh);
        buttonAbhigh = findViewById(R.id.button_synth_abhigh);
        buttonTwinkle = findViewById(R.id.button_synth_twinkle);
        buttonNever = findViewById(R.id.button_synth_never);
    }

    @Override
    public void onClick(View view) {
        //one method to handle the clicks of all the buttons but don't forget to tell the buttons
        //who is doing the listening.
        switch (view.getId()) {
            case R.id.button_synth_a:
                soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_synth_bb:
                soundPool.play(noteBb, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "Bb", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_synth_b:
                soundPool.play(noteB, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_synth_c:
                soundPool.play(noteC, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_cs:
                soundPool.play(noteCs, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_d:
                soundPool.play(noteD, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_eb:
                soundPool.play(noteEb, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_e:
                soundPool.play(noteE, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_f:
                soundPool.play(noteF, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_fs:
                soundPool.play(noteFs, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_g:
                soundPool.play(noteG, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_ab:
                soundPool.play(noteAb, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_ahigh:
                soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_bbhigh:
                soundPool.play(noteBbhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_bhigh:
                soundPool.play(noteBhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_chigh:
                soundPool.play(noteChigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_cshigh:
                soundPool.play(noteCshigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_dhigh:
                soundPool.play(noteDhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_ebhigh:
                soundPool.play(noteEbhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_synth_ehigh:
                soundPool.play(noteEhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_fhigh:
                soundPool.play(noteFhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_fshigh:
                soundPool.play(noteFshigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_ghigh:
                soundPool.play(noteGhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
                case R.id.button_synth_abhigh:
                soundPool.play(noteAbhigh, 1.0f, 1.0f, 1, 0, 1.0f);
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synth_escale:
                playEscale();
                break;
            case R.id.button_synth_twinkle:
                playTwinkle();
                break;
            case R.id.button_synth_never:
                playNever();
                break;

        }
    }

    private void playScale() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note (noteA));
        notes.add(new Note (noteBb));
        notes.add(new Note (noteB, Note.WHOLE_NOTE/2));

        for(Note note: notes) {
            playNote(note);
            delay(note.getDelay());
        }

        soundPool.play(noteA, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, 0, DEFAULT_RATE);

        playNote(noteA);
        delay(WHOLE_NOTE/3);
        playNote(noteBb);
        delay(WHOLE_NOTE/3);
        playNote(noteB);
        delay(WHOLE_NOTE/3);
        playNote(noteC);
        delay(WHOLE_NOTE/3);
        playNote(noteCs);
        delay(WHOLE_NOTE/3);
        playNote(noteD);
        delay(WHOLE_NOTE/3);
        playNote(noteEb);
        delay(WHOLE_NOTE/3);
        playNote(noteE);
        delay(WHOLE_NOTE/3);
        playNote(noteF);
        delay(WHOLE_NOTE/3);
        playNote(noteFs);
        delay(WHOLE_NOTE/3);
        playNote(noteG);
        delay(WHOLE_NOTE/3);
        playNote(noteAb);
        delay(WHOLE_NOTE/3);
        playNote(noteAhigh);


    }

    private void playEscale() {

        playNote(noteE);
        delay(WHOLE_NOTE/3);
        playNote(noteFs);
        delay(WHOLE_NOTE/3);
        playNote(noteAb);
        delay(WHOLE_NOTE/3);
        playNote(noteAhigh);
        delay(WHOLE_NOTE/3);
        playNote(noteBhigh);
        delay(WHOLE_NOTE/3);
        playNote(noteCshigh);
        delay(WHOLE_NOTE/3);
        playNote(noteEbhigh);
        delay(WHOLE_NOTE/3);
        playNote(noteEhigh);

    }


    private void playTwinkle(){
        //1st part of twinkle twinkle
        List<Note> twinkle = new ArrayList<>();
        twinkle.add(new Note(noteAhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteAhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteEhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteEhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteFshigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteFshigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteEhigh,WHOLE_NOTE/1));
        twinkle.add(new Note(noteDhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteDhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteCshigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteCshigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteBhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteBhigh,WHOLE_NOTE/2));
        twinkle.add(new Note(noteAhigh,WHOLE_NOTE/1));

        //second part
        List<Note> twinkle2 = new ArrayList<>();
        twinkle2.add(new Note(noteEhigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteEhigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteDhigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteDhigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteCshigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteCshigh,WHOLE_NOTE/2));
        twinkle2.add(new Note(noteBhigh,WHOLE_NOTE/2));

        Song twinkleTest = new Song(twinkle);
        Song twinkleTest2 = new Song(twinkle2);

    playSong(twinkleTest);
    playSong(twinkleTest2);
    playSong(twinkleTest2);
    playSong(twinkleTest);

    }

    private void playNever(){
        List<Note> never = new ArrayList<>();
        never.add(new Note(noteF,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteG,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteC,(int)(WHOLE_NOTE/4*2)));
        never.add(new Note(noteG,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteAhigh,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteChigh,(int)(WHOLE_NOTE/16*2.25)));
        never.add(new Note(noteBbhigh,(int)(WHOLE_NOTE/16*2.25)));
        never.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never.add(new Note(noteF,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteG,(int)(WHOLE_NOTE/2.66*2)));
        never.add(new Note(noteC,(int)(WHOLE_NOTE/1.5*2)));
        never.add(new Note(noteC,(int)(WHOLE_NOTE/16*2.3)));
        never.add(new Note(noteC,(int)(WHOLE_NOTE/16*2.3)));
        never.add(new Note(noteD,(int)(WHOLE_NOTE/16*2.3)));
        never.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never.add(new Note(noteF,(int)(WHOLE_NOTE/8)));

        List<Note> never2 = new ArrayList<>();
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE*0.625*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteChigh,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteChigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/1.5*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/1.5*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE*0.625*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*0.375*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*0.375*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE*0.1875*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE*0.375*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/1.333*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/1.78*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteChigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteChigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/1.6*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/1.6*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/1.6*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteChigh,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/2*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteAhigh,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*0.375*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE*.1875*2)));
        never2.add(new Note(noteE,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/5.33*2)));
        never2.add(new Note(noteD,(int)(WHOLE_NOTE/16*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteC,(int)(WHOLE_NOTE/8*2)));
        never2.add(new Note(noteG,(int)(WHOLE_NOTE/4*2)));
        never2.add(new Note(noteF,(int)(WHOLE_NOTE/2*2)));





        //FIX DOTTED QUARTER NOTES











        Song neverGonna = new Song(never);
        Song neverGonna2 = new Song(never2);
        playSong(neverGonna);
        playSong(neverGonna);
        playSong(neverGonna2);



    }

    private void playSong(Song i) {
        for (int x = 0; x < i.getNotes().size(); x++)
        {
            playNote(i.getNotes().get(x));
            delay(i.getNotes().get(x).getDelay());
        }
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }

    private void playNote(int note){
        playNote(note, 0);
        }

    private void playNote(Note note){
        playNote(note.getNoteId(), 0);
    }

        private class KeyboardNoteListener implements View.OnClickListener
        {
            @Override
            public void onClick (View view){
                //get the Id of the view that was clicked
                int id = view.getId();
                //use the map to figure out what note to play
                int note = noteMap.get(id);
                //play the note
                playNote(note);
            }
        }
}
