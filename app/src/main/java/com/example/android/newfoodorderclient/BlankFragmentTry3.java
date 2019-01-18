package com.example.android.newfoodorderclient;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class BlankFragmentTry3 extends Fragment  {

    private RecyclerView mFoodList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    //  private ShimmerFrameLayout mShimmerViewContainer;

    private FirebaseAuth.AuthStateListener mAuthListener;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragmentTry3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v = inflater.inflate(R.layout.fragment_blank_fragment_try3, container, false);
        // return


        // mFoodList = (RecyclerView) findViewById(R.id.foodList);
        mFoodList = (RecyclerView) v.findViewById(R.id.foodList);

        //RecyclerView mFoodList = new RecyclerView(getContext());
        mFoodList.setHasFixedSize(true);
        // mFoodList.setLayoutManager(new LinearLayoutManager(getContext()));

        //final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //rv.setLayoutManager(new LinearLayoutManager(getContext()));

        mFoodList.setLayoutManager(new LinearLayoutManager(getContext()));

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Dessert");

        //shimmer
        // mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //not logged in
                // if (firebaseAuth.getCurrentUser() == null) {
                //   Intent loginIntent = new Intent(Starters.this, MainActivity.class);
                //disables back button
                // loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //startActivity(loginIntent);
                //}
            }
        };

        return v;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentTry.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentTry3 newInstance(String param1, String param2) {
        BlankFragmentTry3 fragment = new BlankFragmentTry3();
        Bundle args = new Bundle();
        // args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  if (getArguments() != null) {
        //    mParam1 = getArguments().getString(ARG_PARAM1);
        //  mParam2 = getArguments().getString(ARG_PARAM2);
        //}

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        //add dependencies to gradle app
        FirebaseRecyclerAdapter<Food, Starters.FoodViewHolder> FBRA = new FirebaseRecyclerAdapter<Food, Starters.FoodViewHolder>
                (Food.class,
                        R.layout.singlemenuitem,
                        Starters.FoodViewHolder.class,
                        mDatabase) {

            @Override
            protected void populateViewHolder(Starters.FoodViewHolder viewHolder, Food model, int position) {
                viewHolder.setName(model.getName());
                viewHolder.setPrice(model.getPrice());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getActivity().getApplicationContext(), model.getImage());

                //get users clicked items
                final String food_key = getRef(position).getKey().toString();
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent singleFoodActivity = new Intent(getActivity(), SingleFoodActivityDessert.class);
                        singleFoodActivity.putExtra("FoodId", food_key);
                        startActivity(singleFoodActivity);

                        //startActivity(intent);
                    }
                });
            }
        };

        mFoodList.setAdapter(FBRA);
    }



    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public FoodViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String name) {
            TextView food_name = (TextView) mView.findViewById(R.id.foodName);
            food_name.setText(name);

        }

        public void setImage(Context ctx, String image) {
            ImageView food_image = (ImageView) mView.findViewById(R.id.foodImage);
            //add Picasso dependency
            Picasso.with(ctx).load(image).into(food_image);
        }

        public void setDesc(String desc) {
            TextView food_desc = (TextView) mView.findViewById(R.id.foodDesc);
            food_desc.setText(desc);
        }

        public void setPrice(String price) {
            TextView food_price = (TextView) mView.findViewById(R.id.foodPrice);
            food_price.setText(price);
        }
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //  mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //  void onFragmentInteraction(Uri uri);
    }
}
