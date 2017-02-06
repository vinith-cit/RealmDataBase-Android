package com.example.vinith.realmtask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.Realm;

/**
 * Created by sony on 20-Oct-16.
 */


public class StudentAdapter extends RealmRecyclerViewAdapter<Student> {

    final Context context;
    private Realm realm;

    public StudentAdapter(Context context) {

        this.context = context;
    }

    // create new views (invoked by the layout manager)
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate a new card view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new StudentViewHolder(view);
    }

    // replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {

        realm = RealmController.getInstance().getRealm();

        // get the student record
        final Student student = getItem(position);
        // cast the generic view holder to our specific one
        final StudentViewHolder holder = (StudentViewHolder) viewHolder;

        holder.id.setText(String.valueOf(student.getId()));

        holder.name.setText(student.getName());
        holder.age.setText(String.valueOf(student.getAge()));


    }

    // return the size of your data set (invoked by the layout manager)
    public int getItemCount() {

        if (getRealmAdapter() != null) {
            return getRealmAdapter().getCount();
        }
        return 0;
    }

    /**
     * Student view holder for initialzing all views
     */
    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView age;
        public TextView id;

        public StudentViewHolder(View itemView) {
            // standard view holder pattern with Butterknife view injection
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_name);
            age = (TextView) itemView.findViewById(R.id.tv_age);
            id = (TextView) itemView.findViewById(R.id.tv_id);
        }
    }
}