package com.example.tracnghiemta.slide;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.tracnghiemta.R;
import com.example.tracnghiemta.question.Question;

import java.util.ArrayList;

public class ModelScreen {
    public ModelScreen(ModelInterface callback) {
        this.callback = callback;
    }

    public ModelScreen(Context context) {
        this.context = context;
    }

    ModelInterface callback;
    private Context context;
    private int checkAns;
    private TextView tvKiemtra;
    private TextView tvXemDiem;
    private TextView tvTimer;

    public void re_checkAnswer(ArrayList<Question> arr_Ques, GridView gvLsQuestion, final ViewPager mPager, final ScreenSlideActivity.CounterClass timer) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.check_answer_dialog);
        dialog.setTitle("Danh sách câu trả lời");

        CheckAnswerAdapter answerAdapter = new CheckAnswerAdapter(arr_Ques, context);
        gvLsQuestion = dialog.findViewById(R.id.gvLsQuestion);
        gvLsQuestion.setAdapter(answerAdapter);

        gvLsQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });

        Button btnCancle, btnFinish;
        btnCancle = dialog.findViewById(R.id.btnCancle);
        btnFinish = dialog.findViewById(R.id.btnFinish);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                re_result(mPager,checkAns,tvKiemtra,tvTimer,tvXemDiem);
                dialog.dismiss();
            }
        });

        dialog.show();
        callback.oncheckAnserr();

    }

    public void re_result(final ViewPager mPager, int checkAns, TextView tvKiemtra, TextView tvTimer, TextView tvXemDiem) {
        checkAns = 1;
        if (mPager.getCurrentItem() >= 4) mPager.setCurrentItem(mPager.getCurrentItem() - 4);
        else if (mPager.getCurrentItem() <= 4) mPager.setCurrentItem(mPager.getCurrentItem() + 4);
        tvXemDiem.setVisibility(View.VISIBLE);
        tvKiemtra.setVisibility(View.GONE);
    }
}
