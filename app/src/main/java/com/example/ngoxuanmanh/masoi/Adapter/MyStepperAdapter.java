package com.example.ngoxuanmanh.masoi.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.ngoxuanmanh.masoi.Fragment.DelayedTransitionStepFragmentSample;
import com.example.ngoxuanmanh.masoi.Fragment.SoiFragment;
import com.example.ngoxuanmanh.masoi.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by NgoXuanManh on 7/23/2017.
 */

public class MyStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "A";

    public MyStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {

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
                DelayedTransitionStepFragmentSample stepFragmentSample = null;
                stepFragmentSample = new DelayedTransitionStepFragmentSample();
                return stepFragmentSample;
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
                DelayedTransitionStepFragmentSample stepFragmentSample = null;
                stepFragmentSample = new DelayedTransitionStepFragmentSample();
                return stepFragmentSample;
            }
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);

        }
    }

    @Override
    public int getCount() {
        return 4;
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