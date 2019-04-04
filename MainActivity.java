package com.example.user.ads_assignment;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1,nm,ar,cont;
    EditText txt2;
    Button kmp;
    int kk=0;
    int jk=0;
    int ik=0;
    int flg=0;
    int knt=0;
    String pat,txt;
    SpannableStringBuilder sbe;
    SpannableStringBuilder sb = new SpannableStringBuilder("There are various sports and games which are played at both national and international level such as basket ball, football, tennis, cricket, volleyball, hockey, squash, badminton, table tennis, kabaddi, Polo and so many. Though, some of the sports and games are played in many countries however they are unique, particular and famous especially for one country such as kabaddi, chess, and snooker were originated in India and played with much interest. Other famous games in India are badminton, hockey, football, etc. Cricket is also played by the players at national and international level with much interest but it does not have its origin in India. All the sports and games play an important role in the physical and mental development of the children.\n" +
            "Playing games and sports gives various nice results with combo pack of exercise and excitement. Some of the people play it for their interest to get fit and healthy whereas some people play it to make their career in this field. Being involved in sports and games, whether to make career or only for an hour a day, improve confidence, boost personality and provide a good deal of excitement and entertainment in the life. It fills with zeal and lot of excitement to both, players and spectators due to the suspense and unexpected turns.");

    // Span to set text color to some RGB value
    ForegroundColorSpan fcsr = new ForegroundColorSpan(Color.rgb(255, 0, 0));
    ForegroundColorSpan fcsg = new ForegroundColorSpan(Color.rgb(0, 255, 0));

    private class iset extends AsyncTask<String, Integer, Long> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Long doInBackground(String... urls) {
            //    txtView.setText("Testing");    here I am getting the error
            Long x = (long) 0;
         while(true){
            if (flg == 1) {
                knt=0;
                sbe = new SpannableStringBuilder(pat);
                sb.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sbe.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sb.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sbe.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                publishProgress(2);
                int M = pat.length();
                int N = txt.length();

                String ss = "";
                // create lps[] that will hold the longest
                // prefix suffix values for pattern
                int lps[] = new int[M];
                int j = 0;
                computeLPSArray(pat, M, lps);
                int kk=0,ik=0;
                while (ik < N) {
                    if (flg != 1) break;
                    sb.setSpan(fcsr, kk, ik + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    if (pat.charAt(j) == txt.charAt(ik)) {
                        j++;
                        ik++;
                        sbe.setSpan(fcsg, 0, j, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                    if (j == M) {
                        knt++;
                        j = lps[j - 1];
                        sb.setSpan(fcsg, ik - M, ik, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        sbe.setSpan(fcsg, 0, M, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sbe.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        //   kk=0;
                    }

                    // mismatch after j matches
                    else if (ik < N && pat.charAt(j) != txt.charAt(ik)) {
                        if (j != 0)
                            j = lps[j - 1];
                        else
                            ik = ik + 1;
                        kk = ik;
                        sbe.setSpan(fcsg, 0, j, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(ik>=N)flg=3;
                }

            }

            while (flg == 3) {
            }
            if (flg == 2) {
                knt=0;
                sbe = new SpannableStringBuilder(pat);
                sb.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sbe.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sb.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                sbe.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                publishProgress(2);


                int NO_OF_CHARS = 256;
                char txt1[] = txt.toCharArray();
                char pat1[] = pat.toCharArray();
                int m = pat.length();
                int n = txt.length();

                int badchar[] = new int[NO_OF_CHARS];
                badCharHeuristic(pat, m, badchar);

                int s = 0;  // s is shift of the pattern with
                // respect to text
                while (s <= (n - m)) {

                    if (flg != 2)
                        break;
                    int j = m - 1;
                    sb.setSpan(fcsr, s + j, s + j + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    sbe.setSpan(fcsg, 0, 0 , Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    publishProgress(2);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int tmpj = j;
                    while (j >= 0 && pat1[j] == txt1[s + j]) {
                        if (flg != 2)
                            break;
                        j--;
                        sb.setSpan(fcsr, s + j, s + tmpj + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        sbe.setSpan(fcsg, max(0, j+1), tmpj + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (j < 0) {
                        //System.out.println("Patterns occur at shift = " + s);
                        knt++;
                        sb.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        sb.setSpan(fcsg, s, s + m, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        sbe.setSpan(fcsg, 0, m, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//                        sbe.setSpan(fcsg, 0, M, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sbe.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        publishProgress(2);
                        s += (s + m < n) ? m - badchar[txt1[s + m]] : 1;

                    } else
                        s += max(1, j - badchar[txt1[s + j]]);
                    if(s>(n-m))flg=3;
                }


            }
            while (flg == 3) {
            }
        }
            //return x;
        }

    @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(2);
            txt1.setText(sb);
            txt2.setText(sbe);
            cont.setText(Integer.toString(knt));
        }

        @Override
        protected void onPostExecute(Long result) {

        }
    }
    private class iset1 extends AsyncTask<String, Integer, Long> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Long doInBackground(String... urls) {
            //    txtView.setText("Testing");    here I am getting the error
            Long x=(long)0;

            return x;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(2);
            txt1.setText(sb);
            txt2.setText(sbe);
        }

        @Override
        protected void onPostExecute(Long result) {

        }
    }
    int max(int a,int b){
        return (a > b)? a: b;
    }
    void badCharHeuristic( String str1, int size,int badchar[])
    {   char str[]=str1.toCharArray();
        int i;
        for (i = 0; i < 256; i++)
            badchar[i] = -1;
        for (i = 0; i < size; i++)
            badchar[(int)str[i]] = i;
        String tmp="";
        for(i=0;i<size;i++){
            tmp+=pat.charAt(i);
            tmp+=" ";
        }
        tmp+="\n";
        for(i=0;i<size;i++){
            int stk=size-1-badchar[(int)str[i]];
            if(stk==0)stk=size;
            tmp+=Integer.toString(stk);
            tmp+=" ";
        }
        nm.setText("         String:\n       IndexArray:");
        ar.setText(tmp);
    }
    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;
        String stmp="";
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        for(i=0;i<M;i++){
            stmp+=pat.charAt(i);
            stmp+=" ";
        }
        stmp+="\n";
        for(i=0;i<M;i++){
            stmp+=Integer.toString(lps[i]);
            stmp+=" ";
        }
        nm.setText("         String:\n        LPS Array:");
        ar.setText(stmp);
    }
    iset ist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt);
        kmp=findViewById(R.id.kmp);
        txt2=findViewById(R.id.txt2);
        nm=findViewById(R.id.name);
        ar=findViewById(R.id.array);
        cont=findViewById(R.id.cont);
        txt="There are various sports and games which are played at both national and international level such as basket ball, football, tennis, cricket, volleyball, hockey, squash, badminton, table tennis, kabaddi, Polo and so many. Though, some of the sports and games are played in many countries however they are unique, particular and famous especially for one country such as kabaddi, chess, and snooker were originated in India and played with much interest. Other famous games in India are badminton, hockey, football, etc. Cricket is also played by the players at national and international level with much interest but it does not have its origin in India. All the sports and games play an important role in the physical and mental development of the children.\n" +

                "Playing games and sports gives various nice results with combo pack of exercise and excitement. Some of the people play it for their interest to get fit and healthy whereas some people play it to make their career in this field. Being involved in sports and games, whether to make career or only for an hour a day, improve confidence, boost personality and provide a good deal of excitement and entertainment in the life. It fills with zeal and lot of excitement to both, players and spectators due to the suspense and unexpected turns.";
        txt1.setText(txt);
        ist=new iset();
        cont.setText("0");
    }
    public void kmpclick(View v){
        pat=txt2.getText().toString();
        int x=flg;
        flg=1;
        if(x==0)
            ist.execute("");
    }
    public void boyer(View v) {
        pat=txt2.getText().toString();
        int y=flg;
        flg=2;
        if(y==0)
            ist.execute("");
    }
    public void crossclick(View v) {
        sbe = new SpannableStringBuilder(pat);
        sb.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sbe.setSpan(fcsg, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sbe.setSpan(fcsr, 0, 0, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        txt2.setText("");
        flg=3;
    }
}

