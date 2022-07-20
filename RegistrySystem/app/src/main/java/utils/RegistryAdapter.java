package utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registrysystem.R;

import java.util.List;

public class RegistryAdapter extends RecyclerView.Adapter<RegistryAdapter.MyViewHolder> {

    String names[], surnames[];
    Context context;

    public RegistryAdapter(Context ct, String s1[], String s2[]){
        context = ct;
        names = s1;
        surnames = s2;


    }

    public void setFilteredList(List<String> Names, List<String> Surnames){
        this.names = Names.toArray(new String[Names.size()]);
        this.surnames = Surnames.toArray(new String[Surnames.size()]);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Name.setText(names[position]);
        holder.Surname.setText(surnames[position]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Name, Surname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Surname = itemView.findViewById(R.id.surname);
        }
    }
}
