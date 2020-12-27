package com.suse.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * @author liujing
 * @version 1.0
 * @date 2020/12/27 11:46
 */
public class CrimePhotoDialogFragment extends DialogFragment {
    private static final String ARG_IMAGE = "image";
    private ImageView mImageView;

    public static CrimePhotoDialogFragment newInstance(String imagePath){
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE,imagePath);
        CrimePhotoDialogFragment fragment = new CrimePhotoDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String imagePath = getArguments().getString(ARG_IMAGE);
        Bitmap bitmap = PictureUtils.getScaledBitmap(imagePath,getActivity());
        mImageView = (ImageView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo,null);
        mImageView.setImageBitmap(bitmap);
        mImageView.setOnClickListener((vew)-> getDialog().dismiss());
        return new AlertDialog.Builder(getActivity()).setView(mImageView).create();
    }
}
