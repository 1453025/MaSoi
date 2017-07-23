package com.example.ngoxuanmanh.masoi.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ngoxuanmanh.masoi.Adapter.NguoiChoiAdapter;
import com.example.ngoxuanmanh.masoi.NguoiChoi;
import com.example.ngoxuanmanh.masoi.R;
import com.example.ngoxuanmanh.masoi.Util.MyUtils;
import com.example.ngoxuanmanh.masoi.dialog.MyDialogFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgoXuanManh on 7/23/2017.
 */

public class SoiFragment extends Fragment implements Step {
    private List<NguoiChoi> nguoiChois = new ArrayList<>();
    private NguoiChoiAdapter nguoiChoiAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_soi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imgbtn_bite);
        imageView.setImageResource(R.drawable.soi_icon);
        MyUtils.prepareRecyclerViewData(nguoiChois);
        nguoiChoiAdapter = new NguoiChoiAdapter(getActivity(), nguoiChois);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(nguoiChoiAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                MyDialogFragment myDialogFragment = MyDialogFragment.newInstance("Ngo xuan manh");
                myDialogFragment.show(fm, null);
            }
        });
    }

    @Override
    public VerificationError verifyStep() {
        //return null if the user can go to the next step, create a new VerificationError instance otherwise
        return null;
    }

    @Override
    public void onSelected() {
        //update UI when selected
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        //handle error inside of the fragment, e.g. show error on EditText
    }

}