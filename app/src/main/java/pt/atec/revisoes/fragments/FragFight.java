package pt.atec.revisoes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import pt.atec.revisoes.R;
import pt.atec.revisoes.modelo.Arma;
import pt.atec.revisoes.modelo.Monstro;

/**
 * Created by eu on 19-10-2016.
 */
public class FragFight extends Fragment {
    ImageView       mEnemy;
    TextView        mHpEnemy;
    RecyclerView    mRecycler;

    Monstro mMonster;

    public FragFight(){

    }

    public FragFight(Monstro m) {
        this.mMonster = m;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_fight, container, false);

        mEnemy = (ImageView) v.findViewById(R.id.fight_img);
        mHpEnemy = (TextView) v.findViewById(R.id.fight_hp);
        mRecycler = (RecyclerView) v.findViewById(R.id.fight_rv);

        mEnemy.setImageResource(mMonster.getImage());
        mHpEnemy.setText(String.valueOf(mMonster.getHp()));

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Arma espadaConan = new Arma(R.drawable.sword, "Espada do Conan", 20 );
        Arma arma2 = new Arma(R.drawable.crossbow, "Besta do Conan", 15 );
        Arma arma3 = new Arma(R.drawable.yuna_staff, "Yuna do Conan", 30 );
        Arma arma4 = new Arma(R.drawable.alien_sword, "Alien do Conan", 40 );

        ArrayList<Arma> ararma = new ArrayList<>();
        ararma.add(espadaConan);
        ararma.add(arma2);
        ararma.add(arma3);
        ararma.add(arma4);

        AAarmas aaarmas = new AAarmas(ararma);

        mRecycler.setAdapter(aaarmas);

        return v;
    }

    public class AAarmas extends Adapter<AAarmas.VHarma>
    {
        ArrayList<Arma> mDataset;

        public AAarmas(ArrayList<Arma> ar) {
            this.mDataset = ar;
        }

        @Override
        public VHarma onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_arma, parent, false);

            return new VHarma(v);
        }

        @Override
        public void onBindViewHolder(VHarma holder, int position) {
            holder.setData(mDataset.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class VHarma extends ViewHolder {
            ImageView   mImgArma;
            TextView    mNomeArma;
            TextView    mAtaque;

            public VHarma(View itemView) {
                super(itemView);
                mImgArma = (ImageView) itemView.findViewById(R.id.card_img);
                mNomeArma = (TextView) itemView.findViewById(R.id.card_arma);
                mAtaque = (TextView) itemView.findViewById(R.id.card_ataque);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int newHP = Integer.valueOf(mHpEnemy.getText().toString()) -
                                Integer.valueOf(mAtaque.getText().toString());
                        mHpEnemy.setText(String.valueOf(newHP));
                }
            });
            }

            public void setData(Arma ar) {
                this.mImgArma.setImageResource(ar.getImagem());
                this.mNomeArma.setText(ar.getNome());
                this.mAtaque.setText(String.valueOf(ar.getAtaque()));
            }

            public ImageView getmImgArma() {
                return mImgArma;
            }

            public void setmImgArma(ImageView mImgArma) {
                this.mImgArma = mImgArma;
            }

            public TextView getmNomeArma() {
                return mNomeArma;
            }

            public void setmNomeArma(TextView mNomeArma) {
                this.mNomeArma = mNomeArma;
            }

            public TextView getmAtaque() {
                return mAtaque;
            }

            public void setmAtaque(TextView mAtaque) {
                this.mAtaque = mAtaque;
            }
        }
    }
}
