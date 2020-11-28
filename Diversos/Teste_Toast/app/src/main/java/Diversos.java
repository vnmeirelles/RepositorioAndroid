
import android.os.Parcelable;
import android.os.Parcel;

public class Diversos implements Parcelable {
    public String nome;
    public int idade;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(idade);
    }

    private Diversos(Parcel from){
        idade = from.readInt();
        nome = from.readString();
    }

    public Diversos(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Diversos>
            CREATOR = new Parcelable.Creator<Diversos>(){

        public Diversos createFromParcel(Parcel in){
            return new Diversos(in);
        }
        public Diversos[] newArray(int size){
            return new Diversos[size];
        }
    };

}