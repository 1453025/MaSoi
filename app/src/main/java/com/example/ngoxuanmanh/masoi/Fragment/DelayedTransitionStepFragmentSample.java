package com.example.ngoxuanmanh.masoi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngoxuanmanh.masoi.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

/**
 * Created by NgoXuanManh on 7/23/2017.
 */

public class DelayedTransitionStepFragmentSample extends Fragment implements BlockingStep {

    private static final String TAG = DelayedTransitionStepFragmentSample.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cupid, container, false);
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        Log.d(TAG, "onNextClicked: ");
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        Log.d(TAG, "onCompleteClicked: ");
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        Log.d(TAG, "onBackClicked: ");
        callback.goToPrevStep();
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        Log.d(TAG, "onSelected: ");
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Log.d(TAG, "onError: ");
    }
}