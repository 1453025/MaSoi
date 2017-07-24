package com.example.ngoxuanmanh.masoi.Adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;

import com.example.ngoxuanmanh.masoi.Fragment.BaoVeFragment;
import com.example.ngoxuanmanh.masoi.Fragment.CupidFragment;
import com.example.ngoxuanmanh.masoi.Fragment.PhuThuyFragment;
import com.example.ngoxuanmanh.masoi.Fragment.SoiFragment;
import com.example.ngoxuanmanh.masoi.Fragment.ThoSanFragment;
import com.example.ngoxuanmanh.masoi.Fragment.TienTriFragment;
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

        if (TextUtils.equals(heroes.get(position), Key.SOI)) {
            return new SoiFragment();
        }

        if (TextUtils.equals(heroes.get(position), Key.CUPID)) {
            return new CupidFragment();
        }

        if (TextUtils.equals(heroes.get(position), Key.BAO_VE)) {
            return new BaoVeFragment();
        }

        if (TextUtils.equals(heroes.get(position), Key.PHU_THUY)) {
            return new PhuThuyFragment();
        }

        if (TextUtils.equals(heroes.get(position), Key.TIEN_TRI)) {
            return new TienTriFragment();
        }

        if (TextUtils.equals(heroes.get(position), Key.THO_SAN)) {
            return new ThoSanFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return heroes.size(); // wolf alway exist
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle(R.string.tab_title);
        if (TextUtils.equals(heroes.get(position), Key.SOI)) {
            builder.setTitle(Key.SOI)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Cancel")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }

        if (TextUtils.equals(heroes.get(position), Key.CUPID)) {
            builder.setTitle(Key.CUPID)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Back")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }

        if (TextUtils.equals(heroes.get(position), Key.BAO_VE)) {
            builder.setTitle(Key.BAO_VE)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Back")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }

        if (TextUtils.equals(heroes.get(position), Key.PHU_THUY)) {
            builder.setTitle(Key.PHU_THUY)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Back")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }

        if (TextUtils.equals(heroes.get(position), Key.TIEN_TRI)) {
            builder.setTitle(Key.TIEN_TRI)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Back")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }

        if (TextUtils.equals(heroes.get(position), Key.THO_SAN)) {
            builder.setTitle(Key.THO_SAN)
                    .setNextButtonLabel("This way")
                    .setBackButtonLabel("Back")
                    .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
        }
        return builder.create();
    }
}