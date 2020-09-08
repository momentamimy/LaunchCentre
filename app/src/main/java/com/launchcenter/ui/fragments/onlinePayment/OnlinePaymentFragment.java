package com.launchcenter.ui.fragments.onlinePayment;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.launchcenter.R;

public class OnlinePaymentFragment extends Fragment {

    private OnlinePaymentViewModel mViewModel;

    SwitchCompat saveCreditSwitch;
    ImageView credit_card_img, credit_card_arrow;
    ImageView paypal_img, paypal_arrow;
    Button ConfirmBtn;
    LinearLayout credit_card_layout,paypal_layout,save_details_layput;

    public static OnlinePaymentFragment newInstance() {
        return new OnlinePaymentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.online_payment_fragment, container, false);

        getActivity().findViewById(R.id.navigation_bottom_frame).setVisibility(View.VISIBLE);


        credit_card_img=view.findViewById(R.id.credit_card_img);
        credit_card_arrow=view.findViewById(R.id.credit_card_arrow);
        credit_card_layout=view.findViewById(R.id.credit_card_layout);
        ConfirmBtn=view.findViewById(R.id.ConfirmBtn);
        //save_details_layput=view.findViewById(R.id.save_details_layput);

        paypal_img=view.findViewById(R.id.paypal_img);
        paypal_arrow=view.findViewById(R.id.paypal_arrow);
        paypal_layout=view.findViewById(R.id.paypal_layout);


        credit_card_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit_card_arrow.setVisibility(View.VISIBLE);
                credit_card_layout.setVisibility(View.VISIBLE);
                ConfirmBtn.setVisibility(View.VISIBLE);
              //  save_details_layput.setVisibility(View.VISIBLE);

                paypal_arrow.setVisibility(View.GONE);
                paypal_layout.setVisibility(View.GONE);
            }
        });

        paypal_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit_card_arrow.setVisibility(View.GONE);
                credit_card_layout.setVisibility(View.GONE);
                ConfirmBtn.setVisibility(View.GONE);
               // save_details_layput.setVisibility(View.GONE);


                paypal_arrow.setVisibility(View.VISIBLE);
                paypal_layout.setVisibility(View.VISIBLE);
            }
        });



        saveCreditSwitch=view.findViewById(R.id.saveCreditSwitch);
        saveCreditSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    saveCreditSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.black_rounded_btn));
                    saveCreditSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_white_thumb));
                }else{
                    saveCreditSwitch.setBackground(getActivity().getResources().getDrawable(R.drawable.switch_white_background));
                    saveCreditSwitch.setThumbDrawable(getActivity().getResources().getDrawable(R.drawable.ic_dot));
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OnlinePaymentViewModel.class);
        // TODO: Use the ViewModel
    }

}