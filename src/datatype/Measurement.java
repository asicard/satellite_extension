package datatype;

public class Measurement {

    private Status status;
    private Data data;

    public Measurement() {
        this.status = Status.KO;
        this.data = new Data();
    }

    public Status getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public void setStatus(Status stat) {
        this.status = stat;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
