package com.example.ngoxuanmanh.masoi.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;

import com.example.ngoxuanmanh.masoi.Fragment.BaoVeFragment;
import com.example.ngoxuanmanh.masoi.Fragment.SoiFragment;
import com.example.ngoxuanmanh.masoi.R;
import com.example.ngoxuanmanh.masoi.Util.Key;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.ArrayList;

/**
 * Created by NgoXuanManh on 7/23/2017.
 */

public class MyStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "A";
    private ArrayList<String> heroes;

    public MyStepperAdapter(FragmentManager fm, Context context, ArrayList<String> heroes) {
        super(fm, context);
        this.heroes = heroes;
    }

    @Override
    public Step createStep(int position) {

        for (int i = 0; i < heroes.size(); i++) {
            if (TextUtils.equals(heroes.get(i), Key.BAO_VE)) {
                return new BaoVeFragment();
            }


        }
        switch (position) {
            case 0: {
                SoiFragment step = null;
                step = new SoiFragment();
                Bundle b = new Bundle();
                b.putInt(CURRENT_STEP_POSITION_KEY, position);
                step.setArguments(b);
                return step;
            }
            case 1: {
            }
            case 2: {
                SoiFragment step = null;
                step = new SoiFragment();
                Bundle b = new Bundle();
                b.putInt(CURRENT_STEP_POSITION_KEY, position);
                step.setArguments(b);
                return step;
            }
            case 3: {
            }
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);

        }


    }

    @Override
    public int getCount() {
        return heroes.size() + 1; // wolf alway exist
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle(R.string.tab_title);
        switch (position) {
            case 0:
                builder
                        .setTitle("Manh")
                        .setNextButtonLabel("This way")
                        .setBackButtonLabel("Cancel")
                        .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
                break;
            case 1:
                builder
                        .setTitle("Ngo")
                        .setNextButtonLabel("This way")
                        .setBackButtonLabel("Go to first");
                break;
            case 2:
                builder
                        .setTitle("Xuan")
                        .setNextButtonLabel("This way")
                        .setBackButtonLabel("Go back");
                break;
            case 3:
                builder
                        .setTitle("Xuan")
                        .setNextButtonLabel(R.string.go_to_summary)
                        .setBackButtonLabel("Go back");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }
}