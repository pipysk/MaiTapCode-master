package com.example.tracnghiemta.slide;

import android.widget.GridView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.tracnghiemta.question.Question;

import java.util.ArrayList;

public class PresenterScreen implements ModelInterface {
    ModelScreen modelScreen;
    ViewScreen viewScreen;

    public PresenterScreen(ModelScreen modelScreen) {
        this.modelScreen = modelScreen;
    }

    public PresenterScreen() {

    }

    public void checkAnswer(ArrayList<Question> arr_Ques, GridView gvLsQuestion, ViewPager mPager, ScreenSlideActivity.CounterClass timer) {
//anh xa model
        modelScreen = new ModelScreen(this);
        modelScreen.re_checkAnswer(arr_Ques, gvLsQuestion, mPager, timer);
    }

    public void result(final ViewPager mPager, int checkAns, TextView tvKiemtra, TextView tvTimer, TextView tvXemDiem) {
        modelScreen.re_result(mPager, checkAns, tvKiemtra, tvTimer, tvXemDiem);
    }

    @Override
    public void oncheckAnserr() {
        viewScreen.oncheckAnswertc();
    }

    @Override
    public void onresult() {

    }
}
