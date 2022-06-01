import java.util.Objects;

public class VolumeFlask extends Item implements Supplier,Equipment {
    public int volume;
    public VolumeFlask(int availableQuantity,double unitPrice,int volume){
        super(unitPrice, availableQuantity);
        this.volume=volume;
    }
    public int getVolume(){
        int volume= this.volume;
        return volume;
    }
@Override
    public String toString(){
        return "VolumeFlask{" +
                "volume=" + volume +
                '}' ;
}
@Override
    public int hashCode() {
        return Objects.hash(getVolume());
}
@Override
    public boolean equals(Object o){
        if (this== o) return true;
    if (!(o instanceof VolumeFlask)) return false;
    VolumeFlask volumeFlask = (VolumeFlask) o;
    return getVolume()== volumeFlask.getVolume();
}
}
