package radial_design.recycleralpha;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    CustomItemClickListener cicl;
    static public int qn;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView catNname;
        ImageView questionPhoto;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            catNname = (TextView)itemView.findViewById(R.id.item_kind);
            questionPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
        }
    }


    List<Question> Qestions;

    RVAdapter(List<Question> qestions){
        this.Qestions = qestions;
    }

    public void setCICL(CustomItemClickListener CustomICL){
        cicl=CustomICL;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        final PersonViewHolder pvh = new PersonViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cicl.onItemClick(v, pvh.getPosition());
            }
        });

        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.catNname.setText(Qestions.get(i).cat);
        personViewHolder.questionPhoto.setImageResource(Qestions.get(i).photoId);
    }


    @Override
    public int getItemCount() {
        return Qestions.size();
    }


    //onclick addition
    public interface CustomItemClickListener {
        public void onItemClick(View v, int position);
    }
}